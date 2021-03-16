package com.energytrade.app.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.energytrade.app.dto.AllElectricityBoardDto;
import com.energytrade.app.dto.AllStateDto;
import com.energytrade.app.dto.AllUserDto;
import com.energytrade.app.dto.StateBoardMappingDto;
import com.energytrade.app.dto.UserRolesPlDto;
import com.energytrade.app.dto.UserTypePlDto;
import com.energytrade.app.model.AllBlockchainTransaction;
import com.energytrade.app.model.AllElectricityBoard;
import com.energytrade.app.model.AllOtp;
import com.energytrade.app.model.AllState;
import com.energytrade.app.model.AllUser;
import com.energytrade.app.model.StateBoardMapping;
import com.energytrade.app.model.UserBlockchainKey;
import com.energytrade.app.model.UserRolesPl;
import com.energytrade.app.model.UserTypePl;
import com.energytrade.app.util.CommonUtility;
import com.energytrade.app.util.CustomMessages;



@Transactional
@Repository
public class BlockchainDao extends AbstractBaseDao
{
	@Autowired
    UserBlockchainKeyRepository userbcrepo;
	
	@Autowired
	AllBlockchainTransactionRepository allbcrepo;
	
    public void createBlockchainKey(AllUser alluser , String privateKey, String publicKey, String bcuserId) {
         
        try {
        	Timestamp ts = new Timestamp(System.currentTimeMillis());
       UserBlockchainKey ubc= new UserBlockchainKey();
       ubc.setAllUser(alluser);
       ubc.setPublicKey(publicKey);
       ubc.setPrivateKey(privateKey);
       ubc.setStartDate(ts);
       ubc.setBlockChainUserId(bcuserId);
       userbcrepo.saveAndFlush(ubc);
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
           
        }
    }
    
    public void updateAuthToken(String authToken, String bcuserId) {
        
        try {
        	
       userbcrepo.updateAuthToken(authToken, bcuserId);
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
           
        }
    }
    
    public void addBlockchainTransaction(String blockchainTxId,String txType) {
        
        try {
       AllBlockchainTransaction albctx= new AllBlockchainTransaction();
       albctx.setBlockChainTrxId(blockchainTxId);
       albctx.setTransactionType(txType);
       allbcrepo.saveAndFlush(albctx);
       
        }
        catch (Exception e) {
            System.out.println("Error in checkExistence" + e.getMessage());
            e.printStackTrace();
           
        }
    }
}