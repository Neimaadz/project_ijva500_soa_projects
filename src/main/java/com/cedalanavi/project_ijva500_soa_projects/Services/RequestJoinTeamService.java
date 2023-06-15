package com.cedalanavi.project_ijva500_soa_projects.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cedalanavi.project_ijva500_soa_projects.Data.RequestJoinTeamCreateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Data.RequestJoinTeamUpdateRequest;
import com.cedalanavi.project_ijva500_soa_projects.Entities.RequestJoinTeam;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.RequestJoinTeamRepository;
import com.cedalanavi.project_ijva500_soa_projects.Repositories.TeamRepository;

@Service
public class RequestJoinTeamService {
	@Autowired
	private RequestJoinTeamRepository requestJoinTeamRepository;

	@Autowired
	private TeamRepository teamRepository;
	
	public List<RequestJoinTeam> getAll() {
		return requestJoinTeamRepository.findAll();
	}

	public RequestJoinTeam create(RequestJoinTeamCreateRequest requestJoinTeamServiceRequest) {
		RequestJoinTeam requestJoinTeam = new RequestJoinTeam();
		if (requestJoinTeamServiceRequest.teamId == 0 || requestJoinTeamServiceRequest.userId == null) return null;
		requestJoinTeam.setTeamId(requestJoinTeamServiceRequest.teamId);
		requestJoinTeam.setUserId(requestJoinTeamServiceRequest.userId);
		requestJoinTeam.setStatus("pending");
		return requestJoinTeamRepository.save(requestJoinTeam);
	}
	
	public RequestJoinTeam update(int id, RequestJoinTeamUpdateRequest requestJoinTeamUpdateRequest ) {
		RequestJoinTeam requestJoinTeam = requestJoinTeamRepository.findById(id).get();

		if (requestJoinTeamUpdateRequest.status.equals("accepted"))  {
			requestJoinTeam.setStatus("accepted");
			Team team = teamRepository.findById(requestJoinTeam.getTeamId()).get();
			team.setUserId(requestJoinTeam.getUserId());
			return requestJoinTeamRepository.save(requestJoinTeam);
		}
		else if (requestJoinTeamUpdateRequest.status.equals("rejected")) {
			requestJoinTeam.setStatus("rejected");
			return requestJoinTeamRepository.save(requestJoinTeam);
		}
		else return null;
	}

}
