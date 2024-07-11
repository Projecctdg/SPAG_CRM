package com.spag.crm.pojo;

import java.io.Serializable;

public class AppResponse implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String errorcode;
	private String errormessage;
	public String getErrorcode() 
	{
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
}
