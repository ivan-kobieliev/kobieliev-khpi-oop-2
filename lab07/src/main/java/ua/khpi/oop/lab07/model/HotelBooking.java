package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Reservable;
import ua.khpi.oop.lab07.contracts.Payable;

public class HotelBooking implements Reservable, Payable {

    private String hotelName;
    private int nights;
    private boolean reserved;

    public HotelBooking(String hotelName, int nights) {
        this.hotelName = hotelName;
        this.nights = nights;
    }

    @Override
    public String reserve(String customerName) {
        if (reserved) {
            return "Booking already reserved";
        }
        reserved = true;
        return "Hotel booked for " + customerName + " at " + hotelName;
    }

    @Override
    public String pay(double amount) {
        return "Payment of " + amount + " completed for hotel " + hotelName;
    }
}