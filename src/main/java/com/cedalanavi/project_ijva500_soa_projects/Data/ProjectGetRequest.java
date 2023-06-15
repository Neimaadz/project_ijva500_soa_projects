package com.cedalanavi.project_ijva500_soa_projects.Data;

import java.util.List;

import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProjectGetRequest {

	@JsonIgnore(value = false)
	private int id;
	
	@JsonIgnore(value = false)
	public String name;
	
	public List<Team> teams;
	
	private List<Project> projects;

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

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
}
