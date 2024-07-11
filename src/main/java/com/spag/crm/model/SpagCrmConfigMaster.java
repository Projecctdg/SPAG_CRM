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
@Table(name = "SPAG_CRM_CONFIG_MASTER")
public class SpagCrmConfigMaster implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CM_ROW_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cmRowid;
	
	@Column(name = "CM_MASTER_VALUE")
	private  String cmMasterValue;
	
	@Column(name = "CM_MASTER_DESC")
	private  String cmMasterDesc;
	
	@Column(name = "CM_CREATED_BY")
	private  String cmCreatedBy;
	
	@Column(name = "CM_CREATED_ON")
	private  Timestamp cmCreatedOn;

	public Long getCmRowid() {
		return cmRowid;
	}

	public void setCmRowid(Long cmRowid) {
		this.cmRowid = cmRowid;
	}

	public String getCmMasterValue() {
		return cmMasterValue;
	}

	public void setCmMasterValue(String cmMasterValue) {
		this.cmMasterValue = cmMasterValue;
	}

	public String getCmMasterDesc() {
		return cmMasterDesc;
	}

	public void setCmMasterDesc(String cmMasterDesc) {
		this.cmMasterDesc = cmMasterDesc;
	}

	public String getCmCreatedBy() {
		return cmCreatedBy;
	}

	public void setCmCreatedBy(String cmCreatedBy) {
		this.cmCreatedBy = cmCreatedBy;
	}

	public Timestamp getCmCreatedOn() {
		return cmCreatedOn;
	}

	public void setCmCreatedOn(Timestamp cmCreatedOn) {
		this.cmCreatedOn = cmCreatedOn;
	}
}