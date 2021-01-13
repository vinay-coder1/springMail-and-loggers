package com.xworkz.springmail.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.springmail.service.SpringMailService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
@RequestMapping("/")
public class SpringMailController {
	
	static Logger logger = Logger.getLogger(SpringMailController.class);

	@Autowired
	private SpringMailService mailService;
	
	public SpringMailController() {
		System.out.println("object is created "+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value = "/mail.do" , method = RequestMethod.POST )
	public String onSendMail(@RequestParam("to") String reciver,@RequestParam("subject") String subject,@RequestParam("body") String body, ModelMap map) {
		logger.info("invoked onSendMail");
        
		if(logger.isInfoEnabled()) {
			logger.info("info is enabled");
			logger.error("its error level");
			logger.fatal("its fatal level");
			logger.warn("its warn level");
			
			logger.trace("trace level");
		}
		
		boolean validate = mailService.sendMail(reciver, subject, body);
		
		if (validate) {
			logger.info("mail validated succesfuly");
			map.addAttribute("success", "mail sent successfuly");
			return "index.jsp";
		} else {
			map.addAttribute("faild", "mail sent faild");
			return "index.jsp";
		}
		
		
	}
}
