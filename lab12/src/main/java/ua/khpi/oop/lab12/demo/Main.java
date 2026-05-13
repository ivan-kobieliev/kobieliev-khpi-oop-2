package ua.khpi.oop.lab12.demo;

import ua.khpi.oop.lab12.model.Customer;
import ua.khpi.oop.lab12.model.Reservation;
import ua.khpi.oop.lab12.model.ReservationStatus;
import ua.khpi.oop.lab12.model.Room;
import ua.khpi.oop.lab12.service.ReservationAnalytics;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("C001", "Ivan Petrenko", "+380501112233");
        Customer customer2 = new Customer("C002", "Olena Shevchenko", "+380671234567");
        Customer customer3 = new Customer("C003", "Andrii Kovalenko", "+380931112244");

        Room room101 = new Room(101, "Single", 1200.0);
        Room room202 = new Room(202, "Double", 1800.0);
        Room room305 = new Room(305, "Luxury", 3500.0);

        List<Reservation> reservations = List.of(
                new Reservation("R001", customer1, room101,
                        LocalDate.of(2026, 5, 10),
                        LocalDate.of(2026, 5, 13),
                        ReservationStatus.CONFIRMED),

                new Reservation("R002", customer2, room202,
                        LocalDate.of(2026, 5, 11),
                        LocalDate.of(2026, 5, 15),
                        ReservationStatus.NEW),

                new Reservation("R003", customer3, room305,
                        LocalDate.of(2026, 5, 15),
                        LocalDate.of(2026, 5, 18),
                        ReservationStatus.COMPLETED),

                new Reservation("R004", customer1, room202,
                        LocalDate.of(2026, 6, 1),
                        LocalDate.of(2026, 6, 5),
                        ReservationStatus.CANCELLED),

                new Reservation("R005", customer2, room101,
                        LocalDate.of(2026, 6, 3),
                        LocalDate.of(2026, 6, 6),
                        ReservationStatus.CONFIRMED)
        );

        ReservationAnalytics analytics = new ReservationAnalytics(reservations);

        System.out.println("=== Stream API Reservation System Demo ===");

        System.out.println("\nAll reservations:");
        analytics.getAllReservations().forEach(System.out::println);

        System.out.println("\nReservations in date range 2026-05-10 - 2026-05-18:");
        analytics.findReservationsInDateRange(
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 18)
        ).forEach(System.out::println);

        System.out.println("\nReservations sorted by start date:");
        analytics.getReservationsSortedByStartDate()
                .forEach(System.out::println);

        System.out.println("\nCustomer names sorted by total price:");
        analytics.getCustomerNamesSortedByTotalPrice()
                .forEach(name -> System.out.println("- " + name));

        System.out.println("\nConfirmed reservations count:");
        System.out.println(analytics.countReservationsByStatus(ReservationStatus.CONFIRMED));

        System.out.println("\nReservation count by room type:");
        analytics.countReservationsByRoomType()
                .forEach((type, count) -> System.out.println(type + ": " + count));

        System.out.println("\nGrouped reservations by status:");
        analytics.groupReservationsByStatus()
                .forEach((status, list) -> System.out.println(status + ": " + list.size()));

        System.out.println("\nTotal income without cancelled reservations:");
        System.out.println(analytics.calculateTotalIncome());

        System.out.println("\nMost expensive reservation:");
        analytics.findMostExpensiveReservation()
                .ifPresent(System.out::println);

        System.out.println("\nPrice statistics:");
        System.out.println(analytics.getPriceStatistics());

        System.out.println("\nLuxury reservations:");
        analytics.findReservationsByRoomType("Luxury")
                .forEach(System.out::println);

        System.out.println("\nStatus report:");
        System.out.println(analytics.buildStatusReport());

        System.out.println("\nComparison: imperative vs stream");
        System.out.println("Imperative confirmed reservations: "
                + analytics.findConfirmedReservationsImperative().size());
        System.out.println("Stream confirmed reservations: "
                + analytics.findConfirmedReservationsStream().size());

        System.out.println("\nStream operations demonstrated:");
        System.out.println("filter() - search by date range, room type and status");
        System.out.println("map() - transform reservations to customer names");
        System.out.println("sorted() - sort by date and total price");
        System.out.println("count() - count reservations by status");
        System.out.println("collect() - grouping, counting and statistics");
        System.out.println("toList() - collect stream results into lists");
    }
}