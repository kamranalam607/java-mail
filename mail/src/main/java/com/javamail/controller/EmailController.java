package com.javamail.controller;

import com.javamail.payload.EmailDto;
import com.javamail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

//http://localhost:8080/api/emails
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<EmailDto> emailSend(@RequestBody EmailDto emailDto){
        EmailDto dto = emailService.sendSimpleMail(emailDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
