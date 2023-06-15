package com.cedalanavi.project_ijva500_soa_projects.Utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.cedalanavi.project_ijva500_soa_projects.Data.ProjectResource;
import com.cedalanavi.project_ijva500_soa_projects.Entities.Project;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
	
	@Mapping(target = "idParentProject", source = "parentProject.id")
	public ProjectResource toProjectResource(Project project);
}
