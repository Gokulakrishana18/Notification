package com.example.bookMyMovie.Book_My_Movie.Notification.service.Notification;

import com.example.bookMyMovie.Book_My_Movie.Notification.service.Booking;
import com.example.bookMyMovie.Book_My_Movie.Notification.service.ApiCall.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

   @Autowired
    public  JavaMailSender mailSender;

   @Autowired
   public UserService userService;


    public void sendBookingConfirmation(Booking booking) {
        log.info("Enter into the mail sender method :");
        try {
            if(booking!=null ) {
                String email=userService.getUserId(booking.userId());
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("gokul18f@gmail.com");
                message.setTo(email);
                message.setSubject("Booking Confirmation");
                message.setText("✅ Your ticket has been booked successfully. Booking ID:"+ booking.bookingId());
                System.out.println("one step behind the mail sending method call");
                mailSender.send(message);
                log.info("Mail sent successfully to " +email );
            }
        } catch (MailException ex) {
            System.err.println("Failed to send email: " + ex.getMessage());
        }
    }
}
