package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the user_devices database table.
 * 
 */
@Entity
@Table(name="user_access_type_mapping")
@NamedQuery(name="UserAccessTypeMapping.findAll", query="SELECT u FROM UserAccessTypeMapping u")
public class UserAccessTypeMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_access_type_mapping_id")
	private int userAccessTypeMappingId;

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

	@ManyToOne
	@JoinColumn(name="user_id")
	private AllUser allUser;

	//bi-directional many-to-one association to DevicePl
	@ManyToOne
	@JoinColumn(name="user_type_pl_id")
	private UserTypePl userTypepl;

	public int getUserAccessTypeMappingId() {
		return userAccessTypeMappingId;
	}

	public void setUserAccessTypeMappingId(int userAccessTypeMappingId) {
		this.userAccessTypeMappingId = userAccessTypeMappingId;
	}

	public UserTypePl getUserTypepl() {
		return userTypepl;
	}

	public void setUserTypepl(UserTypePl userTypepl) {
		this.userTypepl = userTypepl;
	}

	public AllUser getAllUser() {
		return allUser;
	}

	public UserAccessTypeMapping() {
	}

	public AllUser getAlLUser() {
		return allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
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

}