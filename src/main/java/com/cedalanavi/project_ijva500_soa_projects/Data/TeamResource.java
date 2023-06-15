package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import javax.persistence.ElementCollection;

import com.cedalanavi.project_ijva500_soa_projects.Entities.TeamType;

public class TeamResource {

	public int id;
	
	public String name;

	public TeamType teamType;
	
	@ElementCollection
	public List<String> usersIds;
}
