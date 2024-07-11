package com.spag.crm.dbservice;

import java.util.List;

import com.spag.crm.model.SpagCrmConfigMailTemplate;
import com.spag.crm.model.SpagCrmConfigMaster;
import com.spag.crm.model.SpagCrmUsersConfig;

public interface Dbservice
{

	SpagCrmUsersConfig findByUcUsername(String username);

	SpagCrmConfigMailTemplate findByMtTemplateType(String mtTemplateType);

	SpagCrmUsersConfig saveSpagCrmUsersConfig(SpagCrmUsersConfig user);

	SpagCrmConfigMaster findByCmRowid(Long cmRowid);

	List<SpagCrmConfigMaster> findByCmRowidList(List<Long> cmRowidlist);

}
