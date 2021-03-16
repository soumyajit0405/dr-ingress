package com.energytrade.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energytrade.app.dao.CommonDao;
import com.energytrade.app.dto.AllElectricityBoardDto;
import com.energytrade.app.dto.AllStateDto;
import com.energytrade.app.dto.DevicePlDto;
import com.energytrade.app.dto.StateBoardMappingDto;
import com.energytrade.app.dto.StateLocalityMappingDto;
import com.energytrade.app.dto.UserRolesPlDto;
import com.energytrade.app.dto.UserTypePlDto;
import com.energytrade.app.model.DevicePl;

@Service("coomonservice")
public class CommonService extends AbstractBaseService
{
    @Autowired
    private CommonDao commondao;
    
    public List<AllElectricityBoardDto> getAllElectricityBoard() {
        return this.commondao.getAllElectricityBoard();
    }
    
    public List<AllStateDto> getAllState() {
    	return this.commondao.getAllState();
    }
    
    public List<UserRolesPlDto> getUserRolesPl() {
        return this.commondao.getUserRolesPl();
    }
    
    public List<UserTypePlDto> getUserTypePl() {
        return this.commondao.getUserTypePl();
    }
    
    public List<StateBoardMappingDto> getStateBoardMapping(int stateId) {
        return this.commondao.getStateBoardMapping(stateId);
    }
    
    public List<StateLocalityMappingDto> getStateLocalitymapping(int stateId) {
        return this.commondao.getStateLocalitymapping(stateId);
    }
    
    public List<DevicePlDto> getDevicePl() {
        return this.commondao.getDevicePl();
    }
    
    
    
}