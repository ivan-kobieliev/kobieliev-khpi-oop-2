package ua.khpi.oop.lab01;

import java.util.Objects;

public class RepairRequest {
    private String requestId;
    private String problemDescription;
    private String status;
    private String date;

    public RepairRequest() {
    }

    public RepairRequest(String requestId, String problemDescription, String status, String date) {
        this.requestId = requestId;
        this.problemDescription = problemDescription;
        this.status = status;
        this.date = date;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void printRequestInfo() {
        System.out.println("Заявка №" + requestId + ": " + problemDescription + ", статус: " + status);
    }

    @Override
    public String toString() {
        return "RepairRequest{" +
                "requestId='" + requestId + '\'' +
                ", problemDescription='" + problemDescription + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
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
}