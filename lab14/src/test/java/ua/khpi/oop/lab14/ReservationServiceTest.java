package ua.khpi.oop.lab14;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    @Test
    void testReservationValidation() {
        Customer customer = new Customer(
                "C001",
                "Ivan Petrenko",
                "+380501111111"
        );

        Room room = new Room(
                "101",
                2,
                1200.0
        );

        Reservation reservation = new Reservation(
                "R001",
                customer,
                room,
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 4),
                2
        );

        ReservationService service = new ReservationService();

        assertTrue(service.isReservationValid(reservation));
    }

    @Test
    void testInvalidReservation() {
        Customer customer = new Customer(
                "C002",
                "Olena Shevchenko",
                "+380502222222"
        );

        Room room = new Room(
                "102",
                2,
                1000.0
        );

        Reservation reservation = new Reservation(
                "R002",
                customer,
                room,
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 3),
                4
        );

        ReservationService service = new ReservationService();

        assertFalse(service.isReservationValid(reservation));
    }

    @Test
    void testTotalIncomeCalculation() {
        Customer customer = new Customer(
                "C003",
                "Andrii Kovalenko",
                "+380503333333"
        );

        Room room = new Room(
                "201",
                3,
                1500.0
        );

        Reservation reservation1 = new Reservation(
                "R003",
                customer,
                room,
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 4),
                2
        );

        Reservation reservation2 = new Reservation(
                "R004",
                customer,
                room,
                LocalDate.of(2026, 6, 10),
                LocalDate.of(2026, 6, 12),
                2
        );

        ReservationService service = new ReservationService();

        double total = service.calculateTotalIncome(
                List.of(reservation1, reservation2)
        );

        assertEquals(7500.0, total);
    }

    @Test
    void testLoadReportContainsValidReservations() {
        Customer customer = new Customer(
                "C004",
                "Maria Bondarenko",
                "+380504444444"
        );

        Room room = new Room(
                "301",
                2,
                1100.0
        );

        Reservation reservation = new Reservation(
                "R005",
                customer,
                room,
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 3),
                2
        );

        ReservationService service = new ReservationService();

        String report = service.buildLoadReport(
                List.of(reservation)
        );

        assertTrue(report.contains("valid reservations = 1"));
    }
}