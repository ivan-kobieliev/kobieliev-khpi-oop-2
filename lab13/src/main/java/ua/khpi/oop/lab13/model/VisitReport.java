package ua.khpi.oop.lab13.model;

public final class VisitReport {
    private final int totalVisits;
    private final int therapyVisits;
    private final int cardiologyVisits;

    public VisitReport(int totalVisits, int therapyVisits, int cardiologyVisits) {
        this.totalVisits = totalVisits;
        this.therapyVisits = therapyVisits;
        this.cardiologyVisits = cardiologyVisits;
    }

    public int totalVisits() {
        return totalVisits;
    }

    public int therapyVisits() {
        return therapyVisits;
    }

    public int cardiologyVisits() {
        return cardiologyVisits;
    }
}