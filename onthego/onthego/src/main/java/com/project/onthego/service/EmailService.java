package com.project.onthego.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailService implements Observer {

	String email;
	public EmailService(String email) {
		// TODO Auto-generated constructor stub
		this.email=email;
	}

	@Override
	public void Update(Object o) throws Exception
	{
		// TODO Auto-generated method stub
		if(o instanceof NotificationService)
		{
			NotificationService notificationservice=(NotificationService) o;
			triggerMail(notificationservice.getlist());
			
		}
		
	}

	private void triggerMail(List<CheckSubscription> list) throws Exception{
		// TODO Auto-generated method stub
		Iterator<CheckSubscription> itr=list.iterator();
		while(itr.hasNext())
		{
		String offermessage=itr.next().getMessage();
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("onthegopvtltd@gmail.com","onthego123@");
			}
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("onthegopvtltd@gmail.com",false));
		
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		message.setSubject("New Subscription Plans");
		message.setContent(offermessage, "text/html");
		message.setSentDate(new Date());
		Transport.send(message);
		System.out.println("Mail sent");
		}	
	}

}
