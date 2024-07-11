package com.spag.crm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spag.crm.model.SpagCrmConfigMaster;

public interface SpagCrmConfigMasterRepo extends JpaRepository<SpagCrmConfigMaster,Long>{

	SpagCrmConfigMaster findByCmRowid(Long cmRowid);

	List<SpagCrmConfigMaster> findByCmRowidIn(List<Long> cmRowidlist);

}
