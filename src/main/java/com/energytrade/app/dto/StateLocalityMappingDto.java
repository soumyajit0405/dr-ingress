package com.energytrade.app.dto;

import com.energytrade.app.model.AllElectricityBoard;

public  class StateLocalityMappingDto {

	private int stateLocalityMappingId;

	private byte activeStatus;


	private String stateName;
	
	private String localityName;
	
	private int stateId;
	
	private int localityId;

	public int getStateLocalityMappingId() {
		return stateLocalityMappingId;
	}

	public void setStateLocalityMappingId(int stateLocalityMappingId) {
		this.stateLocalityMappingId = stateLocalityMappingId;
	}

	public byte getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getLocalityId() {
		return localityId;
	}

	public void setLocalityId(int localityId) {
		this.localityId = localityId;
	}
}
