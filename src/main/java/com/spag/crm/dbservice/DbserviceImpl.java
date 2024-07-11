package com.spag.crm.dbservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spag.crm.model.SpagCrmConfigMailTemplate;
import com.spag.crm.model.SpagCrmConfigMaster;
import com.spag.crm.model.SpagCrmUsersConfig;
import com.spag.crm.repo.SpagCrmConfigMailTemplateRepo;
import com.spag.crm.repo.SpagCrmConfigMasterRepo;
import com.spag.crm.repo.SpagCrmUsersConfigRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DbserviceImpl implements Dbservice
{
	 @Autowired
	 SpagCrmUsersConfigRepo SpagCrmUsersConfigRepo;
	 
	 @Autowired
	 SpagCrmConfigMailTemplateRepo SpagCrmConfigMailTemplateRepo;
	 
	 @Autowired
	 SpagCrmConfigMasterRepo configMasterRepo;
	 
	 @Override
	 public SpagCrmUsersConfig findByUcUsername(String username)
	 {
		 return SpagCrmUsersConfigRepo.findByUcUsername(username);
	 }
	 
	 @Override
	 public SpagCrmUsersConfig saveSpagCrmUsersConfig(SpagCrmUsersConfig  user)
	 {
		 return SpagCrmUsersConfigRepo.save(user);
	 }
	 
	 @Override
	 public SpagCrmConfigMailTemplate findByMtTemplateType(String mtTemplateType)
	 {
		 return SpagCrmConfigMailTemplateRepo.findByMtTemplateType(mtTemplateType);
	 }
	 
	 @Override
	 public SpagCrmConfigMaster findByCmRowid(Long cmRowid)
	 {
		 return configMasterRepo.findByCmRowid(cmRowid);
	 }
	 @Override
	 public List<SpagCrmConfigMaster> findByCmRowidList(List<Long> cmRowidlist)
	 {
		 return configMasterRepo.findByCmRowidIn(cmRowidlist);
	 }
}
