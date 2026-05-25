package ua.khpi.oop.lab14;

import java.util.ArrayList;
import java.util.List;

public class ReservationCheckThread extends Thread {
    private final List<Reservation> reservations;
    private final ReservationService service;
    private final List<String> results = new ArrayList<>();

    public ReservationCheckThread(String name, List<Reservation> reservations, ReservationService service) {
        this.reservations = reservations;
        this.service = service;
        setName(name);
    }

    @Override
    public void run() {
        try {
            for (Reservation reservation : reservations) {
                String threadName = Thread.currentThread().getName();

                if (service.isReservationValid(reservation)) {
                    results.add("Reservation " + reservation.getId() + " is valid");
                } else {
                    results.add("Reservation " + reservation.getId() + " is invalid");
                }

                System.out.println(threadName + ": checked " + reservation.getId());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(getName() + ": interrupted");
        }
    }

    public List<String> getResults() {
        return results;
    }
}