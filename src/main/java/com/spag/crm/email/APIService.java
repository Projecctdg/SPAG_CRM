package com.spag.crm.email;

import com.spag.crm.config.AllService;
import com.spag.crm.pojo.AppResponse;

public interface APIService
{

	AppResponse sendEmail(String to, String subject, String text, AllService allService);

}
