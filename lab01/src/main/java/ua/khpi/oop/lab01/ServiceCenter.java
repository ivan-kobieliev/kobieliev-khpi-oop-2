package ua.khpi.oop.lab01;

import java.util.Objects;

public class ServiceCenter {
    private String centerId;
    private String name;
    private String address;
    private String phone;

    public ServiceCenter() {
    }

    public ServiceCenter(String centerId, String name, String address, String phone) {
        this.centerId = centerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void printCenterInfo() {
        System.out.println("Сервісний центр: " + name + ", адреса: " + address);
    }

    @Override
    public String toString() {
        return "ServiceCenter{" +
                "centerId='" + centerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServiceCenter)) return false;
        ServiceCenter other = (ServiceCenter) obj;
        return Objects.equals(centerId, other.centerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerId);
    }
}