package com.xworkz.springmail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class SpringMailServiceImpl implements SpringMailService {
	
	static Logger logger = Logger.getLogger(SpringMailServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	public SpringMailServiceImpl() {
		logger.debug("object is created "+this.getClass().getSimpleName());
	}

	@Override
	public boolean sendMail(String reciver, String subject, String body) {
         
		logger.info("invoked sendMail");
		//System.out.println("invoked sendMail");
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(reciver);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		try {
			mailSender.send(mailMessage);
			logger.info("mail sent");
			return true;
		} catch (MailException e) {
			logger.error(e.getMessage(), e);
		}

		return false;
	}

}
