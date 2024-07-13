package com.energytrade.app.dao;

import java.net.HttpURLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.energytrade.AppStartupRunner;
import com.energytrade.app.dto.AllElectricityBoardDto;
import com.energytrade.app.dto.AllStateDto;
import com.energytrade.app.dto.AllUserDto;
import com.energytrade.app.dto.StateBoardMappingDto;
import com.energytrade.app.dto.UserRolesPlDto;
import com.energytrade.app.dto.UserTypePlDto;
import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllOtp;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.GeneralConfig;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.UserAccessTypeMapping;
import com.energytrade.app.model.UserBlockchainKey;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;
import com.energytrade.app.util.CommonUtility;
import com.energytrade.app.util.CustomMessages;
import com.energytrade.app.util.HttpConnectorHelper;



@Transactional
@Repository
public class LoginDao extends AbstractBaseDao
{
	@Autowired
    AllUserRepository alluserrepo;
	
	@Autowired
    AllOtpRepository allotprepo;
	
	@Autowired
    UserBlockchainKeyRepository ubcrepo;
	
	@Autowired
    UserAccessRepository useraccessrepo;
	
	@Autowired
    UserDeviceRepository userdevicerepo;
	
	@Autowired
	HttpConnectorHelper httpconnectorhelper;
	
	@Autowired
	BlockchainDao bcdao;
    
    public HashMap<String,Object> loginUser(String phone,String otp) {
         
    	HashMap<String,Object> response=new HashMap<String, Object>();
        try {
       int count=this.alluserrepo.loginUser(phone, otp);
       AllUser alluser= alluserrepo.getUserIdByPhone(phone);
       if(count >= 1) {
    	   response.put("message",CustomMessages.getCustomMessages("OTS"));
    	   response.put("key","200");
    	   response.put("userId",alluser.getUserId());
    	   response.put("userRole",alluser.getUserRolesPl().getUserRoleName());
//    	   if (alluser.getLocality() != null) {
//    		   response.put("localityId",alluser.getLocality().getLocalityId());
//    		   response.put("localityName",alluser.getLocality().getLocalityName());
//    	   } 
//    	   
//    	   response.put("userName",alluser.getFullName());
//    	   if (alluser.getAllElectricityBoard() != null) {
//    		   response.put("boardId",alluser.getAllElectricityBoard().getElectricityBoardId());   
//    	   }
//    	   if (alluser.getAllState() != null) {
//    	   response.put("stateId",alluser.getAllState().getStateId());
//    	   }
//    	   if (alluser.getUniqueServiceNumber() != null) {
//    	   response.put("uniqueServiceNumber",alluser.getUniqueServiceNumber());
//    	   }
    	   //response.put("uniqueServiceNumber",alluser.getUniqueServiceNumber());
    	   response.put("name",alluser.getFullName());
    	   response.put("phoneNumber",alluser.getPhoneNumber());
    	   List<HashMap<String,String>> listOfAccessLevels = new ArrayList<>();
    	   if (alluser.getUserAccessMap() != null) {
    		   for (int i=0;i<alluser.getUserAccessMap().size();i++) {
    			   HashMap<String,String> userAccessLevel = new HashMap<>();
    			   userAccessLevel.put("accessLevel", alluser.getUserAccessMap().get(i).getUserTypepl().getUserTypeName());
    			   listOfAccessLevels.add(userAccessLevel);
    			   
    		   }
    	   response.put("userTypes", listOfAccessLevels);
    	   }
    	  // GeneralConfig bcConfig = userdevicerepo.getBlockChainConfig("block_chain");
    	   String bcStatus = AppStartupRunner.configValues.get("blockChain");
    	   if (bcStatus.equalsIgnoreCase("Y")) {
    		   String blockChainURL = AppStartupRunner.configValues.get("blockChainUATUrl");
    	   UserBlockchainKey ubckey = ubcrepo.getUserBlockChainKey(alluser.getUserId());
    	   JSONObject data = new JSONObject();
    	  data.put("userid", ubckey.getBlockChainUserId());
    	  HashMap<String,String>  responseFrombcnetwork = httpconnectorhelper.sendPost(blockChainURL+"/login", data, 1);
    	  bcdao.updateAuthToken(responseFrombcnetwork.get("accessToken"), (String)data.get("userid"));
    	   }
       }
       else if(count < 1) {
    	   response.put("message",CustomMessages.getCustomMessages("OTF"));
    	   response.put("key","300");
       }
        
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }
    
    public HashMap<String,Object> verifyOtp(String phone,String otp) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
        try {
       int count=this.alluserrepo.loginUser(phone, otp);
       AllUser alluser= alluserrepo.getUserIdByPhone(phone);
       if(count >= 1) {
    	   response.put("message",CustomMessages.getCustomMessages("OTS"));
    	   response.put("key","200");
    	   response.put("userId",alluser.getUserId());
    	   response.put("userRole",alluser.getUserRolesPl().getUserRoleName());
    	   
       }
       else if(count < 1) {
    	   response.put("message",CustomMessages.getCustomMessages("OTF"));
    	   response.put("key","300");
       }
        
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }
    
    public HashMap<String,Object> createUser(String phone, String userType) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
    	 CommonUtility cm=new CommonUtility();
    	  int count=0;
        try {
        count=this.alluserrepo.checkPhoneNumberExistence(phone);
       if(count >= 1) {
    	   AllUser user = alluserrepo.getUserIdByPhone(phone);
    	   count = alluserrepo.checkUserAccessLevel(user.getUserId(), userType);
    	   if (count >= 1) {
    		   response.put("message",CustomMessages.getCustomMessages("USE"));
    		   response.put("userId",user.getUserId());
    		   response.put("accessExist",true);
        	   response.put("key","300");   
    	   } else {
    		   response.put("userId",user.getUserId());
    		   response.put("accessExist",false);
        	   response.put("message",CustomMessages.getCustomMessages("USE"));
        	   response.put("key","200");
          
    	   }
     } else {
    	 Timestamp ts =new Timestamp(System.currentTimeMillis());
  	   UserRolesPl userrole= alluserrepo.getUserRole("User");
  	   // UserTypePl userType = alluserrepo.getUserType("P2P");
  	   int userId=alluserrepo.getUserCount();
  	   AllUser alluser=new AllUser();
  	   alluser.setPhoneNumber(phone);
  	   alluser.setUserId(userId+ 1);
  	   alluser.setUserRolesPl(userrole);
  	   // alluser.setUserTypePl(userType);
  	   alluserrepo.saveAndFlush(alluser);
  	   AllOtp allotp=new AllOtp();
  	   // allotp.setOtp(cm.generateOTPCode());
  	   allotp.setOtp("1111");
  	   allotp.setAllUser(alluser);
  	   allotp.setGeneratedTime(ts);
  	   allotprepo.saveAndFlush(allotp);
  	 response.put("userId",alluser.getUserId());
  	   response.put("message",CustomMessages.getCustomMessages("AS"));
  	   response.put("key","200");
  
     }
//       else if(count < 1) {
//    	   
//    	 
//        }
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }
    
public HashMap<String,Object> createUserExtraDetails(String phone,String fullname,String email, int stateId, int boardId, int localityId, String usn) {
        
    	HashMap<String,Object> response=new HashMap<String, Object>();
        try {
        	int countUSN = alluserrepo.getUSNCount(usn);
        	if (countUSN == 0) 
        	{
        		countUSN = alluserrepo.checkUSNExistence(usn);
        		if (countUSN == 0) 
        		{
        			response.put("message",CustomMessages.getCustomMessages("UNE"));
          		   response.put("key","300");
          		   return response;
        		}
        	UserRolesPl userrole= alluserrepo.getUserRole("User");
        	UserTypePl userType = alluserrepo.getUserType("P2P");
       alluserrepo.createUserExtraDetails(fullname, stateId, boardId, email, phone, localityId,userrole.getUserRoleId(),usn);
       AllUser alluser= alluserrepo.getUserIdByPhone(phone);
       UserAccessTypeMapping ustmp = new UserAccessTypeMapping();
       ustmp.setAllUser(alluser);
       ustmp.setUserTypepl(userType);
       useraccessrepo.saveAndFlush(ustmp);
       List<HashMap<String,String>> listOfAccessLevels = new ArrayList<>();
	   if (alluser.getUserAccessMap() != null) {
		   for (int i=0;i<alluser.getUserAccessMap().size();i++) {
			   HashMap<String,String> userAccessLevel = new HashMap<>();
			   userAccessLevel.put("accessLevel", alluser.getUserAccessMap().get(i).getUserTypepl().getUserTypeName());
			   listOfAccessLevels.add(userAccessLevel);
			   
		   }
	   response.put("userTypes", listOfAccessLevels);
//	   List<HashMap<String,String>> listOfAccessLevels = new ArrayList<>();
//	   	   HashMap<String,String> userAccessLevel = new HashMap<>();
//			   userAccessLevel.put("accessLevel",userType.getUserTypeName());
//			   listOfAccessLevels.add(userAccessLevel);
//			   
	   // response.put("accessLevel", listOfAccessLevels);
	   
        response.put("message",CustomMessages.getCustomMessages("AS"));
	   response.put("key","200");
	   response.put("userId",alluser.getUserId());
	   response.put("phoneNumber",alluser.getPhoneNumber());
	   response.put("name",alluser.getFullName());
	   response.put("userRole",alluser.getUserRolesPl().getUserRoleName());
	   } 
        }
        	else {
     		   response.put("message",CustomMessages.getCustomMessages("DUS"));
     		   response.put("key","300");
     	   }
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            response.put("message",CustomMessages.getCustomMessages("ISE"));
     	   response.put("key","500");
           
        }
        return response;
    }

public HashMap<String,Object> getUserDetails(int userId) {
    
	HashMap<String,Object> response=new HashMap<String, Object>();
    try {
   
   AllUser alluser=alluserrepo.getUserIdById(userId);
   if(alluser != null) {
   AllUserDto alluserdto=new AllUserDto();
   alluserdto.setActiveStatus(alluser.getActiveStatus());
   if (alluser.getAllElectricityBoard() != null) {
	   alluserdto.setBoardId(alluser.getAllElectricityBoard().getElectricityBoardId());
	   alluserdto.setBoardName(alluser.getAllElectricityBoard().getElectricityBoardName());
   } 
   if (alluser.getAllState() != null) {
	   alluserdto.setStateId(alluser.getAllState().getStateId());
	   alluserdto.setStateName(alluser.getAllState().getStateName());
   }
   alluserdto.setEmail(alluser.getEmail());
   alluserdto.setFullName(alluser.getFullName());
   if (alluser.getLocality() != null) {
	   alluserdto.setLocalityName(alluser.getLocality().getLocalityName());
	   alluserdto.setLocalityId(alluser.getLocality().getLocalityId());
   }
   alluserdto.setUserId(userId);
   if (alluser.getUniqueServiceNumber() != null) {
	   alluserdto.setUniqueServiceNumber(alluser.getUniqueServiceNumber());   
   }
   if (alluser.getRegistrationDate() != null) {
	   alluserdto.setRegistrationDate(alluser.getRegistrationDate());
	} 
   if (alluser.getDrContractNumber() != null) {
	   alluserdto.setDrContractNumber (alluser.getDrContractNumber());
	} 
	response.put("activeStatus", alluser.getActiveStatus());
   response.put("userDetails",alluserdto);
   response.put("message",CustomMessages.getCustomMessages("PR"));
   response.put("key","200");
   }
   else {
	   response.put("message",CustomMessages.getCustomMessages("NSU"));
	   response.put("key","300");
   }
    }
    catch (Exception e) {
        System.out.println("Error in checkExistence" + e.getMessage());
        e.printStackTrace();
        response.put("message",CustomMessages.getCustomMessages("ISE"));
 	   response.put("key","500");
       
    }
    return response;
}




public HashMap<String,Object> updateProfile(int userId,String name,String email) {
    
	HashMap<String,Object> response=new HashMap<String, Object>();
    try {
    	AllUser alluser=alluserrepo.getUserIdById(userId);
    	   if(alluser != null) {
    	   
   alluserrepo.updateUser(name, email, userId);
   response.put("message",CustomMessages.getCustomMessages("XYZ"));
   response.put("key","200");
    	   }
    	   else {
    		   response.put("message",CustomMessages.getCustomMessages("NSU"));
    		   response.put("key","300");
    	   }
   
    }
    catch (Exception e) {
        System.out.println("Error in checkExistence" + e.getMessage());
        e.printStackTrace();
        response.put("message",CustomMessages.getCustomMessages("ISE"));
 	   response.put("key","500");
       
    }
    return response;
}

public HashMap<String,Object> generateOtp(String phone) {
    
	HashMap<String,Object> response=new HashMap<String, Object>();
	  int count=0;
   try {
	  count = alluserrepo.checkPhoneNumberExistence(phone) ;
	  if(count > 0) {
		  count = allotprepo.getOtpCount(phone);
		  if (count > 0) 
		  {
			  allotprepo.updateOtp("1111", count);
			   response.put("message",CustomMessages.getCustomMessages("XYZ"));
			   response.put("key","200");	  
		  } else {
			  Timestamp ts = new Timestamp(System.currentTimeMillis());
			  AllUser alluser= alluserrepo.getUserIdByPhone(phone);
			  AllOtp allotp=new AllOtp();
	    	   // allotp.setOtp(cm.generateOTPCode());
	    	   allotp.setOtp("1111");
	    	   allotp.setAllUser(alluser);
	    	   allotp.setGeneratedTime(ts);
	    	   allotprepo.saveAndFlush(allotp);
	    	   response.put("message",CustomMessages.getCustomMessages("XYZ"));
			   response.put("key","200");
		  }
	  }
  else {
	  response.put("message",CustomMessages.getCustomMessages("NSU"));
	   response.put("key","300");
  }

    }
    catch (Exception e) {
        System.out.println("Error in checkExistence" + e.getMessage());
        e.printStackTrace();
        response.put("message",CustomMessages.getCustomMessages("ISE"));
 	   response.put("key","500");
       
    }
    return response;
}


public HashMap<String,Object> loginDSOUser(String email,String password) {
    
	HashMap<String,Object> response=new HashMap<String, Object>();
    try {
   int count=this.alluserrepo.loginDSOUser(email, password);
   if(count >= 1) {
	   response.put("message",CustomMessages.getCustomMessages("SL"));
	   response.put("key","200");	   
   }
   else if(count < 1) {
	   response.put("message",CustomMessages.getCustomMessages("WL"));
	   response.put("key","300");
   }
    
    }
    catch (Exception e) {
        System.out.println("Error in checkExistence" + e.getMessage());
        e.printStackTrace();
        response.put("message",CustomMessages.getCustomMessages("ISE"));
 	   response.put("key","500");
       
    }
    return response;
}

public ArrayList<GeneralConfig> getBlockChainValue() {
	ArrayList<GeneralConfig> configValue = new ArrayList<>();
	ArrayList<String> listOfKeys = new ArrayList<>();
	listOfKeys.add("dr_blockchain_enabled");
	listOfKeys.add("blockchain_uat");
	try {
		configValue=userdevicerepo.getBlockChainConfig(listOfKeys);
	}
	catch(Exception e) {
		
	} finally {
		
	}
	return configValue;
}

}