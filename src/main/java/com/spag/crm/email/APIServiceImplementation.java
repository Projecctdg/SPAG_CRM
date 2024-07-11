package com.spag.crm.email;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.spag.crm.config.AllService;
import com.spag.crm.model.SpagCrmConfigMaster;
import com.spag.crm.pojo.AppResponse;
import com.spag.crm.utilities.StringConstants;
@Service
public class APIServiceImplementation implements APIService
{

    @Autowired
    private JavaMailSender emailSender;
        
	public JavaMailSender LoadMailSender(AllService allService) 
	{
		List<Long> rowidlist=Arrays.asList(Long.parseLong(StringConstants.ONE),Long.parseLong(StringConstants.TWO),Long.parseLong(StringConstants.THREE),Long.parseLong(StringConstants.FOUR),Long.parseLong(StringConstants.FIVE));
		List<SpagCrmConfigMaster> masterlist=allService.getDbservice().findByCmRowidList(rowidlist);
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    Properties props = mailSender.getJavaMailProperties();
	    for(SpagCrmConfigMaster master:masterlist)
	    {  
	    	switch(String.valueOf(master.getCmRowid()))
	    	{
	    		case StringConstants.ONE:
	    		{
	    		    mailSender.setHost(master.getCmMasterValue());
	    			break;
	    		}
	    		case StringConstants.TWO:
	    		{
	    		    mailSender.setPort(Integer.parseInt(master.getCmMasterValue()));
	    			break;
	    		}
	    		case StringConstants.THREE:
	    		{
	    		    mailSender.setUsername(master.getCmMasterValue());
	    			break;
	    		}
	    		case StringConstants.FOUR:
	    		{
	    		    mailSender.setPassword(master.getCmMasterValue());
	    			break;
	    		}
	    		case StringConstants.FIVE:
	    		{
	    			props.put("mail.transport.protocol",master.getCmMasterValue());
	    			break;
	    		}
	    	}
	    }
	    props.put("mail.smtp.auth",true);
	    props.put("mail.smtp.starttls.enable",true);
	    props.put("mail.debug",true);
	    
	    return mailSender;
	}
	@Override
    public AppResponse sendEmail(String to, String subject, String text, AllService allService) 
    {
		AppResponse response =new AppResponse();
	    try
	    {
	    	LoadMailSender(allService);
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom(to);
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	        response.setErrorcode(StringConstants.SUSCODE);
	        response.setErrormessage(StringConstants.SUCCESS);
	    }
	    catch(Exception e)
	    {
		   e.printStackTrace();
		   response.setErrorcode(StringConstants.ERRCODE);
		   response.setErrormessage(e.toString());
	    }
        return response;
    }
}