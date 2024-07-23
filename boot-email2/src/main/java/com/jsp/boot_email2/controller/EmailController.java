package com.jsp.boot_email2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email2.dto.Email;
import com.jsp.boot_email2.dto.EmailAttach;
import com.jsp.boot_email2.dto.EmailList;
import com.jsp.boot_email2.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	EmailService service;
	@GetMapping("/message")
	public String msg() {
		return "hii";
	}
	
	@PostMapping("/send")
	public String sendMessage(@RequestBody Email email) {
//		System.out.println(email);
    try {
		service.sendMessage(email);
		return "message send Successfuly";	

	} catch (Exception e) {
		e.printStackTrace();
         return "internal issue try again";
	}
	}
	
	@PostMapping("/sendAll")
	public String sendMessage(@RequestBody EmailList email) {
//		System.out.println(email);
    try {
		service.sendMessageToRecep(email);
		return "message send Successfuly";	

	} catch (Exception e) {
         return "internal issue try again";
	}
	}
	@PostMapping("/sendHtmlEmail")
	public String sendHtmlEmail( ) {
		try {
			service.sendHtmlEmail();
			return "send sucessfully";
		} catch (Exception e) {
			return "trchnical error";
		}
	}
	
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailAttach details) {
		try {
			service.sendEmailWithAttachment(details);
			return "Mail with Attachment sent successfuly";
		} catch (Exception e) {
			return "Technical Problem";
		}
}
}
