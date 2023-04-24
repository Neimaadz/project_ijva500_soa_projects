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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.cedalanavi.project_ijva500_soa_projects.Services.TeamService;

@RestController
@RequestMapping("manage-team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("")
	public List<Team> getAll(HttpServletResponse response) {
		return teamService.getAll();
	}
	
	@GetMapping(path = "{team_id}")
	public List<Team> getById(@PathVariable Integer team_id, HttpServletResponse response) {
		return teamService.getAllByProjectId(team_id);
	}

	@PostMapping(path = "/create")
	public void create(@RequestParam String name, @RequestParam int type_team_id, @RequestParam int project_id, @RequestParam(required = false) List<Integer> users_id, HttpServletResponse response){
		if (teamService.create(name, type_team_id, project_id, users_id) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
	
	@PutMapping(path = "{team_id}/users")
	public Team setUsers(@PathVariable int team_id, @RequestBody TeamUpdateRequest teamUpdateUsersRequest) {
		return teamService.setUsers(team_id, teamUpdateUsersRequest);
	}
	 
}
