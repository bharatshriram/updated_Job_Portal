package com.hanbit.Job_Portal.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {

	public void sendMail(String toEmail, String password, String msg) {
		
		final String fromEmail = "alert@hanbitsolutions.com";
		final String mailerPassword = "hanbit@123";
		
		System.out.println("before decryption password = " + password);
//		String password = " ";

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, mailerPassword);// change accordingly
			}
		});
		
		// compose message
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail)); 
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			/*MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp1= new MimeBodyPart(); 
			String htmlText = "<b> This is formatted</b>"+
			"<font size =\"5\" face=\"arial\" >This paragraph is in Arial, size 5</font>";
			mbp1.setContent(htmlText,"text/html");
			mp.addBodyPart(mbp1);*/
			/*String htmlText = "<b> This is formatted</b>"+
					"<font size =\"5\" face=\"arial\" >This paragraph is in Arial, size 5</font>";
			
			message.getContentType(htmlText,"text/html");*/
			message.setSubject("Sender:");
			message.setText(msg + password);
			
		System.out.println("password is " + password);
			// send message
			Transport.send(message);
//			System.out.println("message sent successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
