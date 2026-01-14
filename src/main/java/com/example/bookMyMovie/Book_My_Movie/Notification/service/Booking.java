package com.example.bookMyMovie.Book_My_Movie.Notification.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Booking(
        @JsonProperty("bookingId") String bookingId,
        @JsonProperty("userId") Long userId,
        @JsonProperty("showId") Long showId,
        @JsonProperty("status") String status,
        @JsonProperty("paymentId") String paymentId,
        @JsonProperty("totalAmount") double totalAmount,
        @JsonProperty("createdAt") @JsonFormat(shape = JsonFormat.Shape.STRING) OffsetDateTime createdAt,
        @JsonProperty("updatedAt") @JsonFormat(shape = JsonFormat.Shape.STRING) OffsetDateTime updatedAt
) {}

