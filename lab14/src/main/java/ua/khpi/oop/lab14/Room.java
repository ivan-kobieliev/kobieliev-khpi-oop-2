package ua.khpi.oop.lab14;

import java.util.Objects;

public class Room {
    private final String number;
    private final int capacity;
    private final double pricePerNight;

    public Room(String number, int capacity, double pricePerNight) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Room number cannot be empty");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Room capacity must be positive");
        }
        if (pricePerNight <= 0) {
            throw new IllegalArgumentException("Room price must be positive");
        }

        this.number = number;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    public String getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Room room)) return false;
        return Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Room " + number + ", capacity " + capacity + ", price " + pricePerNight;
    }
}