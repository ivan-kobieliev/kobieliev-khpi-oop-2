package ua.khpi.oop.lab06.model;

public abstract class AutomationScenario {

    private final String name;
    private boolean active;

    public AutomationScenario(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Назва сценарію не може бути порожньою");
        }
        this.name = name;
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public abstract String execute();

    @Override
    public String toString() {
        return "Сценарій[name=%s, активний=%s]".formatted(name, active);
    }
}