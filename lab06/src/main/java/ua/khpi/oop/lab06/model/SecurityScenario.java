package ua.khpi.oop.lab06.model;

public class SecurityScenario extends AutomationScenario {

    private boolean alarmEnabled;
    private int camerasActive;

    public SecurityScenario(String name, boolean alarmEnabled, int camerasActive) {
        super(name);

        if (camerasActive < 0) {
            throw new IllegalArgumentException("Кількість камер не може бути від’ємною");
        }

        this.alarmEnabled = alarmEnabled;
        this.camerasActive = camerasActive;
    }

    public boolean isAlarmEnabled() {
        return alarmEnabled;
    }

    public int getCamerasActive() {
        return camerasActive;
    }

    @Override
    public String execute() {
        if (!isActive()) {
            return "Сценарій безпеки вимкнений";
        }

        return "Безпека: сигналізація = " + alarmEnabled +
                ", активні камери = " + camerasActive;
    }

    @Override
    public String toString() {
        return "SecurityScenario[" +
                "name=" + getName() +
                ", active=" + isActive() +
                ", alarm=" + alarmEnabled +
                ", cameras=" + camerasActive +
                ']';
    }
}