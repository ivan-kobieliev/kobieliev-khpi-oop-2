package ua.khpi.oop.lab14;

import java.util.List;

public class LoadReportTask implements Runnable {
    private final List<Reservation> reservations;
    private final ReservationService service;

    private String report;

    public LoadReportTask(List<Reservation> reservations, ReservationService service) {
        this.reservations = reservations;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();

            System.out.println(threadName + ": starting load report generation");

            Thread.sleep(500);

            report = service.buildLoadReport(reservations);

            System.out.println(threadName + ": load report generated");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": interrupted");
        }
    }

    public String getReport() {
        return report;
    }
}