package com.spag.crm.utilities;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.google.gson.Gson;
public class AppUtility 
{
	public static String convertObjectToString(Object obj) throws Exception
	{
		String response="";
		Gson gson = new Gson();
		response = gson.toJson(obj);
		return response;
	}
	public static Object convertStringToObject(String strXml,Object obj) throws Exception
	{
		Gson gson = new Gson();
		Object ReposnceObject = gson.fromJson(strXml,obj.getClass());
		return ReposnceObject;
	}
	
	public static String toCamelCase(final String init) 
	{
		if (init==null)
		{
			return null;
		}
		final StringBuilder ret = new StringBuilder(init.length());
		for (final String word : init.split(" ")) 
		{
			if (!word.isEmpty()) 
			{
				ret.append(word.substring(0, 1).toUpperCase());
				ret.append(word.substring(1).toLowerCase());
			}
			if (!(ret.length()==init.length()))
				ret.append(" ");
		}
		return ret.toString();
	}

	public static Date StringToDateconverter(String dateStr,String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Date date = null;

		if(dateStr == null)
		{
			return null;
		}
		else
		{
			try 
			{
				date = sdf.parse(dateStr);
			}
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
		}
		return date;
	}

	public static String convertNullvalue(Object obj)
	{
		try
		{
			if(obj == null)
			{
				return StringConstants.EMPTY;
			}
			else if(obj.equals(""))
			{
				return StringConstants.EMPTY;
			}else if(obj.equals("  "))
				{
					return StringConstants.EMPTY;
				}
		}
		catch(Exception ex)
		{
			return StringConstants.EMPTY;
		}
		return String.valueOf(obj).trim();
	}
	public static Timestamp getSystemDate() 
	{
		return new Timestamp(System.currentTimeMillis());
	}
	public static long convertLongValue(Long L)
	{
		long i=0l;
		i=(L==null?i:L.longValue());		
		return i;
	}
	public static boolean Checkfilename(String value)
	{
		boolean flag =false;
		long count=0;
		value=value.toLowerCase();
		if(!convertNullvalue(value).equals(StringConstants.EMPTY) && value.contains("."))
		{
			count=value.chars().filter(e->e=='.').count();
			if(count>1)
			{
				flag=true;
			}
		}
		if(!flag)
		{
			value=value.split("\\.")[1];
			if(!Arrays.asList("jpg","jpeg","png","pdf").contains(value))
			{
				flag=true;
			}
		}
		return flag;
	}
}