package com.spag.crm.pojo;

import java.io.Serializable;

public class EmailRequest  implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String mailtype;
	private String content;
	private String otp;


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailtype() {
		return mailtype;
	}
	public void setMailtype(String mailtype) {
		this.mailtype = mailtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
}

