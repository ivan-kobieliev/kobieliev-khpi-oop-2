package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public class HotelBooking implements Serializable {

    private String id;
    private String hotelName;
    private String date;
    private int nights;
    private double price;

    public HotelBooking(String id, String hotelName, String date, int nights, double price) {
        this.id = id;
        this.hotelName = hotelName;
        this.date = date;
        this.nights = nights;
        this.price = price;
    }

    public String toFileString() {
        return "HOTEL;" + id + ";" + hotelName + ";" + date + ";" + nights + ";" + price;
    }

    @Override
    public String toString() {
        return "HotelBooking{" +
                "id='" + id + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", date='" + date + '\'' +
                ", nights=" + nights +
                ", price=" + price +
                '}';
    }
}