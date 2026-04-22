package ua.khpi.oop.lab03;

import java.util.Objects;

public class RepairRequest {
    private final String requestId;
    private final Client client;
    private final Device device;
    private final String problemDescription;
    private String status;

    public RepairRequest(String requestId, Client client, Device device, String problemDescription) {
        if (requestId == null || requestId.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор заявки не може бути порожнім");
        }
        if (client == null) {
            throw new IllegalArgumentException("Клієнт не може бути порожнім");
        }
        if (device == null) {
            throw new IllegalArgumentException("Пристрій не може бути порожнім");
        }
        if (problemDescription == null || problemDescription.isBlank()) {
            throw new IllegalArgumentException("Опис проблеми не може бути порожнім");
        }

        this.requestId = requestId;
        this.client = client;
        this.device = device;
        this.problemDescription = problemDescription;
        this.status = "ЗАРЕЄСТРОВАНО";
    }

    public String getRequestId() {
        return requestId;
    }

    public Client getClient() {
        return client;
    }

    public Device getDevice() {
        return device;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public String getStatus() {
        return status;
    }

    public void markInProgress() {
        status = "ВИКОНУЄТЬСЯ";
    }

    public void markCompleted() {
        status = "ЗАВЕРШЕНО";
    }

    public boolean hasStatus(String status) {
        return this.status.equals(status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RepairRequest)) return false;
        RepairRequest other = (RepairRequest) obj;
        return Objects.equals(requestId, other.requestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId);
    }

    @Override
    public String toString() {
        return "Заявка[id=%s, статус=%s, проблема=%s]".formatted(
                requestId, status, problemDescription
        );
    }
}