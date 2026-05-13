package ua.khpi.oop.lab12.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab12.model.Customer;
import ua.khpi.oop.lab12.model.Reservation;
import ua.khpi.oop.lab12.model.ReservationStatus;
import ua.khpi.oop.lab12.model.Room;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReservationAnalyticsTest {
    private ReservationAnalytics analytics;
    private Reservation reservation1;
    private Reservation reservation2;
    private Reservation reservation3;
    private Reservation reservation4;

    @BeforeEach
    void setUp() {
        Customer customer1 = new Customer("C001", "Ivan Petrenko", "+380501112233");
        Customer customer2 = new Customer("C002", "Olena Shevchenko", "+380671234567");
        Customer customer3 = new Customer("C003", "Andrii Kovalenko", "+380931112244");

        Room room101 = new Room(101, "Single", 1200.0);
        Room room202 = new Room(202, "Double", 1800.0);
        Room room305 = new Room(305, "Luxury", 3500.0);

        reservation1 = new Reservation("R001", customer1, room101,
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 13),
                ReservationStatus.CONFIRMED);

        reservation2 = new Reservation("R002", customer2, room202,
                LocalDate.of(2026, 5, 11),
                LocalDate.of(2026, 5, 15),
                ReservationStatus.NEW);

        reservation3 = new Reservation("R003", customer3, room305,
                LocalDate.of(2026, 5, 15),
                LocalDate.of(2026, 5, 18),
                ReservationStatus.COMPLETED);

        reservation4 = new Reservation("R004", customer1, room202,
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 5),
                ReservationStatus.CANCELLED);

        analytics = new ReservationAnalytics(List.of(
                reservation1,
                reservation2,
                reservation3,
                reservation4
        ));
    }

    @Test
    void testFindReservationsInDateRange() {
        List<Reservation> result = analytics.findReservationsInDateRange(
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 18)
        );

        assertEquals(3, result.size());
        assertTrue(result.contains(reservation1));
        assertTrue(result.contains(reservation2));
        assertTrue(result.contains(reservation3));
    }

    @Test
    void testFindReservationsInDateRangeWithoutMatches() {
        List<Reservation> result = analytics.findReservationsInDateRange(
                LocalDate.of(2026, 7, 1),
                LocalDate.of(2026, 7, 10)
        );

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetCustomerNamesSortedByTotalPrice() {
        List<String> names = analytics.getCustomerNamesSortedByTotalPrice();

        assertEquals(3, names.size());
        assertEquals("Andrii Kovalenko", names.get(0));
        assertEquals("Olena Shevchenko", names.get(1));
        assertEquals("Ivan Petrenko", names.get(2));
    }

    @Test
    void testGetReservationsSortedByStartDate() {
        List<Reservation> result = analytics.getReservationsSortedByStartDate();

        assertEquals(reservation1, result.get(0));
        assertEquals(reservation2, result.get(1));
        assertEquals(reservation3, result.get(2));
        assertEquals(reservation4, result.get(3));
    }

    @Test
    void testCountReservationsByStatus() {
        assertEquals(1, analytics.countReservationsByStatus(ReservationStatus.CONFIRMED));
        assertEquals(1, analytics.countReservationsByStatus(ReservationStatus.NEW));
        assertEquals(1, analytics.countReservationsByStatus(ReservationStatus.COMPLETED));
        assertEquals(1, analytics.countReservationsByStatus(ReservationStatus.CANCELLED));
    }

    @Test
    void testGroupReservationsByStatus() {
        Map<ReservationStatus, List<Reservation>> grouped = analytics.groupReservationsByStatus();

        assertEquals(4, grouped.size());
        assertTrue(grouped.get(ReservationStatus.CONFIRMED).contains(reservation1));
        assertTrue(grouped.get(ReservationStatus.NEW).contains(reservation2));
        assertTrue(grouped.get(ReservationStatus.COMPLETED).contains(reservation3));
        assertTrue(grouped.get(ReservationStatus.CANCELLED).contains(reservation4));
    }

    @Test
    void testCountReservationsByRoomType() {
        Map<String, Long> result = analytics.countReservationsByRoomType();

        assertEquals(1L, result.get("Single"));
        assertEquals(2L, result.get("Double"));
        assertEquals(1L, result.get("Luxury"));
    }

    @Test
    void testCalculateTotalIncome() {
        assertEquals(21300.0, analytics.calculateTotalIncome());
    }

    @Test
    void testFindMostExpensiveReservation() {
        Optional<Reservation> result = analytics.findMostExpensiveReservation();

        assertTrue(result.isPresent());
        assertEquals(reservation3, result.get());
    }

    @Test
    void testGetPriceStatistics() {
        DoubleSummaryStatistics statistics = analytics.getPriceStatistics();

        assertEquals(3, statistics.getCount());
        assertEquals(21300.0, statistics.getSum());
        assertEquals(3600.0, statistics.getMin());
        assertEquals(10500.0, statistics.getMax());
    }

    @Test
    void testFindReservationsByRoomType() {
        List<Reservation> result = analytics.findReservationsByRoomType("Double");

        assertEquals(2, result.size());
        assertEquals(reservation2, result.get(0));
        assertEquals(reservation4, result.get(1));
    }

    @Test
    void testBuildStatusReport() {
        String report = analytics.buildStatusReport();

        assertTrue(report.contains("CONFIRMED: 1 reservations"));
        assertTrue(report.contains("NEW: 1 reservations"));
        assertTrue(report.contains("COMPLETED: 1 reservations"));
        assertTrue(report.contains("CANCELLED: 1 reservations"));
    }

    @Test
    void testImperativeAndStreamResultsAreEqual() {
        assertEquals(
                analytics.findConfirmedReservationsImperative(),
                analytics.findConfirmedReservationsStream()
        );
    }

    @Test
    void testEmptyAnalytics() {
        ReservationAnalytics emptyAnalytics = new ReservationAnalytics(List.of());

        assertTrue(emptyAnalytics.getAllReservations().isEmpty());
        assertEquals(0, emptyAnalytics.calculateTotalIncome());
        assertTrue(emptyAnalytics.findMostExpensiveReservation().isEmpty());
        assertTrue(emptyAnalytics.getReservationsSortedByStartDate().isEmpty());
    }
}