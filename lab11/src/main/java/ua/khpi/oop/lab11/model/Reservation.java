package ua.khpi.oop.lab11.model;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    private final String code;
    private final Customer customer;
    private final Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(String code, Customer customer, Room room,
                       LocalDate startDate, LocalDate endDate) {
        this.code = code;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public void updateDates(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return code + ": " + customer.getFullName()
                + ", room " + room.getNumber()
                + ", from " + startDate + " to " + endDate;
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