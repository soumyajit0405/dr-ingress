package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the all_electricity_boards database table.
 * 
 */
@Entity
@Table(name="all_electricity_boards")
@NamedQuery(name="AllElectricityBoard.findAll", query="SELECT a FROM AllElectricityBoard a")
public class AllElectricityBoard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="electricity_board_id")
	private int electricityBoardId;

	@Column(name="active_status")
	private byte activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Column(name="electricity_board_name")
	private String electricityBoardName;

	private byte softdeleteflag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	@JsonIgnore
	//bi-directional many-to-one association to AllUser
	@OneToMany(mappedBy="allElectricityBoard")
	private List<AllUser> allUsers;

	//bi-directional many-to-one association to StateBoardMapping
	@OneToMany(mappedBy="allElectricityBoard")
	private List<StateBoardMapping> stateBoardMappings;

	public AllElectricityBoard() {
	}

	public int getElectricityBoardId() {
		return this.electricityBoardId;
	}

	public void setElectricityBoardId(int electricityBoardId) {
		this.electricityBoardId = electricityBoardId;
	}

	public byte getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getElectricityBoardName() {
		return this.electricityBoardName;
	}

	public void setElectricityBoardName(String electricityBoardName) {
		this.electricityBoardName = electricityBoardName;
	}

	public byte getSoftdeleteflag() {
		return this.softdeleteflag;
	}

	public void setSoftdeleteflag(byte softdeleteflag) {
		this.softdeleteflag = softdeleteflag;
	}

	public Date getSyncTs() {
		return this.syncTs;
	}

	public void setSyncTs(Date syncTs) {
		this.syncTs = syncTs;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTs() {
		return this.updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	public List<AllUser> getAllUsers() {
		return this.allUsers;
	}

	public void setAllUsers(List<AllUser> allUsers) {
		this.allUsers = allUsers;
	}

	public AllUser addAllUser(AllUser allUser) {
		getAllUsers().add(allUser);
		allUser.setAllElectricityBoard(this);

		return allUser;
	}

	public AllUser removeAllUser(AllUser allUser) {
		getAllUsers().remove(allUser);
		allUser.setAllElectricityBoard(null);

		return allUser;
	}

	public List<StateBoardMapping> getStateBoardMappings() {
		return this.stateBoardMappings;
	}

	public void setStateBoardMappings(List<StateBoardMapping> stateBoardMappings) {
		this.stateBoardMappings = stateBoardMappings;
	}

	public StateBoardMapping addStateBoardMapping(StateBoardMapping stateBoardMapping) {
		getStateBoardMappings().add(stateBoardMapping);
		stateBoardMapping.setAllElectricityBoard(this);

		return stateBoardMapping;
	}

	public StateBoardMapping removeStateBoardMapping(StateBoardMapping stateBoardMapping) {
		getStateBoardMappings().remove(stateBoardMapping);
		stateBoardMapping.setAllElectricityBoard(null);

		return stateBoardMapping;
	}

}