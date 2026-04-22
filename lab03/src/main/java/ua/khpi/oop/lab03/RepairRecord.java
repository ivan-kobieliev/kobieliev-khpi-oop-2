package ua.khpi.oop.lab03;

import java.time.LocalDate;
import java.util.Objects;

public class RepairRecord {
    private final RepairRequest request;
    private final Technician technician;
    private final LocalDate startDate;
    private LocalDate endDate;

    public RepairRecord(RepairRequest request, Technician technician, LocalDate startDate) {
        if (request == null) {
            throw new IllegalArgumentException("Заявка не може бути порожньою");
        }
        if (technician == null) {
            throw new IllegalArgumentException("Майстер не може бути порожнім");
        }
        if (startDate == null) {
            throw new IllegalArgumentException("Дата початку не може бути порожньою");
        }

        this.request = request;
        this.technician = technician;
        this.startDate = startDate;
        this.endDate = null;
    }

    public RepairRequest getRequest() {
        return request;
    }

    public Technician getTechnician() {
        return technician;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isFinished() {
        return endDate != null;
    }

    public void finish(LocalDate endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("Дата завершення не може бути порожньою");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Дата завершення не може бути раніше дати початку");
        }
        this.endDate = endDate;
        request.markCompleted();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RepairRecord)) return false;
        RepairRecord other = (RepairRecord) obj;
        return Objects.equals(request, other.request)
                && Objects.equals(technician, other.technician)
                && Objects.equals(startDate, other.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request, technician, startDate);
    }

    @Override
    public String toString() {
        return "ЗаписРемонту[заявка=%s, майстер=%s, початок=%s, завершення=%s]".formatted(
                request.getRequestId(), technician.getTechnicianId(), startDate, endDate
        );
    }
}