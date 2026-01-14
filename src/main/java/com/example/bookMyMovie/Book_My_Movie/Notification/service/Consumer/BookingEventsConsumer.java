package com.example.bookMyMovie.Book_My_Movie.Notification.service.Consumer;


import com.example.bookMyMovie.Book_My_Movie.Notification.service.Booking;
import com.example.bookMyMovie.Book_My_Movie.Notification.service.Notification.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Slf4j
@Service
public class BookingEventsConsumer {
    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "booking-events")
    public void consume(String message) {
        log.info("✅ Received message: {}", message);

        try {
            Booking booking = parseBookingString(message);
            log.info("Booking info: {}", booking);
            emailService.sendBookingConfirmation(booking);
        } catch (Exception e) {
            log.error("Failed to parse booking: {}", message, e);
            throw e;
        }
    }

    private Booking parseBookingString(String message) {
        // Extract fields using regex or string operations
        String bookingId = extractField(message, "bookingId=", ",");
        Long userId = Long.parseLong(extractField(message, "userId=", ","));
        Long showId = Long.parseLong(extractField(message, "showId=", ","));
        String status = extractField(message, "status=", ",");
        String paymentId = extractField(message, "paymentId=", ",");
        double totalAmount = Double.parseDouble(extractField(message, "totalAmount=", ","));
        //OffsetDateTime createdAt = OffsetDateTime.parse(extractField(message, "createdAt=", ","));
        //OffsetDateTime updatedAt = OffsetDateTime.parse(extractField(message, "updatedAt=", ")"));

        return new Booking(bookingId, userId, showId, status, paymentId, totalAmount,null , null);
    }

    private String extractField(String message, String key, String delimiter) {
        int start = message.indexOf(key) + key.length();
        int end = message.indexOf(delimiter, start);
        return message.substring(start, end);
    }
}

