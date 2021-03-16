package com.energytrade.app.util;

public class TempPasswordUtil {

	public  String getPassword(){		
		char[] chr2 = {'f','g','h','i','j','n','o','p',
				'k','l','m','q','r','s','t','u',
				'v','w','x','y','z','A','B','C','D','E','F'
				,'G','H','I','J','K','L','4','5','6','7',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','8','9','a','b','c','d','e'};
	
	String pwd="";	
	for(int i =0;i<8;i++){
		int index=((int) (Math.random()*1000))%62;
		char a = chr2[index];
		System.out.println(a);
		pwd+=a;				
	}		
	System.out.println(pwd);
	return pwd;
	}
	
}
