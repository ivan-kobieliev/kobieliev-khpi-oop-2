package ua.khpi.oop.lab14;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationTask implements Runnable {
    private final List<Reservation> reservations;
    private final ReservationService service;
    private final List<String> confirmations = new ArrayList<>();

    public ConfirmationTask(List<Reservation> reservations, ReservationService service) {
        this.reservations = reservations;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();

            for (Reservation reservation : reservations) {
                String confirmation = service.buildConfirmation(reservation);

                confirmations.add(confirmation);

                System.out.println(threadName
                        + ": prepared confirmation for "
                        + reservation.getId());

                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": interrupted");
        }
    }

    public List<String> getConfirmations() {
        return confirmations;
    }
}