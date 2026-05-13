package ua.khpi.oop.lab11.service;

import ua.khpi.oop.lab11.model.Reservation;
import ua.khpi.oop.lab11.model.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReservationService {
    private final List<Reservation> reservationsInOrder = new ArrayList<>();
    private final Map<String, Reservation> reservationsByCode = new LinkedHashMap<>();
    private final Map<Integer, Room> roomsByNumber = new LinkedHashMap<>();

    public void addRoom(Room room) {
        if (roomsByNumber.containsKey(room.getNumber())) {
            throw new IllegalArgumentException("Room with this number already exists");
        }

        roomsByNumber.put(room.getNumber(), room);
    }

    public void addReservation(Reservation reservation) {
        String code = reservation.getCode();

        if (reservationsByCode.containsKey(code)) {
            throw new IllegalArgumentException("Reservation with this code already exists");
        }

        reservationsInOrder.add(reservation);
        reservationsByCode.put(code, reservation);
    }

    public Reservation findReservationByCode(String code) {
        return reservationsByCode.get(code);
    }

    public List<Reservation> findReservationsByRoomNumber(int roomNumber) {
        List<Reservation> result = new ArrayList<>();

        for (Reservation reservation : reservationsInOrder) {
            if (reservation.getRoom().getNumber() == roomNumber) {
                result.add(reservation);
            }
        }

        return result;
    }

    public boolean updateReservationDates(String code, LocalDate startDate, LocalDate endDate) {
        Reservation reservation = reservationsByCode.get(code);

        if (reservation == null) {
            return false;
        }

        reservation.updateDates(startDate, endDate);
        return true;
    }

    public Reservation removeReservation(String code) {
        Reservation reservation = reservationsByCode.remove(code);

        if (reservation != null) {
            reservationsInOrder.remove(reservation);
        }

        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return Collections.unmodifiableList(reservationsInOrder);
    }

    public Map<String, Reservation> getReservationsByCode() {
        return Collections.unmodifiableMap(reservationsByCode);
    }

    public Map<Integer, Room> getRoomsByNumber() {
        return Collections.unmodifiableMap(roomsByNumber);
    }

    public int getReservationCount() {
        return reservationsInOrder.size();
    }

    public boolean isEmpty() {
        return reservationsInOrder.isEmpty();
    }

    public String buildReservationReport() {
        StringBuilder report = new StringBuilder("=== Reservations report ===\n");

        for (Map.Entry<String, Reservation> entry : reservationsByCode.entrySet()) {
            report.append(entry.getKey())
                    .append(" -> ")
                    .append(entry.getValue())
                    .append("\n");
        }

        return report.toString();
    }
}