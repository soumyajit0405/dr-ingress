package com.energytrade.app.dao;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.energytrade.app.model.AgentMeterPl;
import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.DevicePl;
import com.energytrade.app.model.GeneralConfig;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.UserDevice;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice, Long>
{

    @Query("Select a from DevicePl a where a.deviceTypeId=?1")
    DevicePl getDevice( int deviceId);   
    
    @Query("Select COALESCE(max(a.userDeviceId),0) from UserDevice a ")
    int getUserDeviceCount();   
    
    
    @Modifying
    @Query("update UserDevice a set a.softdeleteflag=?1  where a.allUser.userId=?2 and a.devicePl.deviceTypeId=?3")
     void deleteDevice(byte deleteFlag, int userId, int deviceId);
   
    @Query("Select a from UserDevice a where a.allUser.userId=?1")
    List<UserDevice> getUserDeviceById(int userId);
    
    @Query("Select a from GeneralConfig a where a.name in ?1")
    ArrayList<GeneralConfig> getBlockChainConfig(ArrayList<String> listOfValues);
    
    @Query("Select a.agentMeterId from AgentMeterPl a where a.agentMeterName=?1")
    int getAgentMeterDetails(String agentMeterName);   
       
}