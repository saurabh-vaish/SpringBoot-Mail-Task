package com.app.validator;


import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.MailTask;

@Component
public class MailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return MailTask.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MailTask mail = (MailTask) target;
		
		System.out.println(mail);
		
		String patternEmail ="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		
		
		if(StringUtils.isEmpty(mail.getTo()))
		{
			errors.rejectValue("to",null, "this field can't be empty");
		}
		else if(!Pattern.matches(patternEmail, mail.getTo()))
		{
			errors.rejectValue("to",null, "please enter valid email");
		}
		
		
		if(StringUtils.isEmpty(mail.getSubject()))
		{
			errors.rejectValue("subject",null, "subject can't be empty");
		}
		else if(!Pattern.matches("[a-zA-z0-9\\-\\,\\.\\&\\s]*", mail.getSubject()))
		{
			errors.rejectValue("subject",null, "invalid charecter");
		}
		
		
		if(!Pattern.matches("[A-za-z0-9\\@\\-\\_\\,\\.]*", mail.getCc()))
		{
			errors.rejectValue("cc",null, "use , between emails");
		}
		
		if(!Pattern.matches("[A-za-z0-9\\@\\-\\_\\,\\.]*", mail.getBcc()))
		{
			errors.rejectValue("bcc",null, "use , between emails");
		}
		
		
		if(StringUtils.isEmpty(mail.getText()))
		{
			errors.rejectValue("text",null, "text can't be empty");
		}
		
	}

	
	
}
