package com.cedalanavi.project_ijva500_soa_projects.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;
import com.cedalanavi.project_ijva500_soa_projects.Services.ProjectService;

@RestController
@RequestMapping("manage-project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("")
	public Iterable<Project> getAll() {
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
}
