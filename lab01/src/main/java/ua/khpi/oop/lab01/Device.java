package ua.khpi.oop.lab01;

import java.util.Objects;

public class Device {
    private String deviceId;
    private String type;
    private String brand;
    private String model;

    public Device() {
    }

    public Device(String deviceId, String type, String brand, String model) {
        this.deviceId = deviceId;
        this.type = type;
        this.brand = brand;
        this.model = model;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void printDeviceInfo() {
        System.out.println("Пристрій: " + brand + " " + model + " (" + type + ")");
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Device)) return false;
        Device other = (Device) obj;
        return Objects.equals(deviceId, other.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId);
    }
}