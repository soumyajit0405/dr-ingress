package com.energytrade.app.dto;

import com.energytrade.app.model.AllElectricityBoard;

public  class UserTypePlDto {

	private int userTypeId;

	private byte activeStatus;


	private String userTypeName;


	public int getUserTypeId() {
		return userTypeId;
	}


	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}


	public byte getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}


	public String getUserTypeName() {
		return userTypeName;
	}


	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
}
