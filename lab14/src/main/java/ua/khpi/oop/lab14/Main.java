package ua.khpi.oop.lab14;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReservationService service = new ReservationService();

        Customer customer1 = new Customer("C001", "Ivan Petrenko", "+380501111111");
        Customer customer2 = new Customer("C002", "Olena Shevchenko", "+380502222222");
        Customer customer3 = new Customer("C003", "Andrii Kovalenko", "+380503333333");

        Room room1 = new Room("101", 2, 1200.0);
        Room room2 = new Room("202", 3, 1800.0);

        List<Reservation> reservations = List.of(
                new Reservation("R001", customer1, room1,
                        LocalDate.of(2026, 6, 1),
                        LocalDate.of(2026, 6, 4),
                        2),

                new Reservation("R002", customer2, room2,
                        LocalDate.of(2026, 6, 5),
                        LocalDate.of(2026, 6, 8),
                        3),

                new Reservation("R003", customer3, room1,
                        LocalDate.of(2026, 6, 10),
                        LocalDate.of(2026, 6, 12),
                        4)
        );

        ReservationCheckThread checkThread =
                new ReservationCheckThread("Reservation-Check-Thread", reservations, service);

        ConfirmationTask confirmationTask = new ConfirmationTask(reservations, service);
        Thread confirmationThread = new Thread(confirmationTask, "Confirmation-Thread");

        LoadReportTask reportTask = new LoadReportTask(reservations, service);
        Thread reportThread = new Thread(reportTask, "Load-Report-Thread");

        System.out.println("Main: starting threads");

        checkThread.start();
        confirmationThread.start();
        reportThread.start();

        checkThread.join();
        confirmationThread.join();
        reportThread.join();

        System.out.println();
        System.out.println("Main: all threads completed");
        System.out.println();

        System.out.println("Check results:");
        checkThread.getResults().forEach(System.out::println);

        System.out.println();
        System.out.println("Confirmations:");
        confirmationTask.getConfirmations().forEach(System.out::println);

        System.out.println();
        System.out.println(reportTask.getReport());
    }
}