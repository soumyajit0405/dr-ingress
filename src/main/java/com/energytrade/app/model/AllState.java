package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the all_states database table.
 * 
 */
@Entity
@Table(name="all_states")
@NamedQuery(name="AllState.findAll", query="SELECT a FROM AllState a")
public class AllState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_id")
	private int stateId;

	@Column(name="active_status")
	private byte activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	private byte softdeleteflag;

	@Column(name="state_name")
	private String stateName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	//bi-directional many-to-one association to AllUser
	@OneToMany(mappedBy="allState")
	private List<AllUser> allUsers;

	//bi-directional many-to-one association to StateBoardMapping
	@OneToMany(mappedBy="allState")
	private List<StateBoardMapping> stateBoardMappings;

	public AllState() {
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
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

	public byte getSoftdeleteflag() {
		return this.softdeleteflag;
	}

	public void setSoftdeleteflag(byte softdeleteflag) {
		this.softdeleteflag = softdeleteflag;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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
		allUser.setAllState(this);

		return allUser;
	}

	public AllUser removeAllUser(AllUser allUser) {
		getAllUsers().remove(allUser);
		allUser.setAllState(null);

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
		stateBoardMapping.setAllState(this);

		return stateBoardMapping;
	}

	public StateBoardMapping removeStateBoardMapping(StateBoardMapping stateBoardMapping) {
		getStateBoardMappings().remove(stateBoardMapping);
		stateBoardMapping.setAllState(null);

		return stateBoardMapping;
	}

}