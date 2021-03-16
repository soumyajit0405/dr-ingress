package com.energytrade.app.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energytrade.app.dao.CommonDao;
import com.energytrade.app.dao.LoginDao;
import com.energytrade.app.dto.AllElectricityBoardDto;
import com.energytrade.app.dto.AllStateDto;
import com.energytrade.app.dto.StateBoardMappingDto;
import com.energytrade.app.dto.UserRolesPlDto;
import com.energytrade.app.dto.UserTypePlDto;

@Service("loginservice")
public class LoginService extends AbstractBaseService
{
    @Autowired
    private LoginDao logindao;
    
    public  HashMap<String,Object> loginUser(String phone,String otp){
        return this.logindao.loginUser(phone, otp);
    }
    
    public  HashMap<String,Object> verifyOtp(String phone,String otp){
        return this.logindao.verifyOtp(phone, otp);
    }
    
    public  HashMap<String,Object> createUser(String phone, String userType){
        return this.logindao.createUser(phone, userType);
    }
    
    public HashMap<String,Object> createUserExtraDetails(String phone,String fullname,String email, int stateId, int boardId, int localityId, String usn) {
        return this.logindao.createUserExtraDetails(phone,fullname,email,stateId,boardId,localityId, usn);
    }
    
    public HashMap<String,Object> getUserDetails(int userId) {
        return this.logindao.getUserDetails(userId);
    }
    
    public HashMap<String,Object> updateProfile(int userId,String name,String email) {
        return this.logindao.updateProfile(userId,name,email);
    }
    
    public HashMap<String,Object> generateOtp(String phone) {
        return this.logindao.generateOtp(phone);
    }

    public HashMap<String,Object> loginDSOUser(String email, String password) {
        return this.logindao.loginDSOUser(email,password);
    }
    
    
    
}