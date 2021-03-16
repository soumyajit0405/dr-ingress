package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the device_pl database table.
 * 
 */
@Entity
@Table(name="device_type_pl")
@NamedQuery(name="DevicePl.findAll", query="SELECT d FROM DevicePl d")
public class DevicePl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="device_type_id")
	private int deviceTypeId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Column(name="device_type_name")
	private String deviceTypeName;

	private byte softdeleteflag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	//bi-directional many-to-one association to UserDevice
	@OneToMany(mappedBy="devicePl")
	private List<UserDevice> userDevices;

	public DevicePl() {
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

	public List<UserDevice> getUserDevices() {
		return this.userDevices;
	}

	public void setUserDevices(List<UserDevice> userDevices) {
		this.userDevices = userDevices;
	}

	public UserDevice addUserDevice(UserDevice userDevice) {
		getUserDevices().add(userDevice);
		userDevice.setDevicePl(this);

		return userDevice;
	}

	public UserDevice removeUserDevice(UserDevice userDevice) {
		getUserDevices().remove(userDevice);
		userDevice.setDevicePl(null);

		return userDevice;
	}

}