package com.biz.sec.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MailSendService {

	
	private final JavaMailSender javaMailSender;

	public MailSendService(
		@Qualifier("gmailMailHander") 
		JavaMailSender javaMailSender) {
		
		super();
		this.javaMailSender = javaMailSender;
	
	}

	public void sendMail() {
		
		String from_email = "hhjkjm123@naver.com";
		String to_email = "hhjkjm123@nate.com";
		String subject = "메일보내기 테스트";
		String content = "반갑습니다";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mHelper ;
		mHelper = new MimeMessageHelper(message,"UTF-8");
		
		try {

			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			
			// true : 메일본문에 html 효과주기
			mHelper.setText(content,true); 
			javaMailSender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
