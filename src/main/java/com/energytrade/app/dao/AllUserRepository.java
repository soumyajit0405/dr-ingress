package com.energytrade.app.dao;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.DeviceRepository;
import com.energytrade.app.model.LocalityPl;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllUserRepository extends JpaRepository<AllUser, Long>
{
    @Query("Select count(a.otpId) from AllOtp a where a.allUser.phoneNumber=?1 and a.otp=?2 ")
    int loginUser(String phone,String otp );
    
    @Query("Select count(a.userId) from AllUser a where a.email=?1 and a.password=?2 ")
    int loginDSOUser(String email,String password );
    
    @Query("Select count(a.uniqueServiceNumber) from AllUser a where a.uniqueServiceNumber=?1")
    int getUSNCount(String uniqueServiceNumber );
    
    @Query("Select count(a.usn) from DeviceRepository a where a.usn=?1")
    int checkUSNExistence(String uniqueServiceNumber );
    
    @Query("Select count(a.userId) from AllUser a where a.phoneNumber=?1")
    int checkPhoneNumberExistence(String phone );
    
    @Query("Select count(a.userAccessTypeMappingId) from UserAccessTypeMapping a where a.allUser.userId=?1 and a.userTypepl.userTypeName=?2")
    int checkUserAccessLevel(int userId, String userType );
    
    @Query("Select COALESCE(max(a.userId),0) from AllUser a")
    int getUserCount( );
    
    @Query("Select a from AllUser a where a.phoneNumber=?1")
    AllUser getUserIdByPhone(String phone );
    
    @Query("Select a from AllUser a where a.userId=?1")
    AllUser getUserIdById(int userId );
    
    @Query("Select a from UserRolesPl a where a.userRoleName=?1")
    UserRolesPl getUserRole(String role );
    
    @Query("Select a from UserTypePl a where a.userTypeName=?1")
    UserTypePl getUserType(String type );
    
    @Modifying
    @Query("update AllUser a set a.fullName=?1,a.allState.stateId=?2,a.allElectricityBoard.electricityBoardId=?3,a.email=?4,a.locality.localityId=?6,a.userRolesPl.userRoleId=?7,a.uniqueServiceNumber=?8 where a.phoneNumber=?5")
     void createUserExtraDetails(String fullName,int stateId,int boardId,String email,String phone ,int localityId, int roleId,String usn);
    
    @Modifying
    @Query("update AllUser a set a.fullName=?1,a.email=?2 where a.userId=?3")
     void updateUser(String fullName,String email,int userId );
    
    @Modifying
    @Query("update AllOtp a set a.otp=?1 where a.allUser.phoneNumber=?2")
     void updateOtp(String otp,String phone );
    
    @Query("Select a from DeviceRepository a where a.usn=?1")
    DeviceRepository getDeviceRepository(String usn );
}