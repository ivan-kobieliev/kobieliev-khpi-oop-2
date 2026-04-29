package ua.khpi.oop.lab06.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutomationScenarioPolymorphismTest {

    @Test
    void shouldDispatchToConcreteImplementations() {
        AutomationScenario[] scenarios = {
                new LightingScenario("Освітлення", 75, true),
                new ClimateScenario("Клімат", 22.5, true),
                new SecurityScenario("Безпека", true, 4)
        };

        for (AutomationScenario scenario : scenarios) {
            scenario.activate();
        }

        String[] actual = new String[scenarios.length];

        for (int i = 0; i < scenarios.length; i++) {
            actual[i] = scenarios[i].execute();
        }

        assertEquals("Освітлення: яскравість = 75%, авто режим = true", actual[0]);
        assertEquals("Клімат: температура = 22.5°C, опалення = true", actual[1]);
        assertEquals("Безпека: сигналізація = true, активні камери = 4", actual[2]);
    }
}