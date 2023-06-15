package com.cedalanavi.project_ijva500_soa_projects.Controllers;

import java.util.ArrayList;
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

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.TeamResource;
import com.cedalanavi.project_ijva500_soa_projects.Data.TeamUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.cedalanavi.project_ijva500_soa_projects.Services.TeamService;
import com.cedalanavi.project_ijva500_soa_projects.Utils.TeamMapper;

@RestController
@RequestMapping("manage-team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@Autowired
	TeamMapper teamMapper;

	@GetMapping
	public List<TeamResource> getAll(HttpServletResponse response) {
		List<Team> teamResults = teamService.getAll();
		List<TeamResource> teamResources = new ArrayList<TeamResource>();
		teamResults.forEach(team -> {
			teamResources.add(teamMapper.toTeamResource(team));
		});
		return teamResources;
	}
	
	@GetMapping(path = "{team_id}")
	public List<TeamResource> getById(@PathVariable Integer team_id, HttpServletResponse response) {
		List<Team> teamResults = teamService.getAllByProjectId(team_id);
		List<TeamResource> teamResources = new ArrayList<TeamResource>();
		teamResults.forEach(team -> {
			teamResources.add(teamMapper.toTeamResource(team));
		});
		return teamResources;
	}

	@PostMapping(path = "/create")
	public void create(@RequestBody TeamCreateRequest teamRequest, HttpServletResponse response){
		if (teamService.create(teamRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
	
	@PutMapping(path = "{team_id}/users")
	public TeamResource setUsers(@PathVariable int team_id, @RequestBody TeamUpdateRequest teamUpdateUsersRequest) {
		return teamMapper.toTeamResource(teamService.setUsers(team_id, teamUpdateUsersRequest));
	}
	 
	@PutMapping("{team_id}/update")
	public void update(@PathVariable int team_id, @RequestBody TeamUpdateRequest teamUpdateUsersRequest, HttpServletResponse response) {
		if (teamService.update(team_id, teamUpdateUsersRequest) != null) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}
}
