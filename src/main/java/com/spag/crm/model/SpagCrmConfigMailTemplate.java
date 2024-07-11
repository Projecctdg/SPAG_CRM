package com.spag.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SPAG_CONFIG_MAIL_TEMPLATE")
public class SpagCrmConfigMailTemplate implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MT_ROW_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mtRowid;
	
	@Column(name = "MT_TEMPLATE_CONTENT",columnDefinition = "TEXT")
	private  String mtTemplateContent;
	
	@Column(name = "MT_TEMPLATE_TYPE")
	private  String mtTemplateType;
	
	@Column(name = "MT_CREATED_BY")
	private  String mtCreatedBy;
	
	@Column(name = "MT_CREATED_ON")
	private  Timestamp mtCreatedOn;
	
	@Column(name = "MT_TEMPLATE_ACTIVE")
	private  String mtTemplateActive;
	
	@Column(name = "MT_TEMPLATE_SUBJECT",columnDefinition = "TEXT")
	private  String mtTemplateSubject;

	public Long getMtRowid() {
		return mtRowid;
	}

	public void setMtRowid(Long mtRowid) {
		this.mtRowid = mtRowid;
	}

	public String getMtTemplateType() {
		return mtTemplateType;
	}

	public void setMtTemplateType(String mtTemplateType) {
		this.mtTemplateType = mtTemplateType;
	}

	public String getMtTemplateContent() {
		return mtTemplateContent;
	}

	public void setMtTemplateContent(String mtTemplateContent) {
		this.mtTemplateContent = mtTemplateContent;
	}

	public String getMtCreatedBy() {
		return mtCreatedBy;
	}

	public void setMtCreatedBy(String mtCreatedBy) {
		this.mtCreatedBy = mtCreatedBy;
	}

	public String getMtTemplateActive() {
		return mtTemplateActive;
	}

	public void setMtTemplateActive(String mtTemplateActive) {
		this.mtTemplateActive = mtTemplateActive;
	}

	public String getMtTemplateSubject() {
		return mtTemplateSubject;
	}

	public void setMtTemplateSubject(String mtTemplateSubject) {
		this.mtTemplateSubject = mtTemplateSubject;
	}

	public Timestamp getMtCreatedOn() {
		return mtCreatedOn;
	}

	public void setMtCreatedOn(Timestamp mtCreatedOn) {
		this.mtCreatedOn = mtCreatedOn;
	}
	
}