package com.cedalanavi.project_ijva500_soa_projects.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public Iterable<Project> getAll() {
		return projectRepository.findAll();
	}

	public Project create(ProjectCreateRequest projectRequest) {
		Project project = new Project();
		//if (projectRequest.name == null || projectRequest.name.length() == 0) return null;
		project.setName(projectRequest.name);
		project.setParentId(projectRequest.parent_id);
		return projectRepository.save(project);
	}

	public boolean existsById(int project_id) {
		return projectRepository.existsById(project_id);
	}

	public Project update(ProjectUpdateRequest projectRequest, int id) {
		Project updatedProject = new Project();
		updatedProject.setId(id);
		updatedProject.setName(projectRequest.name);
		updatedProject.setParentId(projectRequest.parent_id);
		projectRepository.save(updatedProject);
		return updatedProject;
	}
}
