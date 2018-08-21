package com.jda.utility;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class ApplicationMailer {
public static void sendMail(String link)
{
	JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
	javaMailSenderImpl.setHost("smtp.gmail.com");
	javaMailSenderImpl.setPort(587);
	javaMailSenderImpl.setUsername("try.java01@gmail.com");
	javaMailSenderImpl.setPassword("qwertyuiop!@#$%");
	Properties javaMailProperties = javaMailSenderImpl.getJavaMailProperties();
	javaMailProperties.put("mail.transport.protocol", "smtp");
	javaMailProperties.put("mail.smtp.auth", "true");
	javaMailProperties.put("mail.smtp.starttls.enable", "true");
	javaMailProperties.put("mail.debug", "true"); 
	System.out.println(link);
	SimpleMailMessage message  =  new SimpleMailMessage();
	message.setTo("neha19oct97@gmail.com");
	message.setSubject("Forgot Password");

//message.setText(" Hi , You seems to have forgotten your password");
	message.setText(link);
	javaMailSenderImpl.send(message);
}
}
