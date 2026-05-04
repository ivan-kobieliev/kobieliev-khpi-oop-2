package ua.khpi.oop.lab08.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab08.model.HotelBooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelPlanTest {

    @Test
    void shouldAddItemsCorrectly() {
        TravelPlan plan = new TravelPlan();

        plan.addHotelBooking(new HotelBooking(
                "HB1", "Test Hotel", "2026-01-01", 2, 1000
        ));

        assertEquals(1, plan.size());
    }
}