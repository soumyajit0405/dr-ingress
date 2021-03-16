package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the all_blockchain_transactions database table.
 * 
 */
@Entity
@Table(name="all_blockchain_transactions")
@NamedQuery(name="AllBlockchainTransaction.findAll", query="SELECT a FROM AllBlockchainTransaction a")
public class AllBlockchainTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="all_blockchain_trx_id")
	private int allBlockchainTrxId;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Column(name="general_order_id")
	private int generalOrderId;

	private byte softdeleteflag;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="transaction_type")
	private String transactionType;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;
	
	@Column(name="blockchain_trx_id")
	private String blockChainTrxId;

	

	public String getBlockChainTrxId() {
		return blockChainTrxId;
	}

	public void setBlockChainTrxId(String blockChainTrxId) {
		this.blockChainTrxId = blockChainTrxId;
	}

	//bi-directional many-to-one association to AllBlockchainOrder
	@ManyToOne
	@JoinColumn(name="blockchain_order_id")
	private AllBlockchainOrder allBlockchainOrder;

	public AllBlockchainTransaction() {
	}

	public int getAllBlockchainTrxId() {
		return this.allBlockchainTrxId;
	}

	public void setAllBlockchainTrxId(int allBlockchainTrxId) {
		this.allBlockchainTrxId = allBlockchainTrxId;
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

	public int getGeneralOrderId() {
		return this.generalOrderId;
	}

	public void setGeneralOrderId(int generalOrderId) {
		this.generalOrderId = generalOrderId;
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

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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

	public AllBlockchainOrder getAllBlockchainOrder() {
		return this.allBlockchainOrder;
	}

	public void setAllBlockchainOrder(AllBlockchainOrder allBlockchainOrder) {
		this.allBlockchainOrder = allBlockchainOrder;
	}

}