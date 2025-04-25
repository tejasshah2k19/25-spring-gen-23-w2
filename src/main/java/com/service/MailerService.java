package com.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

//3 -> controller repository service 
@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSender;

//	public void sendWelcomeMail(String toEmail, String firstName) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom("your_email@gmail.com");
//		message.setTo(toEmail);
//		message.setSubject("Welcome to alibaba.com");
//		message.setText("Hey "+firstName+" Welcome a board , We are happy to server you...");
//		mailSender.send(message);
//
//	}

	public void sendWelcomeMail(String toEmail, String firstName) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(toEmail);
			helper.setSubject("Welcome to alibaba.com");
			
			String content =   Files.readString(Paths.get("src/main/resources/templates/welcome-mail-template.html"),StandardCharsets.UTF_8);
			content = content.replace("[[FIRSTNAME]]", firstName);
			 
			helper.setText(content, true);
		    // Embed logo
		    ClassPathResource logo = new ClassPathResource("static/logo.png");
		    helper.addInline("logoImage", logo);

		    // Attach PDF
		    ClassPathResource pdf = new ClassPathResource("static/welcome.pdf");
		    helper.addAttachment("Welcome-Guide.pdf", pdf);
		    
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//html
		//file 
	}

}
