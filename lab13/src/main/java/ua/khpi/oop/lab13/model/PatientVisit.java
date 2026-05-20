package ua.khpi.oop.lab13.model;

import java.time.LocalDate;
import java.util.Objects;

public final class PatientVisit {
    private final LocalDate visitDate;
    private final String patientCode;
    private final String patientName;
    private final String department;
    private final String prescription;

    public PatientVisit(LocalDate visitDate, String patientCode, String patientName,
                        String department, String prescription) {
        this.visitDate = Objects.requireNonNull(visitDate);
        this.patientCode = Objects.requireNonNull(patientCode);
        this.patientName = Objects.requireNonNull(patientName);
        this.department = Objects.requireNonNull(department);
        this.prescription = Objects.requireNonNull(prescription);
    }

    public LocalDate visitDate() {
        return visitDate;
    }

    public String patientCode() {
        return patientCode;
    }

    public String patientName() {
        return patientName;
    }

    public String department() {
        return department;
    }

    public String prescription() {
        return prescription;
    }

    @Override
    public String toString() {
        return visitDate + " | " + patientCode + " | " + patientName
                + " | " + department + " | " + prescription;
    }
}