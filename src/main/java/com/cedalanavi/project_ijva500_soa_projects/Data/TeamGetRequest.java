package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import javax.persistence.ElementCollection;

import com.cedalanavi.project_ijva500_soa_projects.Entities.TypeTeam;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamGetRequest {
	@JsonIgnore(value = false)
	public int id;
	
	@JsonIgnore(value = false)
	public String name;

	@JsonIgnore(value = false)
	public TypeTeam typeTeam;
	
	@ElementCollection
	public List<String> usersIds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getUsersIds() {
		return usersIds;
	}

	public void setUsersIds(List<String> usersIds) {
		this.usersIds = usersIds;
	}

	public TypeTeam getTypeTeam() {
		return typeTeam;
	}

	public void setTypeTeam(TypeTeam typeTeam) {
		this.typeTeam = typeTeam;
	}
	
}
