package com.energytrade.app.controller;

import java.util.Hashtable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.energytrade.app.services.CommonService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public class CommonController extends AbstractBaseController
{
    @Autowired
    private CommonService commonService;
    
    @RequestMapping(value =REST+"getAllElectricityBoard" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getAllElectricityBoard() {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getAllElectricityBoard());
    	return response;
    }
    
    @RequestMapping(value =REST+"getAllState" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getAllState() {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getAllState());
    	return response;
    }
    
    @RequestMapping(value =REST+"getUserRolesPl" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getUserRolesPl() {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getUserRolesPl());
    	return response;
    }
    
    @RequestMapping(value =REST+"getStateBoardMapping/{stateId}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getStateBoardMapping(@PathVariable("stateId") String StateId ) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getStateBoardMapping(Integer.parseInt(StateId)));
    	return response;
    }
    
    @RequestMapping(value =REST+"getStateLocalityMapping/{stateId}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getStateBoardgetStateLocalitymappingMapping(@PathVariable("stateId") String StateId ) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getStateLocalitymapping(Integer.parseInt(StateId)));
    	return response;
    }
    
    @RequestMapping(value =REST+"getUserTypePl" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getUserTypePl() {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getUserTypePl());
    	return response;
    }
    
    @RequestMapping(value =REST+"getDevicePl" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public HashMap<String,Object> getDevicePl() {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	response.put("response", commonService.getDevicePl());
    	return response;
    }
    }
