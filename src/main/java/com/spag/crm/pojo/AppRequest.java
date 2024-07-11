package com.spag.crm.pojo;

import java.io.Serializable;

public class AppRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String sendmail;
	private String email;
	private String regotp;
	private String usertype;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSendmail() {
		return sendmail;
	}
	public void setSendmail(String sendmail) {
		this.sendmail = sendmail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegotp() {
		return regotp;
	}
	public void setRegotp(String regotp) {
		this.regotp = regotp;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}
