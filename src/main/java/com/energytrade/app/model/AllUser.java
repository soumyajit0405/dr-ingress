package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the all_users database table.
 * 
 */
@Entity
@Table(name="all_users")
@NamedQuery(name="AllUser.findAll", query="SELECT a FROM AllUser a")
public class AllUser implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="user_id")
	private int userId;

	@Column(name="active_status")
	private byte activeStatus;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deactivation_date")
	private Date deactivationDate;

	private String email;

	@Column(name="full_name")
	private String fullName;
	

	@Column(name="password")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="dr_contract_number")
	private String drContractNumber;

	public String getDrContractNumber() {
		return drContractNumber;
	}

	public void setDrContractNumber(String drContractNumber) {
		this.drContractNumber = drContractNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registration_date")
	private Date registrationDate;

	private byte softdeleteflag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sync_ts")
	private Date syncTs;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_ts")
	private Date updatedTs;
	
	@Column(name="unique_service_number")
	private String uniqueServiceNumber;
	
	public String getUniqueServiceNumber() {
		return uniqueServiceNumber;
	}

	public void setUniqueServiceNumber(String uniqueServiceNumber) {
		this.uniqueServiceNumber = uniqueServiceNumber;
	}

	@JsonIgnore
	//bi-directional many-to-one association to AllOtp
	@OneToMany(mappedBy="allUser")
	private List<AllOtp> allOtps;


	@JsonIgnore
	//bi-directional many-to-one association to AllOtp
	@OneToMany(mappedBy="allUser")
	private List<UserAccessTypeMapping> userAccessMap;

	public List<UserAccessTypeMapping> getUserAccessMap() {
		return userAccessMap;
	}

	public void setUserAccessMap(List<UserAccessTypeMapping> userAccessMap) {
		this.userAccessMap = userAccessMap;
	}

	//bi-directional many-to-one association to AllState
	@ManyToOne
	@JoinColumn(name="state_id")
	private AllState allState;
	
	//bi-directional many-to-one association to AllState
		@ManyToOne
		@JoinColumn(name="locality_id")
		private LocalityPl locality;

	public LocalityPl getLocality() {
			return locality;
		}

		public void setLocality(LocalityPl locality) {
			this.locality = locality;
		}

	//bi-directional many-to-one association to AllElectricityBoard
	@ManyToOne
	@JoinColumn(name="electricity_board_id")
	private AllElectricityBoard allElectricityBoard;

	//bi-directional many-to-one association to UserRolesPl
	@ManyToOne
	@JoinColumn(name="user_role_id")
	private UserRolesPl userRolesPl;

	//bi-directional many-to-one association to UserTypePl
	@ManyToOne
	@JoinColumn(name="user_type_id")
	private UserTypePl userTypePl;

	public AllUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getDeactivationDate() {
		return this.deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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

	public List<AllOtp> getAllOtps() {
		return this.allOtps;
	}

	public void setAllOtps(List<AllOtp> allOtps) {
		this.allOtps = allOtps;
	}

	public AllOtp addAllOtp(AllOtp allOtp) {
		getAllOtps().add(allOtp);
		allOtp.setAllUser(this);

		return allOtp;
	}

	public AllOtp removeAllOtp(AllOtp allOtp) {
		getAllOtps().remove(allOtp);
		allOtp.setAllUser(null);

		return allOtp;
	}

	public AllState getAllState() {
		return this.allState;
	}

	public void setAllState(AllState allState) {
		this.allState = allState;
	}

	public AllElectricityBoard getAllElectricityBoard() {
		return this.allElectricityBoard;
	}

	public void setAllElectricityBoard(AllElectricityBoard allElectricityBoard) {
		this.allElectricityBoard = allElectricityBoard;
	}

	public UserRolesPl getUserRolesPl() {
		return this.userRolesPl;
	}

	public void setUserRolesPl(UserRolesPl userRolesPl) {
		this.userRolesPl = userRolesPl;
	}

	public UserTypePl getUserTypePl() {
		return this.userTypePl;
	}

	public void setUserTypePl(UserTypePl userTypePl) {
		this.userTypePl = userTypePl;
	}

}