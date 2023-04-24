package com.cedalanavi.project_ijva500_soa_projects.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private TypeTeamService typeTeamService;
	@Autowired
	private ProjectService projectService;
	
	public List<Team> getAll() {
		return teamRepository.findAll();
	}

	public Team create(String name, int type_team_id, int project_id, List<Integer> users_id){
		// Vérification si project_id, team_type_id sont existant
		if(!projectService.existsById(project_id) || !typeTeamService.existsById(type_team_id)) {
			return null;
		}
		// Création et enregistrement de l'équipe
		Team team = new Team();
		team.setName(name);
		team.setTeamTypeId(type_team_id);
		team.setProjectId(project_id);
		team.setUsersIds(users_id);
		return teamRepository.save(team);
	}

	public List<Team> getAllByProjectId(Integer project_id) {
		return teamRepository.findAllByProjectId(project_id);
	}

	public Team addUser(int team_id, int user_id) {
		Team updatedTeam = teamRepository.findById(team_id).get();
		updatedTeam.setUserId(user_id);
		teamRepository.save(updatedTeam);
		return updatedTeam;
	}

	public Team setUsers(int team_id, TeamUpdateRequest teamUpdateUsersRequest) {
		Team updatedTeam = teamRepository.findById(team_id).get();
		updatedTeam.setUsersIds(teamUpdateUsersRequest.getUsersIds());
		teamRepository.save(updatedTeam);
		return null;
	}
}
