package com.alexyamaoka.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service	// same as @Component but for services. 
public class LCAppEmailServiceImpl implements LCAppEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String username, String userEmail, String result) {
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(userEmail);
		simpleMailMessage.setSubject("Love Calculator Application Result");
		simpleMailMessage.setText("Hi " + username + " The result predicted by the LCApp is " + result);
		
		javaMailSender.send(simpleMailMessage);
		
	}

}
