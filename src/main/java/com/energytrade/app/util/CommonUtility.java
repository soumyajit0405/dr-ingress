package com.energytrade.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.regex.Pattern;

import javax.persistence.Query;

public class CommonUtility {

	public static String generateOTPCode()
	{
		Random random = new Random();
		String id = String.format("%04d", random.nextInt(10000));
		return id;
	}
	
	public String generateDeliveryCode()
	{
		
		Random random = new Random();
		String id = String.format("%04d", random.nextInt(10000));
		return id;
	}
	
	

public String generateAuthCode(){


long count = (long)768;

Random rand=new Random();
//String paddedId=String.format("%07d%", rand.nextInt(10000000));
String authCode="SFT-"+String.format("%07d", (int)count)+"-"+String.format("%04d", rand.nextInt(10000));
return authCode;
}


	public  void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        System.out.println("is "+is.toString());
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	        	System.out.println(" file "+length);
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}

	
	public  int checkDates(Hashtable<String,String> inputDetails) throws IOException {
	   
	    try {
	      if(inputDetails.get("startDate")== null || inputDetails.get("endDate")== null)
	      {
	    	  return -3;
	      }
	      else
	      {
	    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	          Date startDate = null,endDate = null;
			try {
				startDate = sdf.parse(inputDetails.get("startDate"));
				
				  endDate = sdf.parse(inputDetails.get("endDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         

	       
	          if (startDate.compareTo(endDate) > 0) {
	            return -2;
	      }
	          return 1;
	    	
	    }
	    }
	    finally
	    {
	    	
	    }
	      
	    }
	

	public  int checkExtension(String fileName) throws IOException {
	   
	    try {
	    	System.out.println("File Name "+fileName);
	     
	    	String [] extension=fileName.split("\\.");
	    	System.out.println("File Name "+extension[0]);
	    	System.out.println("extension"+extension[1]);
	    	if(! extension[1].equalsIgnoreCase("jpeg") &&  !extension[1].equalsIgnoreCase("jpg") && !extension[1].equalsIgnoreCase("png"))
	    		
	    	{
	    	return 2;	
	    	}
	    	else
	    	{
	    		return 1;
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	   return -1; 	
	    }
	      
	    }
	 public  boolean isEmailValid(String email)
	    {
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                            "[a-zA-Z0-9_+&*-]+)*@" +
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                            "A-Z]{2,7}$";
	                             
	        Pattern pat = Pattern.compile(emailRegex);
	        if (email == null)
	            return false;
	        return pat.matcher(email).matches();
	    }
	
	 public  boolean isPasswordValid(String password)
	    {
	        
	        if (password.length() < 6)
	            return false;
	        
	        return true;
	    }
	public static void main(String args[])
	{
		CommonUtility cm=new CommonUtility();
		System.out.println(cm.generateAuthCode());
	}

	public HashMap<String,String> parseInput(HashMap<String,String> inputDetails) {
		HashMap<String,String> response = new HashMap<String, String>();
		try {
			
			if (inputDetails.get("\"Status\"").toString().equalsIgnoreCase("\"USER_CREATED\"")) {
		    	response.put("status", "created");
			}
		    	else {
		    		response.put("status", "error");
		    	}
		    response.put("publicKey",inputDetails.get("\"publickey\""));
		    response.put("privatekey",inputDetails.get("\"privatekey\""));
		    response.put("userId",inputDetails.get("\"User_ID\""));
		} catch(Exception e) {
			
		}
		return response;
	}

}
