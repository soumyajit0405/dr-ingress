package com.energytrade.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.energytrade.app.dto.AllElectricityBoardDto;
import com.energytrade.app.dto.AllStateDto;
import com.energytrade.app.dto.DevicePlDto;
import com.energytrade.app.dto.StateBoardMappingDto;
import com.energytrade.app.dto.StateLocalityMappingDto;
import com.energytrade.app.dto.UserRolesPlDto;
import com.energytrade.app.dto.UserTypePlDto;
import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.DevicePl;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.StateLocalityMapping;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;



@Transactional
@Repository
public class CommonDao extends AbstractBaseDao
{
	@Autowired
    CommonRepository commonrepository;
    
    public List<AllElectricityBoardDto> getAllElectricityBoard() {
         
    	List<AllElectricityBoardDto> aleb =new ArrayList<AllElectricityBoardDto>();
    	
        try {
        List<AllElectricityBoard>	listaeb=this.commonrepository.getAllElectricityBoard();
        for(AllElectricityBoard aeb: listaeb) {
        	AllElectricityBoardDto aebd=new AllElectricityBoardDto();
        	aebd.setElectricityBoardId(aeb.getElectricityBoardId());
        	aebd.setElectricityBoardName(aeb.getElectricityBoardName());
        	aebd.setActiveStatus(aeb.getActiveStatus());
        	 aleb.add(aebd);
         
        }
        
        return aleb;
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
    public List<AllStateDto> getAllState() {
        
    	List<AllStateDto> aleb =new ArrayList<AllStateDto>();
    	
        try {
        	List<AllState>	listaeb=this.commonrepository.getAllState();
            for(AllState aeb: listaeb) {
            	AllStateDto aebd=new AllStateDto();
            	aebd.setStateId(aeb.getStateId());
            	aebd.setStateName(aeb.getStateName());
            	aebd.setActiveStatus(aeb.getActiveStatus());
            	 aleb.add(aebd);
             
            }
            return aleb;
         
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
    public List<UserRolesPlDto> getUserRolesPl() {
        
    	List<UserRolesPlDto> aleb =new ArrayList<UserRolesPlDto>();
    	
        try {
        	List<UserRolesPl>	listaeb=this.commonrepository.getUserRolesPl();
            for(UserRolesPl aeb: listaeb) {
            	UserRolesPlDto aebd=new UserRolesPlDto();
            	aebd.setUserRoleId(aeb.getUserRoleId());
            	aebd.setUserRoleName(aeb.getUserRoleName());
            	aebd.setActiveStatus(aeb.getActiveStatus());
            	 aleb.add(aebd);
             
            }
            return aleb;
         
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
    public List<UserTypePlDto> getUserTypePl() {
        
    	List<UserTypePlDto> aleb =new ArrayList<UserTypePlDto>();
    	
        try {
        	List<UserTypePl>	listaeb=this.commonrepository.getUserTypePl();
            for( UserTypePl aeb: listaeb) {
            	UserTypePlDto aebd=new UserTypePlDto();
            	aebd.setUserTypeId(aeb.getUserTypeId());
            	aebd.setUserTypeName(aeb.getUserTypeName());
            	aebd.setActiveStatus(aeb.getActiveStatus());
            	 aleb.add(aebd);
             
            }
            return aleb;
         
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
    public List<StateBoardMappingDto> getStateBoardMapping(int stateId) {
	
    	List<StateBoardMappingDto> aleb =new ArrayList<StateBoardMappingDto>();
    	
        try {
        	List<StateBoardMapping>	listaeb=this.commonrepository.getStateBoardMapping(stateId);
            for( StateBoardMapping aeb: listaeb) {
            	StateBoardMappingDto aebd=new StateBoardMappingDto();
            	aebd.setStateBoardMappingId(aeb.getStateBoardMappingId());
            	aebd.setStateName(aeb.getAllState().getStateName());
            	aebd.setActiveStatus(aeb.getActiveStatus());
            	aebd.setBoardName(aeb.getAllElectricityBoard().getElectricityBoardName());
            	aebd.setStateId(aeb.getAllState().getStateId());
            	aebd.setBoardId(aeb.getAllElectricityBoard().getElectricityBoardId());
            	 aleb.add(aebd);
            }
            return aleb;
         
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
    
    public List<StateLocalityMappingDto> getStateLocalitymapping(int stateId) {
    	
    	List<StateLocalityMappingDto> aleb =new ArrayList<StateLocalityMappingDto>();
    	
        try {
        	List<StateLocalityMapping>	listaeb=this.commonrepository.getStateLocality(stateId);
            for( StateLocalityMapping aeb: listaeb) {
            	StateLocalityMappingDto aebd=new StateLocalityMappingDto();
            	aebd.setStateLocalityMappingId(aeb.getStateLocalityMappingId());
            	aebd.setStateName(aeb.getAllState().getStateName());
            	aebd.setActiveStatus(aeb.getActiveStatus());
            	aebd.setLocalityName(aeb.getLocality().getLocalityName());
            	aebd.setStateId(aeb.getAllState().getStateId());
            	aebd.setLocalityId(aeb.getLocality().getLocalityId());
            	 aleb.add(aebd);
            }
            return aleb;
         
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
 public List<DevicePlDto> getDevicePl() {
        
    	List<DevicePlDto> aleb =new ArrayList<DevicePlDto>();
    	
        try {
        	List<DevicePl>	listaeb=this.commonrepository.getDevicesPl();
            for( DevicePl aeb: listaeb) {
            	DevicePlDto aebd=new DevicePlDto();
            	aebd.setDeviceTypeId(aeb.getDeviceTypeId());
            	aebd.setDeviceTypeName(aeb.getDeviceTypeName());
            	 aleb.add(aebd);
             
            }
            return aleb;
         
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
            return aleb;
           
        }
    }
    
       
}