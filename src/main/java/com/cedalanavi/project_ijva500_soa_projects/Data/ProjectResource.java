package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ProjectResource {

	public int id;
	
	public String name;

	@JsonInclude(value  = Include.NON_DEFAULT)
	public int idParentProject;
	
	public List<TeamResource> teams;

	public List<ProjectResource> projects;

	
}
