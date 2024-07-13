package com.energytrade.app.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.energytrade.app.services.LoginService;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class LoginController extends AbstractBaseController
{
    @Autowired
    private LoginService loginservice;
    
    @RequestMapping(value =REST+"verifyOtp" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> verifyOtp(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.verifyOtp(inputDetails.get("phone"), inputDetails.get("otp")));
    	return response;
    }
    
    @RequestMapping(value =REST+"loginUser" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> loginUser(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.loginUser(inputDetails.get("phone"), inputDetails.get("otp")));
    	return response;
    }
    
    @RequestMapping(value =REST+"sendRegistrationOTP" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> createUser(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.createUser(inputDetails.get("phone"),inputDetails.get("userType")));
    	return response;
    }
    
    @RequestMapping(value =REST+"registerUser" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> createUserExtraDetails(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.createUserExtraDetails(inputDetails.get("phone"),inputDetails.get("fullName"),inputDetails.get("email"),Integer.parseInt(inputDetails.get("stateId")),Integer.parseInt(inputDetails.get("boardId")),Integer.parseInt(inputDetails.get("localityId")), inputDetails.get("uniqueServiceNumber")));
    	return response;
    }
    
    @RequestMapping(value =REST+"getUserDetails" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> getUserDetails(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.getUserDetails(Integer.parseInt(inputDetails.get("userId"))));
    	return response;
    }
    
    @RequestMapping(value =REST+"updateProfile" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> updateProfile(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.updateProfile(Integer.parseInt(inputDetails.get("userId")),inputDetails.get("name"),inputDetails.get("email")));
    	return response;
    }
    
    @RequestMapping(value =REST+"sendLoginOTP" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> generateOtp(@RequestBody HashMap<String,String> inputDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", loginservice.generateOtp(inputDetails.get("phone")));
    	return response;
    }
    
    @RequestMapping(value ="catchOauthToken" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public void getKiotToken(@RequestParam("code") String newauthcode) {
        
    	System.out.println("Token from Kiot " +newauthcode);
    }
    
   }
