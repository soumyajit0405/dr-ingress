package com.energytrade.app.dto;

import java.math.BigDecimal;

import com.energytrade.app.model.AllElectricityBoard;

public  class UserDeviceDto {

	private int deviceTypeId;

	private String deviceTypeName;
	
	private int userDeviceId;
	
	private BigDecimal capacity;

	public BigDecimal getCapacity() {
		return capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}
	public int getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public int getUserDeviceId() {
		return userDeviceId;
	}

	public void setUserDeviceId(int userDeviceId) {
		this.userDeviceId = userDeviceId;
	}
	
}
