package ua.khpi.oop.lab14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Reservation {
    private final String id;
    private final Customer customer;
    private final Room room;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int guests;

    public Reservation(String id, Customer customer, Room room,
                       LocalDate startDate, LocalDate endDate, int guests) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Reservation id cannot be empty");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        if (guests <= 0) {
            throw new IllegalArgumentException("Guests count must be positive");
        }

        this.id = id;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guests = guests;
    }

    public String getId() {
        return id;
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

    public int getGuests() {
        return guests;
    }

    public long getNights() {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    public double getTotalPrice() {
        return getNights() * room.getPricePerNight();
    }

    public boolean fitsRoomCapacity() {
        return guests <= room.getCapacity();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Reservation reservation)) return false;
        return Objects.equals(id, reservation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + ": " + customer.getName() + ", room " + room.getNumber()
                + ", " + startDate + " - " + endDate;
    }
}