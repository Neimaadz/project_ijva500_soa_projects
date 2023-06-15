package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;

public class ProjectUpdateRequest {

	public String name;
	
	public Project parent_project;
	
	public List<Integer> teams_id;
	
	public List<Integer> projects_id;
	
}
