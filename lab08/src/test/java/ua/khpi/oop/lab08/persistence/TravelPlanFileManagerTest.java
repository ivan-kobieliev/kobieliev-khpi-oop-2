package ua.khpi.oop.lab08.persistence;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab08.model.HotelBooking;
import ua.khpi.oop.lab08.service.TravelPlan;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelPlanFileManagerTest {

    @Test
    void shouldSaveAndLoadText() throws Exception {
        TravelPlan plan = new TravelPlan();

        plan.addHotelBooking(new HotelBooking(
                "HB1", "Test Hotel", "2026-01-01", 2, 1000
        ));

        TravelPlanFileManager manager = new TravelPlanFileManager();
        Path path = Path.of("build/test-plan.txt");

        manager.saveAsText(plan, path);
        TravelPlan loaded = manager.loadFromText(path);

        assertEquals(plan.size(), loaded.size());
    }

    @Test
    void shouldSerializeAndDeserialize() throws Exception {
        TravelPlan plan = new TravelPlan();

        plan.addHotelBooking(new HotelBooking(
                "HB1", "Test Hotel", "2026-01-01", 2, 1000
        ));

        TravelPlanFileManager manager = new TravelPlanFileManager();
        Path path = Path.of("build/test-plan.bin");

        manager.serialize(plan, path);
        TravelPlan loaded = manager.deserialize(path);

        assertEquals(plan.size(), loaded.size());
    }
}