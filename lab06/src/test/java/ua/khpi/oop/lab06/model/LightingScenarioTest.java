package ua.khpi.oop.lab06.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LightingScenarioTest {

    @Test
    void shouldIncludeBaseStateInToString() {
        LightingScenario scenario = new LightingScenario("Освітлення", 75, true);

        assertTrue(scenario.toString().contains("Освітлення"));
        assertTrue(scenario.toString().contains("active=false"));
    }

    @Test
    void shouldExecuteLightingScenarioWhenActive() {
        LightingScenario scenario = new LightingScenario("Освітлення", 75, true);

        scenario.activate();

        assertEquals("Освітлення: яскравість = 75%, авто режим = true", scenario.execute());
    }

    @Test
    void shouldReturnDisabledMessageWhenInactive() {
        LightingScenario scenario = new LightingScenario("Освітлення", 75, true);

        assertEquals("Сценарій освітлення вимкнений", scenario.execute());
    }
}