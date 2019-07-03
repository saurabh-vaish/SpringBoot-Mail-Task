package com.app.model;

import lombok.Data;

@Data
public class MailTask {

	private String to;
	private String subject;
	private String cc;
	private String bcc;
	private String text;


}
