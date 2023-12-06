package com.javamail.impl;

import com.javamail.payload.EmailDto;
import com.javamail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public EmailDto sendSimpleMail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getTo());
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getBody());
        javaMailSender.send(message);

        EmailDto dto = new EmailDto();
        dto.setTo(emailDto.getTo());
        dto.setSubject(emailDto.getSubject());
        dto.setBody(emailDto.getBody());
        return dto;
    }
}
