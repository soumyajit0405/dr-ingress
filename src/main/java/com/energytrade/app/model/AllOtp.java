package com.energytrade.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the all_otp database table.
 * 
 */
@Entity
@Table(name="all_otp")
@NamedQuery(name="AllOtp.findAll", query="SELECT a FROM AllOtp a")
public class AllOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="otp_id")
	private int otpId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="generated_time")
	private Date generatedTime;

	private String otp;

	private byte softdeleteflag;

	//bi-directional many-to-one association to AllUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private AllUser allUser;

	public AllOtp() {
	}

	public int getOtpId() {
		return this.otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public Date getGeneratedTime() {
		return this.generatedTime;
	}

	public void setGeneratedTime(Date generatedTime) {
		this.generatedTime = generatedTime;
	}

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public byte getSoftdeleteflag() {
		return this.softdeleteflag;
	}

	public void setSoftdeleteflag(byte softdeleteflag) {
		this.softdeleteflag = softdeleteflag;
	}

	public AllUser getAllUser() {
		return this.allUser;
	}

	public void setAllUser(AllUser allUser) {
		this.allUser = allUser;
	}

}