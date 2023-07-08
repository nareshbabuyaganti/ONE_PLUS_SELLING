package com.sjp.life.insurance.initial.service;

import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MmailService {
	
//	@Autowired
//	JavaMailSender mailSender;
//	public void sendingMail(String eMail,String body,String subject) {
//		
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setFrom("nareshbabuyaganti232@gmail.com");
//		message.setTo(eMail);
//		message.setText(body);
//		message.setSubject(subject);
//		mailSender.send(message);
//		System.out.println("experiment done");
//	}

}
