package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_type_pl database table.
 * 
 */
@Entity
@Table(name="user_type_pl")
@NamedQuery(name="UserTypePl.findAll", query="SELECT u FROM UserTypePl u")
public class UserTypePl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_type_id")
	private int userTypeId;

	@Column(name="active_status")
	private byte activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	private byte softdeleteflag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	@Column(name="user_type_name")
	private String userTypeName;

	//bi-directional many-to-one association to AllUser
	@OneToMany(mappedBy="userTypePl")
	private List<AllUser> allUsers;

	public UserTypePl() {
	}

	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
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

	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public List<AllUser> getAllUsers() {
		return this.allUsers;
	}

	public void setAllUsers(List<AllUser> allUsers) {
		this.allUsers = allUsers;
	}

	public AllUser addAllUser(AllUser allUser) {
		getAllUsers().add(allUser);
		allUser.setUserTypePl(this);

		return allUser;
	}

	public AllUser removeAllUser(AllUser allUser) {
		getAllUsers().remove(allUser);
		allUser.setUserTypePl(null);

		return allUser;
	}

}