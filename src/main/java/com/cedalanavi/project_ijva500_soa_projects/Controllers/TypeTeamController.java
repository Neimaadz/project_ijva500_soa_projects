package com.cedalanavi.project_ijva500_soa_projects.Controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cedalanavi.project_ijva500_soa_projects.Data.TypeTeamCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.TypeTeam;
import com.cedalanavi.project_ijva500_soa_projects.Services.TypeTeamService;

@RestController
@RequestMapping("manage-typeteam")
public class TypeTeamController {

	@Autowired
	private TypeTeamService typeTeamService;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("")
	public Iterable<TypeTeam> getAll() {
		return typeTeamService.getAll();
	}

	@PostMapping(path = "/create")
	public void create(@RequestBody TypeTeamCreateRequest typeTeamRequest, HttpServletResponse response) {
		if (typeTeamService.create(typeTeamRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
}
