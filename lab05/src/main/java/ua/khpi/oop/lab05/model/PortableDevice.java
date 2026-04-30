package ua.khpi.oop.lab05.model;

public class PortableDevice extends Device {
    private double weight;
    private int batteryCapacity;

    public PortableDevice(String manufacturer, String model, double weight, int batteryCapacity) {
        super(manufacturer, model);

        if (weight <= 0) {
            throw new IllegalArgumentException("Вага має бути більше 0");
        }
        if (batteryCapacity <= 0) {
            throw new IllegalArgumentException("Ємність батареї має бути більше 0");
        }

        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return "PortableDevice[%s, вага=%.2f кг, батарея=%d мА·год]"
                .formatted(super.toString(), weight, batteryCapacity);
    }
}