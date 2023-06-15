package com.cedalanavi.project_ijva500_soa_projects.Utils;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.cedalanavi.project_ijva500_soa_projects.Data.TeamResource;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
	
	public TeamResource toTeamResource(Team team);
}
