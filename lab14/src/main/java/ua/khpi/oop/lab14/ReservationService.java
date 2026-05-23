package ua.khpi.oop.lab14;

import java.util.List;

public class ReservationService {
    public boolean isReservationValid(Reservation reservation) {
        return reservation != null && reservation.fitsRoomCapacity();
    }

    public String buildConfirmation(Reservation reservation) {
        if (!isReservationValid(reservation)) {
            return "Reservation " + reservation.getId() + " rejected";
        }

        return "Reservation " + reservation.getId()
                + " confirmed for " + reservation.getCustomer().getName()
                + ", room " + reservation.getRoom().getNumber()
                + ", nights: " + reservation.getNights()
                + ", total: " + reservation.getTotalPrice();
    }

    public long countValidReservations(List<Reservation> reservations) {
        return reservations.stream()
                .filter(this::isReservationValid)
                .count();
    }

    public double calculateTotalIncome(List<Reservation> reservations) {
        return reservations.stream()
                .filter(this::isReservationValid)
                .mapToDouble(Reservation::getTotalPrice)
                .sum();
    }

    public String buildLoadReport(List<Reservation> reservations) {
        long valid = countValidReservations(reservations);
        long rejected = reservations.size() - valid;
        double income = calculateTotalIncome(reservations);

        return "Load report: valid reservations = " + valid
                + ", rejected reservations = " + rejected
                + ", expected income = " + income;
    }
}