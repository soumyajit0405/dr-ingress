package com.energytrade.app.dto;

import com.energytrade.app.model.AllElectricityBoard;

public  class AllElectricityBoardDto {

	public int getElectricityBoardId() {
		return electricityBoardId;
	}

	public void setElectricityBoardId(int electricityBoardId) {
		this.electricityBoardId = electricityBoardId;
	}

	public byte getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getElectricityBoardName() {
		return electricityBoardName;
	}

	public void setElectricityBoardName(String electricityBoardName) {
		this.electricityBoardName = electricityBoardName;
	}

	private int electricityBoardId;

	private byte activeStatus;

	private String electricityBoardName;

	
}
