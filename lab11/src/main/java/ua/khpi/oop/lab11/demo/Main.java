package ua.khpi.oop.lab11.demo;

import ua.khpi.oop.lab11.model.Customer;
import ua.khpi.oop.lab11.model.Reservation;
import ua.khpi.oop.lab11.model.Room;
import ua.khpi.oop.lab11.service.ReservationService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ReservationService service = new ReservationService();

        Room room101 = new Room(101, "Single", 1200.0);
        Room room202 = new Room(202, "Double", 1800.0);
        Room room305 = new Room(305, "Luxury", 3500.0);

        service.addRoom(room101);
        service.addRoom(room202);
        service.addRoom(room305);

        Customer customer1 = new Customer("C001", "Ivan Petrenko", "+380501112233");
        Customer customer2 = new Customer("C002", "Olena Shevchenko", "+380671234567");
        Customer customer3 = new Customer("C003", "Andrii Kovalenko", "+380931112244");

        Reservation reservation1 = new Reservation(
                "R001",
                customer1,
                room101,
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 13)
        );

        Reservation reservation2 = new Reservation(
                "R002",
                customer2,
                room202,
                LocalDate.of(2026, 5, 11),
                LocalDate.of(2026, 5, 15)
        );

        Reservation reservation3 = new Reservation(
                "R003",
                customer3,
                room101,
                LocalDate.of(2026, 5, 20),
                LocalDate.of(2026, 5, 22)
        );

        service.addReservation(reservation1);
        service.addReservation(reservation2);
        service.addReservation(reservation3);

        System.out.println("=== Reservation System Demo ===");

        System.out.println("\nAll reservations:");
        for (Reservation reservation : service.getAllReservations()) {
            System.out.println(reservation);
        }

        System.out.println("\nFind reservation by code R002:");
        System.out.println(service.findReservationByCode("R002"));

        System.out.println("\nReservations for room 101:");
        for (Reservation reservation : service.findReservationsByRoomNumber(101)) {
            System.out.println(reservation);
        }

        System.out.println("\nUpdate reservation R001:");
        service.updateReservationDates(
                "R001",
                LocalDate.of(2026, 5, 12),
                LocalDate.of(2026, 5, 16)
        );
        System.out.println(service.findReservationByCode("R001"));

        System.out.println("\nMap report:");
        System.out.println(service.buildReservationReport());

        System.out.println("Remove reservation R003:");
        Reservation removed = service.removeReservation("R003");
        System.out.println("Removed: " + removed);

        System.out.println("\nReservations after removing:");
        for (Reservation reservation : service.getAllReservations()) {
            System.out.println(reservation);
        }

        System.out.println("\nCollection types used:");
        System.out.println("1. ArrayList<Reservation> - ordered reservation storage");
        System.out.println("2. LinkedHashMap<String, Reservation> - fast search by reservation code");
        System.out.println("3. LinkedHashMap<Integer, Room> - fast search by room number");
    }
}