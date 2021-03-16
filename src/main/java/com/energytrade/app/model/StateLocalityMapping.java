package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the state_board_mappings database table.
 * 
 */
@Entity
@Table(name="state_locality_mappings")
@NamedQuery(name="StateLocalityMapping.findAll", query="SELECT s FROM StateLocalityMapping s")
public class StateLocalityMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_locality_mapping_id")
	private int stateLocalityMappingId;

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

	//bi-directional many-to-one association to AllState
	@ManyToOne
	@JoinColumn(name="state_id")
	private AllState allState;

	//bi-directional many-to-one association to AllElectricityBoard
	@ManyToOne
	@JoinColumn(name="locality_id")
	private LocalityPl locality;

	public  StateLocalityMapping() {
		// TODO Auto-generated constructor stub
	}

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public byte getSoftdeleteflag() {
		return softdeleteflag;
	}

	public void setSoftdeleteflag(byte softdeleteflag) {
		this.softdeleteflag = softdeleteflag;
	}

	public Date getSyncTs() {
		return syncTs;
	}

	public void setSyncTs(Date syncTs) {
		this.syncTs = syncTs;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(Date updatedTs) {
		this.updatedTs = updatedTs;
	}

	public AllState getAllState() {
		return allState;
	}

	public void setAllState(AllState allState) {
		this.allState = allState;
	}

	public LocalityPl getLocality() {
		return locality;
	}

	public void setLocality(LocalityPl locality) {
		this.locality = locality;
	}
	
}