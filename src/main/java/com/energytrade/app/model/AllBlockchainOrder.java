package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the all_blockchain_orders database table.
 * 
 */
@Entity
@Table(name="all_blockchain_orders")
@NamedQuery(name="AllBlockchainOrder.findAll", query="SELECT a FROM AllBlockchainOrder a")
public class AllBlockchainOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_blockchain_orders_id")
	private int allBlockchainOrdersId;

	@Column(name="batch_id")
	private String batchId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="effective_date")
	private Date effectiveDate;

	@Column(name="general_order_id")
	private int generalOrderId;

	@Column(name="order_id")
	private String orderId;

	@Column(name="order_type")
	private String orderType;

	private byte softdeleteflag;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;

	//bi-directional many-to-one association to AllBlockchainTransaction
	@OneToMany(mappedBy="allBlockchainOrder")
	private List<AllBlockchainTransaction> allBlockchainTransactions;

	public AllBlockchainOrder() {
	}

	public int getAllBlockchainOrdersId() {
		return this.allBlockchainOrdersId;
	}

	public void setAllBlockchainOrdersId(int allBlockchainOrdersId) {
		this.allBlockchainOrdersId = allBlockchainOrdersId;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
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

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public int getGeneralOrderId() {
		return this.generalOrderId;
	}

	public void setGeneralOrderId(int generalOrderId) {
		this.generalOrderId = generalOrderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public byte getSoftdeleteflag() {
		return this.softdeleteflag;
	}

	public void setSoftdeleteflag(byte softdeleteflag) {
		this.softdeleteflag = softdeleteflag;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<AllBlockchainTransaction> getAllBlockchainTransactions() {
		return this.allBlockchainTransactions;
	}

	public void setAllBlockchainTransactions(List<AllBlockchainTransaction> allBlockchainTransactions) {
		this.allBlockchainTransactions = allBlockchainTransactions;
	}

	public AllBlockchainTransaction addAllBlockchainTransaction(AllBlockchainTransaction allBlockchainTransaction) {
		getAllBlockchainTransactions().add(allBlockchainTransaction);
		allBlockchainTransaction.setAllBlockchainOrder(this);

		return allBlockchainTransaction;
	}

	public AllBlockchainTransaction removeAllBlockchainTransaction(AllBlockchainTransaction allBlockchainTransaction) {
		getAllBlockchainTransactions().remove(allBlockchainTransaction);
		allBlockchainTransaction.setAllBlockchainOrder(null);

		return allBlockchainTransaction;
	}

}