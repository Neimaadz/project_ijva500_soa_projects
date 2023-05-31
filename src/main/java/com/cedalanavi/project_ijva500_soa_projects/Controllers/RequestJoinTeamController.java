package com.cedalanavi.project_ijva500_soa_projects.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedalanavi.project_ijva500_soa_projects.Data.RequestJoinTeamCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.RequestJoinTeamUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.RequestJoinTeam;
import com.cedalanavi.project_ijva500_soa_projects.Services.RequestJoinTeamService;

@RestController
@RequestMapping("manage-requestjointeam")
public class RequestJoinTeamController {

	@Autowired
	private RequestJoinTeamService requestJoinTeamService;

	@GetMapping("")
	public List<RequestJoinTeam> getAll() {
		return requestJoinTeamService.getAll();
	}

	@PostMapping(path = "/create") 
	public void create(@RequestBody RequestJoinTeamCreateRequest requestJoinTeamServiceRequest, HttpServletResponse response) {
		if (requestJoinTeamService.create(requestJoinTeamServiceRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}   
	}
	
	@PutMapping("{id}/response")
	public void response(@RequestBody RequestJoinTeamUpdateRequest requestJoinTeamUpdateRequest, @PathVariable int id, HttpServletResponse response) {
		if (requestJoinTeamService.update(id, requestJoinTeamUpdateRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
}
