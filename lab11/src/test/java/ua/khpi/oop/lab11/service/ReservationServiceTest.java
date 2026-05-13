package ua.khpi.oop.lab11.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab11.model.Customer;
import ua.khpi.oop.lab11.model.Reservation;
import ua.khpi.oop.lab11.model.Room;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {
    private ReservationService service;
    private Customer customer1;
    private Customer customer2;
    private Room room101;
    private Room room202;
    private Reservation reservation1;
    private Reservation reservation2;

    @BeforeEach
    void setUp() {
        service = new ReservationService();

        customer1 = new Customer("C001", "Ivan Petrenko", "+380501112233");
        customer2 = new Customer("C002", "Olena Shevchenko", "+380671234567");

        room101 = new Room(101, "Single", 1200.0);
        room202 = new Room(202, "Double", 1800.0);

        reservation1 = new Reservation(
                "R001",
                customer1,
                room101,
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 13)
        );

        reservation2 = new Reservation(
                "R002",
                customer2,
                room202,
                LocalDate.of(2026, 5, 11),
                LocalDate.of(2026, 5, 15)
        );
    }

    @Test
    void testInitialState() {
        assertTrue(service.isEmpty());
        assertEquals(0, service.getReservationCount());
        assertTrue(service.getAllReservations().isEmpty());
    }

    @Test
    void testAddReservation() {
        service.addReservation(reservation1);

        assertFalse(service.isEmpty());
        assertEquals(1, service.getReservationCount());
        assertEquals(reservation1, service.findReservationByCode("R001"));
    }

    @Test
    void testAddDuplicateReservationCode() {
        service.addReservation(reservation1);

        Reservation duplicate = new Reservation(
                "R001",
                customer2,
                room202,
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 3)
        );

        assertThrows(IllegalArgumentException.class,
                () -> service.addReservation(duplicate));
    }

    @Test
    void testFindReservationByCode() {
        service.addReservation(reservation1);
        service.addReservation(reservation2);

        assertEquals(reservation1, service.findReservationByCode("R001"));
        assertEquals(reservation2, service.findReservationByCode("R002"));
        assertNull(service.findReservationByCode("R999"));
    }

    @Test
    void testFindReservationsByRoomNumber() {
        Reservation reservation3 = new Reservation(
                "R003",
                customer2,
                room101,
                LocalDate.of(2026, 5, 20),
                LocalDate.of(2026, 5, 22)
        );

        service.addReservation(reservation1);
        service.addReservation(reservation2);
        service.addReservation(reservation3);

        List<Reservation> room101Reservations = service.findReservationsByRoomNumber(101);

        assertEquals(2, room101Reservations.size());
        assertTrue(room101Reservations.contains(reservation1));
        assertTrue(room101Reservations.contains(reservation3));
    }

    @Test
    void testUpdateReservationDates() {
        service.addReservation(reservation1);

        boolean updated = service.updateReservationDates(
                "R001",
                LocalDate.of(2026, 5, 12),
                LocalDate.of(2026, 5, 16)
        );

        assertTrue(updated);
        assertEquals(LocalDate.of(2026, 5, 12),
                service.findReservationByCode("R001").getStartDate());
        assertEquals(LocalDate.of(2026, 5, 16),
                service.findReservationByCode("R001").getEndDate());
    }

    @Test
    void testUpdateNonExistentReservation() {
        boolean updated = service.updateReservationDates(
                "R999",
                LocalDate.of(2026, 5, 12),
                LocalDate.of(2026, 5, 16)
        );

        assertFalse(updated);
    }

    @Test
    void testRemoveReservation() {
        service.addReservation(reservation1);
        service.addReservation(reservation2);

        Reservation removed = service.removeReservation("R001");

        assertEquals(reservation1, removed);
        assertEquals(1, service.getReservationCount());
        assertNull(service.findReservationByCode("R001"));
    }

    @Test
    void testRemoveNonExistentReservation() {
        service.addReservation(reservation1);

        Reservation removed = service.removeReservation("R999");

        assertNull(removed);
        assertEquals(1, service.getReservationCount());
    }

    @Test
    void testGetAllReservationsOrder() {
        service.addReservation(reservation1);
        service.addReservation(reservation2);

        List<Reservation> reservations = service.getAllReservations();

        assertEquals(reservation1, reservations.get(0));
        assertEquals(reservation2, reservations.get(1));
    }

    @Test
    void testUnmodifiableReservationsList() {
        service.addReservation(reservation1);

        List<Reservation> reservations = service.getAllReservations();

        assertThrows(UnsupportedOperationException.class,
                () -> reservations.add(reservation2));
    }

    @Test
    void testAddDuplicateRoomNumber() {
        service.addRoom(room101);

        Room duplicateRoom = new Room(101, "Luxury", 3500.0);

        assertThrows(IllegalArgumentException.class,
                () -> service.addRoom(duplicateRoom));
    }
}