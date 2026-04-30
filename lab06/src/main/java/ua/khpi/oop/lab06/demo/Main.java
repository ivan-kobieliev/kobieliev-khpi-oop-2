package ua.khpi.oop.lab06.demo;

import ua.khpi.oop.lab06.model.*;

public class Main {
    public static void main(String[] args) {

        AutomationScenario[] scenarios = {
                new LightingScenario("Освітлення", 75, true),
                new ClimateScenario("Клімат", 22.5, true),
                new SecurityScenario("Безпека", true, 4)
        };

        System.out.println("\nАктивація та виконання сценаріїв:\n");

        for (AutomationScenario scenario : scenarios) {
            scenario.activate();
            System.out.println(scenario.execute());
        }

        System.out.println("\nДеактивація сценаріїв:\n");

        for (AutomationScenario scenario : scenarios) {
            scenario.deactivate();
            System.out.println(scenario.execute());
        }
    }
}