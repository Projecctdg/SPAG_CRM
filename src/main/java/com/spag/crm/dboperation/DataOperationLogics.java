package com.spag.crm.dboperation;


import java.util.HashMap;
import java.util.Map;

import com.spag.crm.config.AllService;
import com.spag.crm.model.SpagCrmUsersConfig;
import com.spag.crm.pojo.AppRequest;
import com.spag.crm.utilities.AppUtility;

public class DataOperationLogics
{
  public Map<?,?> ProcessRequest(Map<String,Object> Request,AllService allService) 
  {
	  String requesttype=(String) Request.get("requesttype");
	  Map<String,Object> Response=new HashMap<String,Object>();
	  switch(requesttype)
	  {
	    case "SaveUserDetails":
	    {
	    	AppRequest request= (AppRequest) Request.get("request");
	    	SpagCrmUsersConfig user=allService.getDbservice().findByUcUsername(AppUtility.convertNullvalue(request.getUserName()));
			allService.getDbservice().saveSpagCrmUsersConfig(user);
	    	break;
	    }
	    case "Login":
	    {
	    	break;
	    }
	    default:
	    {
	    	break;
	    }
	  }
	
	  return Response;
  }
}
