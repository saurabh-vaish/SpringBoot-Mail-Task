package com.app.controller;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.MailTask;
import com.app.util.EmailUtil;
import com.app.validator.MailValidator;

@Controller
public class MailController {

	
	@Autowired
	private EmailUtil util;

	@Autowired
	private MailValidator validator;
	
	@RequestMapping("/reg")
	public String showReg(Model map)
	{
		map.addAttribute("mailTask",new MailTask());
		return "register";
	}


	@RequestMapping(value = "save" ,method = RequestMethod.POST)
	public String sendMail(@ModelAttribute MailTask mail,
								@RequestParam("fileOb") MultipartFile fileOb,    // getting file ,implementation on runtime
								Errors errors,
								Model map
							) 
	{
		
		validator.validate(mail, errors);
		
		if(errors.hasErrors())
		{
			map.addAttribute("error","form contains errors");
			return "register";
		}
		else
		{
			boolean flag = false;

			if(!fileOb.isEmpty()) {
				flag = util.send(mail,fileOb);			
			}
			else
			{
				flag = util.send(mail,null);			
			}

			if(flag) {
				System.out.println("mail sent");
				map.addAttribute("mail","mail sent successfully");

				map.addAttribute("mailTask",new MailTask());
			}
			else {
				map.addAttribute("msg","check your email or internet connection");
			}

			return "register";
		}
	}


	
	@ExceptionHandler(value = AddressException.class)
	public String displayError(Model map)
	{
		map.addAttribute("error","Email must be seperated with , in cc or bcc . No other charecters allowed");
		return "register";
	}
	
}
