package com.ge.pmms;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

@Component
public class EmailUtilityClass {
	
	//private static final Logger logger = Logger.getLogger(EmailUtilityClass.class);
	
	@Value("${email.host}")
	private String email_host;


	public void sendEmail(String to, String from, String subject, String body) throws Exception{
		
		 // load your HTML email template
		  String htmlEmailTemplate = body;

		  // create the email message
		  HtmlEmail email = new HtmlEmail();
		  email.setHostName(email_host);
		  email.addTo(to);
		  email.setFrom(from);
		  email.setSubject(subject);
		  
		  // set the html message
		  email.setHtmlMsg(htmlEmailTemplate);

		  // send the email
		  email.send();
	}
	
	public void sendEmailWithAttachment(String to, String from, String subject, String body, ArrayList<String> fileName) throws Exception{

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName(email_host);
		  email.addTo(to);
		  email.setFrom(from);
		  email.setSubject(subject);
		  email.setMsg(body);
		if(null != fileName && fileName.size() > 0) { 
		  for(String fileToAttach : fileName){
			  EmailAttachment attachment = new EmailAttachment();
	          attachment.setPath(fileToAttach);
	          attachment.setDisposition(EmailAttachment.ATTACHMENT);
	          email.attach(attachment);
		  }
		}
		  // send the email
		  email.send();
	}
	
}
