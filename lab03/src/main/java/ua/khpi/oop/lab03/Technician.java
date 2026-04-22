package ua.khpi.oop.lab03;

import java.util.Objects;

public class Technician {
    private final String technicianId;
    private final String fullName;

    public Technician(String technicianId, String fullName) {
        if (technicianId == null || technicianId.isBlank()) {
            throw new IllegalArgumentException("Ідентифікатор майстра не може бути порожнім");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("ПІБ майстра не може бути порожнім");
        }
        this.technicianId = technicianId;
        this.fullName = fullName;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Technician)) return false;
        Technician other = (Technician) obj;
        return Objects.equals(technicianId, other.technicianId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technicianId);
    }

    @Override
    public String toString() {
        return "Майстер[id=%s, ПІБ=%s]".formatted(technicianId, fullName);
    }
}