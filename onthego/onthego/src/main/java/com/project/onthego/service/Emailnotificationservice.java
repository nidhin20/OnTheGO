package com.project.onthego.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.project.onthego.model.User;
@Component
public class Emailnotificationservice {

public void notifyuserMail(User user,String messagetosend) throws Exception {
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("onthegopvtltd@gmail.com","onthego123@");
			}
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("onthegopvtltd@gmail.com",false));
		
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		message.setSubject("Severe error encoutered in the application");
		message.setContent(messagetosend, "text/html");
		message.setSentDate(new Date());
		Transport.send(message);
	}
}
