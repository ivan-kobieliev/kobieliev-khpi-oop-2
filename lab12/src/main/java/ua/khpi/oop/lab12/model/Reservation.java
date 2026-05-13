package ua.khpi.oop.lab12.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Reservation {
    private final String code;
    private final Customer customer;
    private final Room room;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ReservationStatus status;

    public Reservation(String code, Customer customer, Room room,
                       LocalDate startDate, LocalDate endDate,
                       ReservationStatus status) {
        this.code = code;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public long getNights() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public double getTotalPrice() {
        return getNights() * room.getPricePerNight();
    }

    @Override
    public String toString() {
        return code + ": " + customer.getFullName()
                + ", room " + room.getNumber()
                + ", " + startDate + " - " + endDate
                + ", status: " + status
                + ", total: " + getTotalPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Reservation reservation)) return false;
        return Objects.equals(code, reservation.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}