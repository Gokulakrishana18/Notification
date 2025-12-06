package com.example.bookMyMovie.Book_My_Movie.Notification.service.Notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // PROBLEM: These lines override your application.properties!
        mailSender.setHost("smtp.gmail.com"); // <-- Check for this!
        mailSender.setPort(587);          // <-- Check for this!
        return  mailSender; // dummy, won’t send real mails without host config
    }
}
