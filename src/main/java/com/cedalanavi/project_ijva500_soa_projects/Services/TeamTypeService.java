package com.cedalanavi.project_ijva500_soa_projects.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamTypeCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.TeamType;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TeamTypeRepository;

@Service
public class TeamTypeService {
	
	@Autowired
	private TeamTypeRepository teamTypeRepository;
	
	public List<TeamType> getAll() {
		return teamTypeRepository.findAll();
	}
	
	public TeamType create(TeamTypeCreateRequest typeTeamRequest) {
		TeamType typeTeam = new TeamType();
		if (typeTeamRequest.name == null || typeTeamRequest.name.length() == 0) return null;
		typeTeam.setName(typeTeamRequest.name);
		typeTeam.setDescription(typeTeamRequest.description);
		return teamTypeRepository.save(typeTeam);
	}

	public boolean existsById(int type_team_id) {
		return teamTypeRepository.existsById(type_team_id);
	}
}
