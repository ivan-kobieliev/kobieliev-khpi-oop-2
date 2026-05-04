package ua.khpi.oop.lab07.contracts;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab07.model.HotelBooking;
import ua.khpi.oop.lab07.model.TrainTicket;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ReservableTest {

    @Test
    void shouldReserveDifferentObjects() {
        Reservable[] reservables = {
                new HotelBooking("Test Hotel", 2),
                new TrainTicket("Kyiv - Lviv")
        };

        for (Reservable item : reservables) {
            String result = item.reserve("Test User");
            assertFalse(result.isBlank());
        }
    }
}