package com.cedalanavi.project_ijva500_soa_projects.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamTypeCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.TeamType;
import com.cedalanavi.project_ijva500_soa_projects.Services.TeamTypeService;

@RestController
@RequestMapping("manage-typeteam")
public class TypeTeamController {

	@Autowired
	private TeamTypeService typeTeamService;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("")
	public List<TeamType> getAll() {
		return typeTeamService.getAll();
	}

	@PostMapping(path = "/create")
	public void create(@RequestBody TeamTypeCreateRequest typeTeamRequest, HttpServletResponse response) {
		if (typeTeamService.create(typeTeamRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
}
