package ua.khpi.oop.lab05.model;

public class Tablet extends PortableDevice {
    private double screenSize;
    private boolean hasStylus;

    public Tablet(String manufacturer, String model,
                  double weight, int batteryCapacity,
                  double screenSize, boolean hasStylus) {

        super(manufacturer, model, weight, batteryCapacity);

        if (screenSize <= 0) {
            throw new IllegalArgumentException("Розмір екрану має бути більше 0");
        }

        this.screenSize = screenSize;
        this.hasStylus = hasStylus;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public boolean hasStylus() {
        return hasStylus;
    }

    @Override
    public String toString() {
        return "Tablet[%s, екран=%.1f\", стилус=%s]"
                .formatted(super.toString(), screenSize, hasStylus);
    }
}