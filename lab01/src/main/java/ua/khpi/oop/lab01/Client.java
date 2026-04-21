package ua.khpi.oop.lab01;

import java.util.Objects;

public class Client {
    private String clientId;
    private String fullName;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(String clientId, String fullName, String phone, String email) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printClientInfo() {
        System.out.println("Клієнт: " + fullName + ", телефон: " + phone);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Client)) return false;
        Client other = (Client) obj;
        return Objects.equals(clientId, other.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}