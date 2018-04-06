package edu.ben.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ResetPassword {

	public static String reset(String userEmail) {

		final String username = "headphoneco17@gmail.com";
		final String password = "headphones";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String resetCode = getRandomCode();

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("headphoneco17@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
			message.setSubject("Password Reset");
			message.setText("Here is your headphones.com reset code\n" + resetCode);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return resetCode;
	}

	private static String getRandomCode() {

		String code = "";

		for (int i = 0; i < 6; i++) {
			code += (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
		}

		return code;
	}
}
