package com.cedalanavi.project_ijva500_soa_projects.Entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

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
	
	@NonNull
	private int projectId;
	
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

}
