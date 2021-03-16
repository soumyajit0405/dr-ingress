package com.energytrade.app.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energytrade.app.dao.CommonDao;
import com.energytrade.app.dao.LoginDao;
import com.energytrade.app.dao.UserProfileDao;
import com.energytrade.app.dto.AllElectricityBoardDto;
import com.energytrade.app.dto.AllStateDto;
import com.energytrade.app.dto.StateBoardMappingDto;
import com.energytrade.app.dto.UserRolesPlDto;
import com.energytrade.app.dto.UserTypePlDto;

@Service("userProfileService")
public class UserProfileService extends AbstractBaseService
{
    @Autowired
    private UserProfileDao userprofiledao;
    
    public HashMap<String,Object> addDevice(HashMap<String,Object> deviceDetails) {
        return this.userprofiledao.addDevice(deviceDetails);
    }
    
    public HashMap<String,Object> deleteDevice(HashMap<String,Object> deviceDetails) {
        return this.userprofiledao.deleteDevice(deviceDetails);
    }
       
    public HashMap<String,Object> getAllUserDevices(int userId) {
        return this.userprofiledao.getAllUserDevices(userId);
    }
    
    public HashMap<String,Object> getp2pUserProfile(int userId){
    	return this.userprofiledao.getp2pUserProfile(userId);
    }
    
}