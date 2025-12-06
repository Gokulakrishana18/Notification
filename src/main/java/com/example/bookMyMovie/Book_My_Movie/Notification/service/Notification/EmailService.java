package com.example.bookMyMovie.Book_My_Movie.Notification.service.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

   @Autowired
    public  JavaMailSender mailSender;


    public void sendBookingConfirmation(String toEmail, String bookingId) {
        System.out.println("Enter into the mail sender method :");
        try {

                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("gokul18f@gmail.com");
                message.setTo("gokulrajender@gmail.com");
                message.setSubject("Booking Confirmation");
                message.setText("✅ Your ticket has been booked successfully. Booking ID: 1234456790 : URl :https://www.youtube.com/watch?v=ugIUObNHZdo&t=155s");
                System.out.println("one step behind the mail sending method call");
                mailSender.send(message);

            System.out.println("Mail sent successfully to " + toEmail);
        } catch (MailException ex) {
            System.err.println("Failed to send email: " + ex.getMessage());
        }
    }
}
