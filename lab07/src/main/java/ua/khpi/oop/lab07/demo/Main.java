package ua.khpi.oop.lab07.demo;

import ua.khpi.oop.lab07.contracts.Payable;
import ua.khpi.oop.lab07.contracts.Reservable;
import ua.khpi.oop.lab07.model.HotelBooking;
import ua.khpi.oop.lab07.model.MuseumPass;
import ua.khpi.oop.lab07.model.TrainTicket;

public class Main {
    public static void main(String[] args) {
        Reservable[] reservables = {
                new HotelBooking("Kyiv Central Hotel", 3),
                new TrainTicket("Kharkiv - Lviv")
        };

        System.out.println("Reservation operations:");
        for (Reservable item : reservables) {
            System.out.println(item.reserve("Person One"));
        }

        System.out.println();

        Payable[] payables = {
                new HotelBooking("Kyiv Central Hotel", 3),
                new TrainTicket("Kharkiv - Lviv"),
                new MuseumPass("National Art Museum")
        };

        System.out.println("Payment operations:");
        for (Payable item : payables) {
            System.out.println(item.pay(500.0));
        }

        System.out.println();

        HotelBooking hotelBooking = new HotelBooking("Odesa Sea Hotel", 2);

        Reservable reservableView = hotelBooking;
        Payable payableView = hotelBooking;

        System.out.println("One object through two interface views:");
        System.out.println(reservableView.reserve("Person Two"));
        System.out.println(payableView.pay(1200.0));
    }
}