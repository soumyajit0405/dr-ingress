package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_roles_pl database table.
 * 
 */
@Entity
@Table(name="general_config")
@NamedQuery(name="GeneralConfig.findAll", query="SELECT u FROM GeneralConfig u")
public class GeneralConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="general_config_id")
	private int generalConfigId;
	
	@Column(name="name")
	private String name;

	@Column(name="value")
	private String value;

	public int getGeneralConfigId() {
		return generalConfigId;
	}

	public void setGeneralConfigId(int generalConfigId) {
		this.generalConfigId = generalConfigId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}