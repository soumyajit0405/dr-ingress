package com.energytrade.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

import org.json.JSONObject; 

 public class MailUtility  
{  		
		//Sending Email
		public String sendEmail(String useremail,String genPassword){
			  String status="";
			 // String host="smtp.gmail.com";  
			  String host="mail.brings.co.in";  
			//  final String user="brings.gvn@gmail.com";//change accordingly
			 // final String user="myteamdiscussion@gmail.com";//change accordingly  
			  final String user="support@brings.co.in";
			  
			 //final String password="papun12345";//change accordingly  
			  final String password="Papun@12345";
			  //final String password="gvn123456";
			  System.out.println("email entered  "+useremail);  
			  String to=useremail;//change accordingly  
			  //SmtpClient 
			  //Get the session object  
			   Properties props = new Properties(); 
			   props.put("mail.transport.protocol","smtp");
			   props.put("mail.smtp.host",host);  
			   props.put("mail.smtp.port", "587"); //TLS 465
			   props.put("mail.smtp.auth", "true"); 
			   props.put("mail.smtp.starttls.enable", "true");
			   props.put("mail.debug", "true"); 
			   
			   Session session = Session.getDefaultInstance(props,  
			    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(user,password);  
			      }  
			    });  
			   
			   //Compose the message  
			    try {  
			     MimeMessage message = new MimeMessage(session);  
			     message.setFrom(new InternetAddress(user));  
			     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			     message.setSubject("New Password For Brings");  
			     message.setText("New password generated successfully  : " + genPassword);  
			       
			    //send the message  
			     Transport.send(message);  
			     status ="  message sent successfully...";
			     System.out.println("message sent successfully...");  
			    }catch (MessagingException e) {e.printStackTrace();
			    status=e.toString();
			    }				
			    return status; 
		}
		
		/*public String validatePassword(String Email,String Password) throws SQLException{
			String status="";
			DbPojo dbPojo=new DbPojo();
			ResultSet rs= null;
			Connection con=null;			
			try{
			Class.forName(dbPojo.getDriverName());		
			con=DriverManager.getConnection(dbPojo.getUrl(),dbPojo.getUsername(),dbPojo.getPassword());			
			//check for the validity of email 
			java.sql.PreparedStatement stmt=con.prepareStatement("SELECT COUNT(*) AS rowcount FROM geo_service.user_details WHERE EMAIL = ?");
			//String emailID = "sri1@gmail.com";
			stmt.setString(1, Email);
			rs = stmt.executeQuery();
			System.out.println(rs.next());
			int count = rs.getInt("rowcount");
			System.out.println("count in user details "+count);
			if(count==1){
				stmt=con.prepareStatement("SELECT COUNT(*) AS rowcount FROM geo_service.passwordtable WHERE EmailId = ? AND Password=?");	
				stmt.setString(1, Email);
				stmt.setString(2, Password);
				rs=stmt.executeQuery();
				rs.next();
				int pwdcount = rs.getInt("rowcount");
				System.out.println("count in password table "+pwdcount);
					if(pwdcount==1){
						status = "password matched";
					} else {
						status = "wrong password";
					}
			} else {
				status="Enter valid email Id";
			}
			} catch(Exception e){
				status = "Exception--->"+e;
				con.close();
			}  
			finally{
				con.close();
			}  
			return status;
		}*/
		public int checkValidMail(String email)
		{
			try {
				String accessKey="1b956c64575eb5bde99a99b638dfd348";
				//String password="123456";
			//	String senderId="BRINGS";
			//	String mobileNo="9154748948";
				//String message="Your verification code for signup is ";
				
				//.message=message+otPassword;
				
		   String jsonResponse;
				   
				 
				  // con.setRequestProperty("Authorization", "Basic YzY0NTVkZDAtZmZiZi00ZjExLTg5ZjgtYmQ2OTBlNGU3ZTdi");
		   URL obj = new URL("https://apilayer.net/api/check?access_key="+accessKey+"&email="+email+"&smtp = 1&format=1");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(con.getInputStream())));
			
		String jsonText = readAll(br);
	      JSONObject json = new JSONObject(jsonText);  

				System.out.println(json.get("smtp_check"));
				
				if((boolean) json.get("smtp_check"))
				{
					return 1;
				}
				
			
				} catch(Throwable t) {
				   t.printStackTrace();
				}
			return 0;
		}


		public  String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }

		
		public static void main(String[] args)
		{
			MailUtility mu=new MailUtility();
			mu.sendEmail("soumyajit405@gmail.com", "Test");
		}

}  
 
 