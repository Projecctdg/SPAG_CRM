package com.spag.crm.component;


import org.springframework.stereotype.Component;

import com.spag.crm.config.AllService;
import com.spag.crm.model.SpagCrmConfigMailTemplate;
import com.spag.crm.pojo.AppResponse;
import com.spag.crm.pojo.EmailRequest;
import com.spag.crm.utilities.AppUtility;
import com.spag.crm.utilities.StringConstants;

@Component
public class EmailComponent 
{
  public AppResponse  Sendmail(EmailRequest request,AllService allService)
  {
	    AppResponse response=new AppResponse();
	    try
	    {
	    	SpagCrmConfigMailTemplate mailtemplate=allService.getDbservice().findByMtTemplateType(request.getMailtype());
	 	    String template=mailtemplate.getMtTemplateContent();
	 	    if(AppUtility.convertNullvalue(request.getOtp()).length()>0)
	 	    {
	 			template=template.replaceAll("@OTP",request.getOtp());
	 	    }
	 	    if(AppUtility.convertNullvalue(request.getUserName()).length()>0)
	 	    {
	 			template=template.replaceAll("@USER",request.getOtp());
	 	    }
	 		template=template.replaceAll("@USER",request.getUserName());
	 		response=allService.getApiService().sendEmail(AppUtility.convertNullvalue(request.getEmail()),mailtemplate.getMtTemplateSubject(),template,allService);
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	response.setErrorcode(StringConstants.SUSCODE);
 			response.setErrormessage(e.toString());
	    }
	  return response;
  }
}