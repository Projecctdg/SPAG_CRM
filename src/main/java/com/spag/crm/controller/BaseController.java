package com.spag.crm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spag.crm.component.EmailComponent;
import com.spag.crm.config.AllService;
import com.spag.crm.dboperation.DataOperationLogics;
import com.spag.crm.model.SpagCrmUsersConfig;
import com.spag.crm.pojo.AppRequest;
import com.spag.crm.pojo.AppResponse;
import com.spag.crm.pojo.EmailRequest;
import com.spag.crm.utilities.AppUtility;
import com.spag.crm.utilities.StringConstants;

@RestController
@RequestMapping(value = "/Services")
public class BaseController 
{
	  @Autowired
	  AllService allService;
	  
	  @Autowired
	  EmailComponent emailComponent;
	  
	  DataOperationLogics dataOperationLogics=new DataOperationLogics();
	
	@PostMapping(value = "/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public AppResponse Login(@RequestBody AppRequest request)
	{
		AppResponse response = new AppResponse();
		try
		{
			SpagCrmUsersConfig users=allService.getDbservice().findByUcUsername(AppUtility.convertNullvalue(request.getUserName()));
			if(users!=null)
			{
			}
			else
			{
				response.setErrorcode(StringConstants.ERRCODE);
				response.setErrormessage(StringConstants.INVALID_CREDENTIALS);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.setErrorcode(StringConstants.ERRCODE);
			response.setErrormessage(StringConstants.API_EXCEPTION);
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/register",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public AppResponse Register(@RequestBody AppRequest request)
	{
		AppResponse response = new AppResponse();
		 Map<String,Object> Requesthashmap=new HashMap<String,Object>();
		try
		{
			Requesthashmap.put("request", request);
			Requesthashmap.put("requesttype","SaveUserDetails");
			Requesthashmap=(Map<String, Object>) dataOperationLogics.ProcessRequest(Requesthashmap, allService);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.setErrorcode(StringConstants.ERRCODE);
			response.setErrormessage(StringConstants.API_EXCEPTION);
		}
		return response;
	}
	@PostMapping(value = "/sendemail",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public AppResponse SendEmail(@RequestBody EmailRequest request)
	{
		AppResponse response = new AppResponse();
		try
		{
			response=emailComponent.Sendmail(request, allService);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.setErrorcode(StringConstants.ERRCODE);
			response.setErrormessage(StringConstants.API_EXCEPTION);
		}
		return response;
	}
}