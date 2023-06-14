package com.cedalanavi.project_ijva500_soa_projects.Entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NonNull
	private String name;

	@NonNull
	private int teamTypeId;
	
	@ManyToOne
	@JoinColumn(name="idProject")
	@NonNull
	@JsonBackReference
	private Project project;
	
	@ElementCollection
	private List<Integer> usersIds;

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

	public int getTeamTypeId() {
		return teamTypeId;
	}

	public void setTeamTypeId(int teamTypeId) {
		this.teamTypeId = teamTypeId;
	}

	public List<Integer> getUsersIds() {
		return usersIds;
	}

	public void setUsersIds(List<Integer> usersIds) {
		this.usersIds = usersIds;
	}
	
	public void setUserId(int userId) {
		this.usersIds.add(userId);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}
