package com.energytrade.app.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.energytrade.AppStartupRunner;
import com.energytrade.app.dto.UserDeviceDto;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.DevicePl;
import com.energytrade.app.model.DeviceRepository;
import com.energytrade.app.model.GeneralConfig;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.UserDevice;
import com.energytrade.app.util.CommonUtility;
import com.energytrade.app.util.CustomMessages;
import com.energytrade.app.util.HttpConnectorHelper;



@Transactional
@Repository
public class UserProfileDao extends AbstractBaseDao
{
	@Autowired
    UserDeviceRepository userdevicerepo;
	
	@Autowired
    AllUserRepository alluserrepo;
	
	@Autowired
	BlockchainDao bcdao;
	
	@Autowired
	HttpConnectorHelper httpconnectorhelper;
	
    public HashMap<String,Object> addDevice(HashMap<String,Object> deviceDetails) {
         
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	HashMap<String,Object> inputDetails = new  HashMap<String, Object>();
    	JSONObject data = new JSONObject();
        try {
        	Float deviceCapacity=0.0f;
        	BigDecimal bgdeviceCapacity=new BigDecimal(0);
        	ArrayList<HashMap<String,String>> deviceList=(ArrayList<HashMap<String,String>>)deviceDetails.get("devices");
        	String userId=(String)deviceDetails.get("userId");
        	AllUser alluser=alluserrepo.getUserIdById(Integer.parseInt(userId));
        	List<UserDevice> listOfUserDevice=new ArrayList<UserDevice>();
        	int count=userdevicerepo.getUserDeviceCount();
        	// GeneralConfig bcConfig = userdevicerepo.getBlockChainConfig("block_chain");
        	String bcStatus = AppStartupRunner.configValues.get("blockChain");
        	ArrayList<JSONObject> listofDevices = new ArrayList<JSONObject>();
        	for(int i=0;i<deviceList.size();i++) {
        		JSONObject device= new JSONObject();
        		count= count+1;
        		UserDevice  userdevice=new UserDevice();
        		userdevice.setUserDeviceId(count);
        		userdevice.setActiveStatus((byte)1);
        		deviceCapacity=Float.parseFloat(deviceList.get(i).get("deviceCapacity"));
        		bgdeviceCapacity=BigDecimal.valueOf(deviceCapacity);
        		userdevice.setDeviceCapacity(bgdeviceCapacity);
        		DevicePl devicepl=userdevicerepo.getDevice(Integer.parseInt(deviceList.get(i).get("deviceId")));
        		// Code to populate block chain device list
        		int agentMeterId = userdevicerepo.getAgentMeterDetails(devicepl.getDeviceTypeName());
        		device.put("DeviceID",devicepl.getDeviceTypeName());
        		device.put("MeterID",Integer.toString(agentMeterId));
        		userdevice.setDevicePl(devicepl);
        		userdevice.setAllUser(alluser);
        		listOfUserDevice.add(userdevice);
        		listofDevices.add(device);
        		
        	}
        	userdevicerepo.saveAll(listOfUserDevice);
        	JSONObject device= new JSONObject();
        	device.put("DeviceID","NetMeter");
    		device.put("MeterID","6");
    		listofDevices.add(device);
    		
        //	data = "{\"username\":"\""+alluser.getFullName()+"\""}";
        	if (bcStatus.equalsIgnoreCase("Y")) {
        		   String blockChainURL = AppStartupRunner.configValues.get("blockChainUATUrl");
        		DeviceRepository dcb= alluserrepo.getDeviceRepository(alluser.getUniqueServiceNumber());
        	data.put("HWInfo",listofDevices);
        	data.put("username",alluser.getFullName());
        	data.put("url",dcb.getUrl());
        	data.put("phonenumber",alluser.getPhoneNumber());
        	HashMap<String,String> responseFrombcnetwork = httpconnectorhelper.sendPost(blockChainURL+"/createuser", data, 1);
     	   //HashMap<String,String> responseAfterParse = cm.parseInput(responseFrombcnetwork);
     	   if(responseFrombcnetwork.get("Status").equalsIgnoreCase("USER_CREATED")) {
     	   bcdao.createBlockchainKey(alluser,responseFrombcnetwork.get("privatekey"), responseFrombcnetwork.get("publickey"), responseFrombcnetwork.get("User_ID")); // Call BC API and put it in another method
     	   bcdao.addBlockchainTransaction(responseFrombcnetwork.get("TxnID"), "USER_CREATED");
     	  data = new JSONObject();
     	  data.put("userid", responseFrombcnetwork.get("User_ID"));
     	  TimeUnit.SECONDS.sleep(5);
     	  responseFrombcnetwork = httpconnectorhelper.sendPost(blockChainURL+"/login", data, 1);
     	  bcdao.updateAuthToken(responseFrombcnetwork.get("accessToken"), (String)data.get("userid"));
     	   }
        	}
     	   
        	response.put("message",CustomMessages.getCustomMessages("SUC"));
      	   response.put("key","200");
        	
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }
    
    public HashMap<String,Object> deleteDevice(HashMap<String,Object> deviceDetails) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	byte deleteFlag=1;
        try {
        	String userId=(String)deviceDetails.get("userId");
        	ArrayList<Integer> deviceList=(ArrayList<Integer>)deviceDetails.get("devices");
        	for(int i=0;i<deviceDetails.size();i++) {
        		userdevicerepo.deleteDevice(deleteFlag, Integer.parseInt(userId), deviceList.get(i));
        	}
        	response.put("message",CustomMessages.getCustomMessages("SUC"));
      	   response.put("key","200");
        	
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }
    
 public HashMap<String,Object> getAllUserDevices(int userId) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	List<UserDeviceDto> listOfDeviceDto=new ArrayList<UserDeviceDto>();
    	
        try {
        	List<UserDevice> listOfDevices=userdevicerepo.getUserDeviceById(userId);
        	for(int i=0;i<listOfDevices.size();i++) {
        		UserDeviceDto userdevicedto=new UserDeviceDto();
        		userdevicedto.setDeviceTypeId(listOfDevices.get(i).getDevicePl().getDeviceTypeId());
        		userdevicedto.setDeviceTypeName(listOfDevices.get(i).getDevicePl().getDeviceTypeName());
        		userdevicedto.setUserDeviceId(listOfDevices.get(i).getUserDeviceId());
        		userdevicedto.setCapacity(listOfDevices.get(i).getDeviceCapacity());
        		listOfDeviceDto.add(userdevicedto);
        	}
        	response.put("message",CustomMessages.getCustomMessages("SUC"));
      	   response.put("key","200");
      	 response.put("devices",listOfDeviceDto);
        	
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }
 
 
 public HashMap<String,Object> getp2pUserProfile(int userId) {
     
 	HashMap<String,Object> response=new HashMap<String, Object>();
 	List<UserDeviceDto> listOfDeviceDto=new ArrayList<UserDeviceDto>();
 	
     try {
    	 AllUser alluser = alluserrepo.getUserIdById(userId);
    	 if (alluser.getLocality() != null) {
    		 response.put("localityName", alluser.getLocality().getLocalityName());
    		 response.put("localityId", alluser.getLocality().getLocalityId());
    	 }
    	 if (alluser.getAllState() != null) {
    		 response.put("stateId", alluser.getAllState().getStateId());
    		 response.put("stateName", alluser.getAllState().getStateName());
    	 }
    	 if (alluser.getAllElectricityBoard() != null) {
    		 response.put("boardId", alluser.getAllElectricityBoard().getElectricityBoardId());
    	 }
    	 if (alluser.getUniqueServiceNumber() != null) {
    		 response.put("uniqueServiceNumber", alluser.getUniqueServiceNumber());
    	 }
    	 response.put("userName", alluser.getFullName());
    	 response.put("userId", alluser.getUserId());
    	 response.put("userRole", alluser.getUserRolesPl().getUserRoleName());
    	 List<HashMap<String,String>> listOfAccessLevels = new ArrayList<>();
  	   if (alluser.getUserAccessMap() != null) {
  		   for (int i=0;i<alluser.getUserAccessMap().size();i++) {
  			   HashMap<String,String> userAccessLevel = new HashMap<>();
  			   userAccessLevel.put("accessLevel", alluser.getUserAccessMap().get(i).getUserTypepl().getUserTypeName());
  			   listOfAccessLevels.add(userAccessLevel);
  			   
  		   }
  		   }
  	   response.put("userTypes", listOfAccessLevels);
     	List<UserDevice> listOfDevices=userdevicerepo.getUserDeviceById(userId);
     	for(int i=0;i<listOfDevices.size();i++) {
     		UserDeviceDto userdevicedto=new UserDeviceDto();
     		userdevicedto.setDeviceTypeId(listOfDevices.get(i).getDevicePl().getDeviceTypeId());
     		userdevicedto.setDeviceTypeName(listOfDevices.get(i).getDevicePl().getDeviceTypeName());
     		userdevicedto.setUserDeviceId(listOfDevices.get(i).getUserDeviceId());
     		userdevicedto.setCapacity(listOfDevices.get(i).getDeviceCapacity());
     		listOfDeviceDto.add(userdevicedto);
     	}
     	response.put("message",CustomMessages.getCustomMessages("SUC"));
   	   response.put("key","200");
   	 response.put("devices",listOfDeviceDto);
     	
     }
     catch (Exception e) {
         System.out.println("Error in checkExistence" + e.getMessage());
         e.printStackTrace();
         response.put("message",CustomMessages.getCustomMessages("ISE"));
  	   response.put("key","500");
        
     }
     return response;
 }
          
}