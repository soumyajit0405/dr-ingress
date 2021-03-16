package com.energytrade.app.dao;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.DevicePl;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.StateLocalityMapping;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommonRepository extends JpaRepository<AllUser, Long>
{
    @Query("Select a from AllElectricityBoard a")
    List<AllElectricityBoard> getAllElectricityBoard( );
    
    @Query("Select a from AllState a")
   List<AllState> getAllState( );
    
    @Query("Select a from UserRolesPl a")
    List<UserRolesPl> getUserRolesPl( );
    
    @Query("Select a from UserTypePl a")
    List<UserTypePl> getUserTypePl( );
    
    @Query("Select a from StateBoardMapping a where a.allState.stateId=?1")
    List<StateBoardMapping> getStateBoardMapping( int stateId);
    
    @Query("Select a from DevicePl a")
    List<DevicePl> getDevicesPl( );
    
    @Query("Select a from StateLocalityMapping a where a.allState.stateId=?1")
    List<StateLocalityMapping> getStateLocality( int stateId);
}