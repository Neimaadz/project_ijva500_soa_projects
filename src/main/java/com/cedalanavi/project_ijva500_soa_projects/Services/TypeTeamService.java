package com.cedalanavi.project_ijva500_soa_projects.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.TypeTeamCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.TypeTeam;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TypeTeamRepository;

@Service
public class TypeTeamService {
	
	@Autowired
	private TypeTeamRepository typeTeamRepository;
	
	public Iterable<TypeTeam> getAll() {
		return typeTeamRepository.findAll();
	}
	
	public TypeTeam create(TypeTeamCreateRequest typeTeamRequest) 
	{
		TypeTeam typeTeam = new TypeTeam();
		if (typeTeamRequest.name == null || typeTeamRequest.name.length() == 0) return null;
		typeTeam.setName(typeTeamRequest.name);
		typeTeam.setDescription(typeTeamRequest.description);
		return typeTeamRepository.save(typeTeam);
	}

	public boolean existsById(int type_team_id) {
		return typeTeamRepository.existsById(type_team_id);
	}
}