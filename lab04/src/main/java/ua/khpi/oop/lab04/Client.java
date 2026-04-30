package ua.khpi.oop.lab04;

import java.util.Objects;

public class Client {
    private final String clientId;
    private final String fullName;

    public Client(String clientId, String fullName) {
        if (clientId == null || clientId.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор клієнта не може бути порожнім");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("ПІБ клієнта не може бути порожнім");
        }
        this.clientId = clientId;
        this.fullName = fullName;
    }

    public String getClientId() {
        return clientId;
    }

    public String getFullName() {
        return fullName;
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

    @Override
    public String toString() {
        return "Клієнт[id=%s, ПІБ=%s]".formatted(clientId, fullName);
    }
}