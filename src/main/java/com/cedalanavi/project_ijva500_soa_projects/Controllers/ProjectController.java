package com.cedalanavi.project_ijva500_soa_projects.Controllers;

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
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectGetRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Services.ProjectService;

@RestController
@RequestMapping("manage-project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("")
	public Iterable<ProjectGetRequest> getAll() {
		return projectService.getAll();
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
	public Project update(@RequestBody ProjectUpdateRequest projectRequest, @PathVariable int id) {
		return projectService.update(projectRequest, id);
	}
	
	@DeleteMapping("{id}/delete")
	public void delete(@PathVariable int id) {
		projectService.delete(id);
	}
	
	@PutMapping(path = "{id}/teams")
	public Project setTeams(@PathVariable int id, @RequestBody ProjectUpdateRequest projectRequest) {
		return projectService.setTeams(id, projectRequest);
	}

	@PutMapping(path = "{id}/projects")
	public Project setProjects(@PathVariable int id, @RequestBody ProjectUpdateRequest projectRequest) {
		return projectService.setProjects(id, projectRequest);
	}
}
