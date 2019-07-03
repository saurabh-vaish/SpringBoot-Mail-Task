package com.app.util;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.MailTask;


/**
 * 
 *  For web application we are using MultipartFile (I) , its implementation is CommonsMultipartFile (C)  
 *  here spring boot automatically configure it and do its implementation on runtime .
 * 
 * 
 * 
 * **/



@Component
public class EmailUtil {

	// for mail properties 
	@Autowired
	private JavaMailSender mailSender;
	
	
	// method to send mail
	public boolean send(MailTask mail,MultipartFile file )
	{
		boolean flag=false;
		
		try {
			
			System.out.println(mail); 
			
			// create mime message
			MimeMessage message =mailSender.createMimeMessage();
			
			// helper class for generate message
			MimeMessageHelper helper = new MimeMessageHelper(message, file!=null?true:false);
			
			// setting data 
			helper.setTo(InternetAddress.parse(mail.getTo()));
			helper.setFrom("srvjava93@gmail.com");
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getText());

			if(mail.getCc()!=null) {
				helper.setCc(InternetAddress.parse(mail.getCc()));
			}
			
			if(mail.getBcc()!=null) {
				helper.setBcc(InternetAddress.parse(mail.getBcc()));
			}
			
			if(file!=null)
			{
				helper.addAttachment(file.getOriginalFilename(), file);
			}
			
			//send mail
			mailSender.send(message);
			
			flag=true;
		}
		catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	
}
