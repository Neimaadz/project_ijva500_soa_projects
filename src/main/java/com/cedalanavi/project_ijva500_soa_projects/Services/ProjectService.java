package com.cedalanavi.project_ijva500_soa_projects.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.ProjectRepository;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TeamRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	public Iterable<Project> getAll() {
		return projectRepository.findAll();
	}

	public Project create(ProjectCreateRequest projectRequest) {
		Project project = new Project();
		//if (projectRequest.name == null || projectRequest.name.length() == 0) return null;
		project.setName(projectRequest.name);
		project.setParentProject(projectRequest.parent_project);
		return projectRepository.save(project);
	}

	public boolean existsById(int project_id) {
		return projectRepository.existsById(project_id);
	}

	public Project update(ProjectUpdateRequest projectRequest, int id) {
		Project updatedProject = new Project();
		updatedProject.setId(id);
		updatedProject.setName(projectRequest.name);
		projectRepository.save(updatedProject);
		return updatedProject;
	}

	public Project setTeams(int id, ProjectUpdateRequest projectRequest) {
		Project updatedProject = projectRepository.findById(id).get();
		List<Team> teams = teamRepository.findAllById(projectRequest.teams_id);
		updatedProject.setTeams(teams);
		teams.forEach(e ->{
			e.setProject(updatedProject);
		});
		
		projectRepository.save(updatedProject);
		return null;
	}

	public Project setProjects(int id, ProjectUpdateRequest projectRequest) {
		Project updatedProject = projectRepository.findById(id).get();
		List<Project> projects = projectRepository.findAllById(projectRequest.projects_id);
		updatedProject.setProjects(projects);
		projects.forEach(e ->{
			e.setParentProject(updatedProject);
		});
		
		projectRepository.save(updatedProject);
		return null;
	}
}
