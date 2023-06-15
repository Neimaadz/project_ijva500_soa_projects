package com.cedalanavi.project_ijva500_soa_projects.Data;

import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProjectCreateRequest {

	@JsonIgnore(value = false)
	public String name;
	
	@JsonIgnore(value = false)
	public Project parent_project;
	
}
