package com.spag.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SPAG_CRM_USERS_CONFIG")
public class SpagCrmUsersConfig  implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "_USER_NAME")
	private  String ucUsername;
	
	@Column(name = "UC_PASSWORD")
	private  String ucPassword;
	
	@Column(name = "UC_EMAIL")
	private  String ucEmail;

	@Column(name = "UC_CREATED_ON")
	private Timestamp ucCreatedOn;
	
	@Column(name = "UC_USER_TYPE")
	private  String ucUserType;
}
