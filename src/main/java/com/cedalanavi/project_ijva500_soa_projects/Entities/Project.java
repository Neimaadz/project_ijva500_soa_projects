package com.cedalanavi.project_ijva500_soa_projects.Entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NonNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="idParentProject")
	@JsonBackReference
	private Project parentProject;
	
	@OneToMany(mappedBy="project")
	@ElementCollection
	@JsonManagedReference
	private List<Team> teams;

	@OneToMany(mappedBy="parentProject")
	@ElementCollection
	@JsonManagedReference
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

	public Project getParentProject() {
		return parentProject;
	}

	public void setParentProject(Project parentProject) {
		this.parentProject = parentProject;
	}
	
}
