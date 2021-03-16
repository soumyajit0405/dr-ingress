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
@Table(name="agent_meter_pl")
@NamedQuery(name="AgentMeterPl.findAll", query="SELECT d FROM AgentMeterPl d")
public class AgentMeterPl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="agent_meter_id")
	private int agentMeterId;

	@Column(name="created_by")
	private String createdBy;

	public int getAgentMeterId() {
		return agentMeterId;
	}

	public void setAgentMeterId(int agentMeterId) {
		this.agentMeterId = agentMeterId;
	}

	public String getAgentMeterName() {
		return agentMeterName;
	}

	public void setAgentMeterName(String agentMeterName) {
		this.agentMeterName = agentMeterName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Column(name="agent_meter_name")
	private String agentMeterName;

	private byte softdeleteflag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	 public AgentMeterPl() {
		// TODO Auto-generated constructor stub
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