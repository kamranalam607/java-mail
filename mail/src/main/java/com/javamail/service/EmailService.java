package com.javamail.service;

import com.javamail.payload.EmailDto;

public interface EmailService {
    EmailDto sendSimpleMail(EmailDto emailDto);
}
