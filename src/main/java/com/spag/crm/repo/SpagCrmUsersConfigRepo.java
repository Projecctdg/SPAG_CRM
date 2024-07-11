package com.spag.crm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spag.crm.model.SpagCrmUsersConfig;

@Repository
public interface SpagCrmUsersConfigRepo extends JpaRepository<SpagCrmUsersConfig,String>
{

	SpagCrmUsersConfig findByUcUsername(String username);
	
}
