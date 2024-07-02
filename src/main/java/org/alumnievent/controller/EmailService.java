package org.alumnievent.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SMTP_USER = "adityapatil.pratap@gmail.com";
	private static final String SMTP_PASSWORD = "ynffcuhvdklefroi"; 

	public static void sendEmail(String eventName, String description, String email) {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", SMTP_PORT);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SMTP_USER, SMTP_PASSWORD);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SMTP_USER, "Aditya Patil"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(eventName);
			message.setContent(description, "text/html");

			Transport.send(message);
			System.out.println("Email sent successfully to " + email);
		} catch (MessagingException | UnsupportedEncodingException e) {
			System.err.println("Failed to send email to " + email);
			e.printStackTrace();
		}
	}
}
