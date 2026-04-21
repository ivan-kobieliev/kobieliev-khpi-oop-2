package ua.khpi.oop.lab01;

import java.util.Objects;

public class Technician {
    private String technicianId;
    private String fullName;
    private String specialization;
    private String phone;

    public Technician() {
    }

    public Technician(String technicianId, String fullName, String specialization, String phone) {
        this.technicianId = technicianId;
        this.fullName = fullName;
        this.specialization = specialization;
        this.phone = phone;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void printTechnicianInfo() {
        System.out.println("Майстер: " + fullName + ", спеціалізація: " + specialization);
    }

    @Override
    public String toString() {
        return "Technician{" +
                "technicianId='" + technicianId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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
}