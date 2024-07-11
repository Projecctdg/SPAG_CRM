package com.spag.crm.component;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.spag.crm.pojo.AppRequest;
import com.spag.crm.utilities.AppUtility;
import com.spag.crm.utilities.StringConstants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class RequestChecker extends AbstractHttpMessageConverter<Object> {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private HttpSession session;
	
	public RequestChecker()
	{
		super(MediaType.ALL);
	}

	@Override
	protected boolean supports(Class<?> clazz) 
	{
		return true;
	}

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException 
	{
		Object obj = new Object();
		String data =Converttostring(inputMessage.getBody());
		session.setAttribute("requrl",httpServletRequest.getRequestURI());
		obj=CheckRequestFormat(data,httpServletRequest.getRequestURI(),session);
		return obj;
	}
	@Override
	protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException 
	{
		try
		{
			if(AppUtility.convertNullvalue(session.getAttribute("requrl")).contains("spag/Services"))
			{
				if((boolean)session.getAttribute("mandatorycheck"))
				{
				    outputMessage.getBody().write(objectMapper.writeValueAsString(o).getBytes(StandardCharsets.UTF_8));
				}
				else
				{
					if((boolean)session.getAttribute("badrequest"))
					{
					    outputMessage.getBody().write(objectMapper.writeValueAsString(o).getBytes(StandardCharsets.UTF_8));
					}
					else
					{
						Map<String,Object> map=new HashMap<>();
						map.put("error", "Missing mandatory fields");
					    outputMessage.getBody().write(objectMapper.writeValueAsString(map).getBytes(StandardCharsets.UTF_8));
					}
				}
			}
		 		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	private String Converttostring(InputStream inputStream) 
	{
		try 
		{
			return new String(IOUtils.toByteArray(inputStream));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return "";
	}
	//Request Checking for Format
	@SuppressWarnings("unchecked")
	public static Object CheckRequestFormat(String inputMgs,String apiUrl,HttpSession session) 
	{
		Object returnObject=null;
		boolean flag=true;
		try 
		{
			session.setAttribute("mandatorycheck",false);
			session.setAttribute("badrequest",false);
			List<String> mandatoryfield=new ArrayList<>();
			mandatoryfield.add("userName");
			mandatoryfield.add("password");
		   JsonObject obj=new JsonObject();
		   obj=(JsonObject) AppUtility.convertStringToObject(inputMgs,obj);
		   if( obj.isEmpty() ||  obj.isJsonNull())
		   {
			   flag=false;
			   session.setAttribute("badrequest",true);
		   }
		   else
		   {
			   for(Entry<String, JsonElement> map:obj.entrySet())
			   {
				   if(AppUtility.convertNullvalue(map.getKey()).equals(StringConstants.EMPTY))
				   {
					 flag=false; 
					  session.setAttribute("badrequest",true);
				     break;
				   }
			   }
		   }
		   if(flag)
		   {
			   Map<String,Object> jsonobj=new HashMap<>();
			   jsonobj=(Map<String, Object>) AppUtility.convertStringToObject(inputMgs,jsonobj);
			   switch(apiUrl)
				{
					case "/spag/Services/login":
					{
						if(mandatorykeycheck(jsonobj,mandatoryfield,session))
						{
							AppRequest loginreq = new AppRequest();
							returnObject = (AppRequest) AppUtility.convertStringToObject(inputMgs,loginreq);
						}
						break;
					}
					case "/spag/Services/register":
					{
						if(mandatorykeycheck(jsonobj,mandatoryfield,session))
						{
							AppRequest loginreq = new AppRequest();
							returnObject = (AppRequest) AppUtility.convertStringToObject(inputMgs,loginreq);
						}
						break;
					}
				}
		   }
		   else
		   {
			   returnObject=null;
		   }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			session.setAttribute("badrequest",false);
			returnObject=null;
		}
		return returnObject;
	}
	
	private static boolean mandatorykeycheck(Map<String, Object> jsonobj, List<String> mandatorykeys,HttpSession session) 
	{
		boolean flag=true;
		int keycount=0,valcount=0;
		for(Entry<String, Object> map:jsonobj.entrySet())
		{
		   if(!AppUtility.convertNullvalue(map.getKey()).equals(StringConstants.EMPTY))
		   {
			   if(mandatorykeys.contains(AppUtility.convertNullvalue(map.getKey())))
			   {
				   keycount++;
				   if(!AppUtility.convertNullvalue(map.getValue()).equals(StringConstants.EMPTY) && AppUtility.convertNullvalue(map.getValue()).trim().length()>0)
				   {
					   valcount++;
				   }
			   }
		   }
		}
		if(keycount!=mandatorykeys.size())
		{
			flag=false;
		}
		else if(keycount!=valcount)
		{
			flag=false;
		}
		session.setAttribute("mandatorycheck",flag);
		return flag;
	}

}