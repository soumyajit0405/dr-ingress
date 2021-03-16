package com.energytrade.app.controller;

import java.util.Hashtable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.energytrade.app.services.CommonService;
import com.energytrade.app.services.LoginService;
import com.energytrade.app.services.UserProfileService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public class UserProfileController extends AbstractBaseController
{
    @Autowired
    private UserProfileService userProfileService;
    
    @RequestMapping(value =REST+"addDevice" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> addDevice(@RequestBody HashMap<String,Object> deviceDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", userProfileService.addDevice(deviceDetails));
    	return response;
    }
    
    @RequestMapping(value =REST+"deleteDevice" , method =  RequestMethod.POST , headers =  "Accept=application/json" )
    public HashMap<String,Object> deleteDevice(@RequestBody HashMap<String,Object> deviceDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", userProfileService.deleteDevice(deviceDetails));
    	return response;
    }
    
    @RequestMapping(value =REST+"getUserDevices/{userId}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getUserDevices(@PathVariable int userId) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", userProfileService.getAllUserDevices(userId));
    	return response;
    }
    
    @RequestMapping(value =REST+"getp2pUserProfile/{userId}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getp2pUserProfile(@PathVariable int userId) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", userProfileService.getp2pUserProfile(userId));
    	return response;
    }
  }
