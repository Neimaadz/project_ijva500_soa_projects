package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TeamUpdateRequest {

	@JsonIgnore(value = false)
	@Id
	public int id;
	
	@JsonIgnore(value = false)
	public String name;

	@JsonIgnore(value = false)
	public int teamTypeId;
	
	@JsonIgnore(value = false)
	public int projectId;
	
	@JsonIgnore(value = false)
	@ElementCollection
	public List<Integer> usersIds;

}
