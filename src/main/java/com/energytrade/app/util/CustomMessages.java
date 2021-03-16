package com.energytrade.app.util;

public class CustomMessages {
	
	public static String getCustomMessages(String code)
	{
		if(code.equalsIgnoreCase("OTF"))
		{
			return "OTP not matching.";
		}
		else if(code.equalsIgnoreCase("USE"))
		{
			return "User Already Existed.";
		}
		
		else if(code.equalsIgnoreCase("UNE"))
		{
			return "USN Not Existed.";
		}
		
		else if(code.equalsIgnoreCase("PNV"))
		{
			return "PIN Not Validated.";
		}
		else if(code.equalsIgnoreCase("PR"))
		{
			return "Profile Retrived.";
		}
		else if(code.equalsIgnoreCase("OTS"))
		{
			return "OTP Matched.";
		}
		else if(code.equalsIgnoreCase("DUS"))
		{
			return "USN Already Existed.";
		}
		else if(code.equalsIgnoreCase("SL"))
		{
			return "Successfully Logged In.";
		}
		else if(code.equalsIgnoreCase("WL"))
		{
			return "Wrong credentials.";
		}
		
		else if(code.equalsIgnoreCase("ISE"))
		{
			return "Internal Server Issue.";
		}
		
		else if(code.equalsIgnoreCase("PAE"))
		{
			return "Pin Alreafy exist.";
		}
		
		else if(code.equalsIgnoreCase("PU"))
		{
			return "Password Updated.";
		}
		else if(code.equalsIgnoreCase("NSU"))
		{
			return "No Such User.";
		}
		
		else if(code.equalsIgnoreCase("PRU"))
		{
			return "Profile Updated.";
		}
		
		else if(code.equalsIgnoreCase("OSS"))
		{
			return "OTP Sent Successfully.";
		}
		
		else if(code.equalsIgnoreCase("PNE"))
		{
			return "OTP Sent Successfully.";
		}
		
		else if(code.equalsIgnoreCase("HU"))
		{
			return "Hashtags updated.";
		}
		
		else if(code.equalsIgnoreCase("SU"))
		{
			return "Successfully uploaded.";
		}
			
		else if(code.equalsIgnoreCase("RS"))
		{
			return "Registered Successfully";
		}
		
		else if(code.equalsIgnoreCase("IVC"))
		{
			return "Invalid Credentials";
		}
		
		else if(code.equalsIgnoreCase("SL"))
		{
			return "Successfully Logged In.";
		}
		
		else if(code.equalsIgnoreCase("AS"))
		{
			return "Added Successfully.";
		}

		else if(code.equalsIgnoreCase("DS"))
		{
			return "Deleted Successfully.";
		}

		return "Success";
	}

}
