package ua.khpi.oop.lab12.service;

import ua.khpi.oop.lab12.model.Reservation;
import ua.khpi.oop.lab12.model.ReservationStatus;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationAnalytics {
    private final List<Reservation> reservations;

    public ReservationAnalytics(List<Reservation> reservations) {
        this.reservations = List.copyOf(reservations);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public List<Reservation> findReservationsInDateRange(LocalDate from, LocalDate to) {
        return reservations.stream()
                .filter(reservation ->
                        !reservation.getStartDate().isBefore(from)
                                && !reservation.getEndDate().isAfter(to))
                .toList();
    }

    public List<String> getCustomerNamesSortedByTotalPrice() {
        return reservations.stream()
                .sorted(Comparator.comparingDouble(Reservation::getTotalPrice).reversed())
                .map(reservation -> reservation.getCustomer().getFullName())
                .distinct()
                .toList();
    }

    public List<Reservation> getReservationsSortedByStartDate() {
        return reservations.stream()
                .sorted(Comparator.comparing(Reservation::getStartDate))
                .toList();
    }

    public long countReservationsByStatus(ReservationStatus status) {
        return reservations.stream()
                .filter(reservation -> reservation.getStatus() == status)
                .count();
    }

    public Map<ReservationStatus, List<Reservation>> groupReservationsByStatus() {
        return reservations.stream()
                .collect(Collectors.groupingBy(Reservation::getStatus));
    }

    public Map<String, Long> countReservationsByRoomType() {
        return reservations.stream()
                .collect(Collectors.groupingBy(
                        reservation -> reservation.getRoom().getType(),
                        Collectors.counting()
                ));
    }

    public double calculateTotalIncome() {
        return reservations.stream()
                .filter(reservation -> reservation.getStatus() != ReservationStatus.CANCELLED)
                .mapToDouble(Reservation::getTotalPrice)
                .sum();
    }

    public Optional<Reservation> findMostExpensiveReservation() {
        return reservations.stream()
                .max(Comparator.comparingDouble(Reservation::getTotalPrice));
    }

    public DoubleSummaryStatistics getPriceStatistics() {
        return reservations.stream()
                .filter(reservation -> reservation.getStatus() != ReservationStatus.CANCELLED)
                .collect(Collectors.summarizingDouble(Reservation::getTotalPrice));
    }

    public List<Reservation> findReservationsByRoomType(String roomType) {
        return reservations.stream()
                .filter(reservation -> reservation.getRoom().getType().equals(roomType))
                .sorted(Comparator.comparing(Reservation::getStartDate))
                .toList();
    }

    public String buildStatusReport() {
        return groupReservationsByStatus().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + ": " + entry.getValue().size() + " reservations")
                .collect(Collectors.joining("\n"));
    }

    public List<Reservation> findConfirmedReservationsImperative() {
        List<Reservation> result = new java.util.ArrayList<>();

        for (Reservation reservation : reservations) {
            if (reservation.getStatus() == ReservationStatus.CONFIRMED) {
                result.add(reservation);
            }
        }

        return result;
    }

    public List<Reservation> findConfirmedReservationsStream() {
        return reservations.stream()
                .filter(reservation -> reservation.getStatus() == ReservationStatus.CONFIRMED)
                .toList();
    }
}