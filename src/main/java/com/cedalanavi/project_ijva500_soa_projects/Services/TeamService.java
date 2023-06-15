package com.cedalanavi.project_ijva500_soa_projects.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.TeamGetRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.TeamUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.ProjectRepository;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TeamRepository;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TypeTeamRepository;

@Service
public class TeamService {
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private TypeTeamRepository typeTeamRepository;
	@Autowired
	private TypeTeamService typeTeamService;
	
	public List<TeamGetRequest> getAll() {
		List<Team> teams = teamRepository.findAll();
		List<TeamGetRequest> teamsGetRequest = new ArrayList<>();
		for (Team team : teams) {
			TeamGetRequest teamGetRequest = new TeamGetRequest();
			teamGetRequest.setId(team.getId());
			teamGetRequest.setName(team.getName());
			teamGetRequest.setTypeTeam(typeTeamRepository.findById(team.getTeamTypeId()).get());
			teamGetRequest.setUsersIds(team.getUsersIds());
			teamsGetRequest.add(teamGetRequest);
		}
		return teamsGetRequest;
	}

	public Team create(TeamCreateRequest teamRequest){
		// Création et enregistrement de l'équipe
		Team team = new Team();
		if (teamRequest.name == null || teamRequest.name.length() == 0) return null;
		if (teamRequest.teamTypeId == 0 || !typeTeamService.existsById(teamRequest.teamTypeId))	return null;
		team.setName(teamRequest.name);
		team.setTeamTypeId(teamRequest.teamTypeId);
		team.setUsersIds(teamRequest.usersIds);
		return teamRepository.save(team);
	}

	public List<Team> getAllByProjectId(Integer project_id) {
		return teamRepository.findAllByProjectId(project_id);
	}

	public Team addUser(int team_id, String user_id) {
		Team updatedTeam = teamRepository.findById(team_id).get();
		updatedTeam.setUserId(user_id);
		teamRepository.save(updatedTeam);
		return updatedTeam;
	}

	public Team setUsers(int team_id, TeamUpdateRequest teamUpdateUsersRequest) {
		Team updatedTeam = teamRepository.findById(team_id).get();
		updatedTeam.setUsersIds(teamUpdateUsersRequest.usersIds);
		teamRepository.save(updatedTeam);
		return null;
	}

	public Team update(int team_id, TeamUpdateRequest teamUpdateRequest) {
		Team updatedTeam = new Team();
		updatedTeam.setId(teamUpdateRequest.id);
		updatedTeam.setName(teamUpdateRequest.name);
		updatedTeam.setTeamTypeId(teamUpdateRequest.teamTypeId);
		updatedTeam.setUsersIds(teamUpdateRequest.usersIds);
		try {			
			updatedTeam.setProject(projectRepository.findById(teamUpdateRequest.projectId).get());
		}catch(Exception e) {
			return null;
		}
		return teamRepository.save(updatedTeam);
	}
}
