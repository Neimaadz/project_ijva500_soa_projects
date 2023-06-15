package com.cedalanavi.project_ijva500_soa_projects.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RequestJoinTeamCreateRequest{

	@JsonIgnore(value = false)
	public int teamId;

	@JsonIgnore(value = false)
	public String userId;
}
