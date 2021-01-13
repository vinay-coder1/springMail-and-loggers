package com.xworkz.springmail.service;

public interface SpringMailService {

	public boolean sendMail(String reciver, String subject,String body);
}
