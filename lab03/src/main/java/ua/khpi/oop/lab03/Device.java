package ua.khpi.oop.lab03;

import java.util.Objects;

public class Device {
    private final String serialNumber;
    private final String model;

    public Device(String serialNumber, String model) {
        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Серійний номер не може бути порожнім");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Модель пристрою не може бути порожньою");
        }
        this.serialNumber = serialNumber;
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Device)) return false;
        Device other = (Device) obj;
        return Objects.equals(serialNumber, other.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

    @Override
    public String toString() {
        return "Пристрій[серійнийНомер=%s, модель=%s]".formatted(serialNumber, model);
    }
}