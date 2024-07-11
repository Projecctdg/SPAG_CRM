package com.spag.crm.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.spag.crm.dbservice.Dbservice;
import com.spag.crm.email.APIService;

public class AllService 
{
	@Autowired Dbservice dbservice;

	@Autowired APIService apiService;

	public Dbservice getDbservice() {
		return dbservice;
	}

	public APIService getApiService() {
		return apiService;
	}
}
