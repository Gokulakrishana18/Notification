package com.example.bookMyMovie.Book_My_Movie.Notification.service.Consumer;


import com.example.bookMyMovie.Book_My_Movie.Notification.service.Notification.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingEventsConsumer {
@Autowired
private EmailService  emailService ;
    @KafkaListener(topics = "booking-events", groupId = "booking-group")
    public void consume(String message) {
//   KafkaMessageListenerContainer    : booking-group: partitions assigned: [booking-events-0]
//✅ Received message: Booking(id=41, userId=7, movieId=1, paymentId=1761497302, seatIds=[56], screenId=1, bookingTime=2025-10-26T22:18:49.320906100, price=200.0, paymentStatus=SUCCESS, isConfirmed=true)
//        Enter into the mail sender method :
//        one step behind the mail sending method call
//        Mail sent successfully to gokul18f@gmail.com

        System.out.println("✅ Received message: " + message);

        emailService.sendBookingConfirmation("gokul18f@gmail.com",message);
    }
}
