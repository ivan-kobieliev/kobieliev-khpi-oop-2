package ua.khpi.oop.lab06.model;

public class ClimateScenario extends AutomationScenario {

    private double temperature;
    private boolean heatingEnabled;

    public ClimateScenario(String name, double temperature, boolean heatingEnabled) {
        super(name);

        if (temperature < 10 || temperature > 35) {
            throw new IllegalArgumentException("Температура має бути в межах 10–35°C");
        }

        this.temperature = temperature;
        this.heatingEnabled = heatingEnabled;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isHeatingEnabled() {
        return heatingEnabled;
    }

    @Override
    public String execute() {
        if (!isActive()) {
            return "Кліматичний сценарій вимкнений";
        }

        return "Клімат: температура = " + temperature +
                "°C, опалення = " + heatingEnabled;
    }

    @Override
    public String toString() {
        return "ClimateScenario[" +
                "name=" + getName() +
                ", active=" + isActive() +
                ", temperature=" + temperature +
                ", heating=" + heatingEnabled +
                ']';
    }
}