package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProjectUpdateRequest {

	public String name;
	
	public Project parent_project;
	
	public List<Integer> teams_id;
	
	public List<Integer> projects_id;
	
}
