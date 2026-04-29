package ua.khpi.oop.lab06.model;

public class LightingScenario extends AutomationScenario {

    private int brightness;
    private boolean autoMode;

    public LightingScenario(String name, int brightness, boolean autoMode) {
        super(name);

        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Яскравість має бути від 0 до 100");
        }

        this.brightness = brightness;
        this.autoMode = autoMode;
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean isAutoMode() {
        return autoMode;
    }

    @Override
    public String execute() {
        if (!isActive()) {
            return "Сценарій освітлення вимкнений";
        }

        return "Освітлення: яскравість = " + brightness +
                "%, авто режим = " + autoMode;
    }

    @Override
    public String toString() {
        return "LightingScenario[" +
                "name=" + getName() +
                ", active=" + isActive() +
                ", brightness=" + brightness +
                ", autoMode=" + autoMode +
                ']';
    }
}