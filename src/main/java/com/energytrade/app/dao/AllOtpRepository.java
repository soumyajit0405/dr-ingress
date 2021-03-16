package com.energytrade.app.dao;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllOtp;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllOtpRepository extends JpaRepository<AllOtp, Long>
{
    
	@Query("Select a.otpId from AllOtp a where a.allUser.phoneNumber=?1")
    Integer getOtpForUser(String phone );
	
	@Query("Select count(a.otpId) from AllOtp a where a.allUser.phoneNumber=?1")
    int getOtpCount(String phone );
	
	@Modifying
    @Query("update AllOtp a set a.otp=?1 where a.otpId=?2")
     void updateOtp(String otp,int otpId);
        
}