package com.cedalanavi.project_ijva500_soa_projects.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectResource;
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Services.ProjectService;
import com.cedalanavi.project_ijva500_soa_projects.Utils.ProjectMapper;

@RestController
@RequestMapping("manage-project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	ProjectMapper projectMapper;

	@GetMapping
	public List<ProjectResource> getAll() {
		List<Project> projectResults = projectService.getAll();
		List<ProjectResource> projectResources = new ArrayList<ProjectResource>();
		projectResults.forEach(project -> {
			projectResources.add(projectMapper.toProjectResource(project));
		});
		return projectResources;
	}

	@PostMapping(path = "/create")
	public void create(@RequestBody ProjectCreateRequest projectRequest, HttpServletResponse response) {
		if (projectService.create(projectRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}   
	}
	
	@PutMapping("{id}/update")
	public ProjectResource update(@RequestBody ProjectUpdateRequest projectRequest, @PathVariable int id) {
		Project project = projectService.update(projectRequest, id);
		return projectMapper.toProjectResource(project);
	}
	
	@DeleteMapping("{id}/delete")
	public void delete(@PathVariable int id) {
		projectService.delete(id);
	}
	
	@PutMapping(path = "{id}/teams")
	public ProjectResource setTeams(@PathVariable int id, @RequestBody ProjectUpdateRequest projectRequest) {
		Project project = projectService.setTeams(id, projectRequest);
		return projectMapper.toProjectResource(project);
	}

	@PutMapping(path = "{id}/projects")
	public ProjectResource setProjects(@PathVariable int id, @RequestBody ProjectUpdateRequest projectRequest) {
		Project project = projectService.setProjects(id, projectRequest);
		return projectMapper.toProjectResource(project);
	}
}
