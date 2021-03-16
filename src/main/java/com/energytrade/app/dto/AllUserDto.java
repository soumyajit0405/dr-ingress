package com.energytrade.app.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.energytrade.app.model.AllElectricityBoard;

public  class AllUserDto {

	private int userId;

	private byte activeStatus;
	
	private String fullName;
	
	private String email;
	
	private String uniqueServiceNumber;
	
	private Date registrationDate;
	
	private String drContractNumber;
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDrContractNumber() {
		return drContractNumber;
	}

	public void setDrContractNumber(String drContractNumber) {
		this.drContractNumber = drContractNumber;
	}

	public String getUniqueServiceNumber() {
		return uniqueServiceNumber;
	}

	public void setUniqueServiceNumber(String uniqueServiceNumber) {
		this.uniqueServiceNumber = uniqueServiceNumber;
	}

	private String boardName;
	
	private int stateId;
	
	private int boardId;

	private String stateName;
	
	private String localityName;
	
	private int localityId;

	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	public int getLocalityId() {
		return localityId;
	}

	public void setLocalityId(int localityId) {
		this.localityId = localityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public byte getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	
}
