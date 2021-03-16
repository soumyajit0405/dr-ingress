package com.energytrade.app.dto;

import com.energytrade.app.model.AllElectricityBoard;

public  class StateBoardMappingDto {

	private int stateBoardMappingId;

	private byte activeStatus;


	private String stateName;
	
	private String boardName;
	
	private int stateId;
	
	private int boardId;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getStateBoardMappingId() {
		return stateBoardMappingId;
	}

	public void setStateBoardMappingId(int stateBoardMappingId) {
		this.stateBoardMappingId = stateBoardMappingId;
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

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
}
