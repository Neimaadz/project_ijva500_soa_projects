package com.cedalanavi.project_ijva500_soa_projects.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cedalanavi.project_ijva500_soa_projects.Entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

	List<Team> findAllByProjectId(Integer project_id);

}
