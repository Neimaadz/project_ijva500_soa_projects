package com.cedalanavi.project_ijva500_soa_projects.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TypeTeamCreateRequest {

	@JsonIgnore(value = false)
	public String name;

	@JsonIgnore(value = false)
	public String description;

}
