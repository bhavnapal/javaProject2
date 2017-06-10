package com.niit.onlinecollaboration.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com.niit.onlinecollaboration.service")
public class EmailConfig {
	   

	    @Bean("mailsender")
	    public JavaMailSender getMailSender() {
	        JavaMailSenderImpl mailsender = new JavaMailSenderImpl();

	        mailsender.setHost("smtp.gmail.com");
	        mailsender.setPort(587);
	        mailsender.setUsername("bhavnapal1995@gmail.com");
	        mailsender.setPassword("mlucky@123");
	        mailsender.setJavaMailProperties(getMailProperties());

	        return mailsender;
	    }
	    
	    private Properties getMailProperties() {
	    	Properties mailProperties = new Properties();		
	    	mailProperties.put("mail.transport.protocol", "smtp");
	    	mailProperties.put("mail.smtp.auth", "true");
	    	mailProperties.put("mail.smtp.starttls.enable", "true");
	    	mailProperties.put("mail.debug", "true");
	    	return mailProperties;
	    }		
}


