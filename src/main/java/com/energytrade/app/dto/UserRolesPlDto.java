package com.energytrade.app.dto;

import com.energytrade.app.model.AllElectricityBoard;

public  class UserRolesPlDto {

	private int userRoleId;

	private byte activeStatus;


	private String userRoleName;


	public int getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}


	public String getUserRoleName() {
		return userRoleName;
	}


	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}


	public byte getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	
}
