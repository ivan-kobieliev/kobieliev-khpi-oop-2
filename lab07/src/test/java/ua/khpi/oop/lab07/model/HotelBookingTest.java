package ua.khpi.oop.lab07.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HotelBookingTest {

    @Test
    void shouldReserveAndPay() {
        HotelBooking booking = new HotelBooking("Test Hotel", 1);

        String reserveResult = booking.reserve("User");
        String payResult = booking.pay(1000);

        assertTrue(reserveResult.contains("Hotel booked"));
        assertTrue(payResult.contains("Payment"));
    }
}