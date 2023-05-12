package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import javax.persistence.ElementCollection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamCreateRequest {
	@JsonIgnore(value = false)
	public String name;

	@JsonIgnore(value = false)
	public int teamTypeId;
	
	@JsonIgnore(value = false)
	public int projectId;
	
	@ElementCollection
	@JsonIgnore(value = false)
	public List<Integer> usersIds;
}
