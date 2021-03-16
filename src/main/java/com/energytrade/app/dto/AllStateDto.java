package com.energytrade.app.dto;

import com.energytrade.app.model.AllElectricityBoard;

public  class AllStateDto {

	private int stateId;

	private byte activeStatus;

	public byte getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	private String stateName;

	
}
