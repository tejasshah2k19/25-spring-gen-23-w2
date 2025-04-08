package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//3 -> controller repository service 
@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSender;

	public void sendWelcomeMail(String toEmail, String firstName) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("your_email@gmail.com");
		message.setTo(toEmail);
		message.setSubject("Welcome to alibaba.com");
		message.setText("Hey "+firstName+" Welcome a board , We are happy to server you...");
		mailSender.send(message);

	}
}
