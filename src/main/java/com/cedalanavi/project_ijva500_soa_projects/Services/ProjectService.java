package com.cedalanavi.project_ijva500_soa_projects.Services;

import java.util.Iterator;
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
		if (projectRequest.name == null || projectRequest.name.length() == 0) return null;
		project.setName(projectRequest.name);
		return projectRepository.save(project);
	}

	public Project update(ProjectUpdateRequest projectRequest, int id) {
		Project updatedProject = new Project();
		updatedProject.setId(id);
		updatedProject.setName(projectRequest.name);
		projectRepository.save(updatedProject);
		return updatedProject;
	}
	
	public void delete(int id) {
		Project projectToDelete = projectRepository.findById(id).get();
		
		//Supression des équipes liés au projet
		Iterator<Team> i = projectToDelete.getTeams().iterator(); 
		while (i.hasNext()){ 
			Team currentTeam = i.next(); // must be called before you can call
			i.remove(); 
			currentTeam.setProject(null);
			currentTeam.setUsersIds(null); 
			teamRepository.delete(currentTeam); 
		}
		
		//Supression des projets liés au projet
		Iterator<Project> i1 = projectToDelete.getProjects().iterator(); 
		while (i1.hasNext()){ 
			Project currentProject = i1.next(); // must be called before you can call
			i1.remove(); 
			currentProject.setParentProject(null);
		}
		 
		projectRepository.delete(projectToDelete);
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
	
	public boolean existsById(int project_id) {
		return projectRepository.existsById(project_id);
	}
}
