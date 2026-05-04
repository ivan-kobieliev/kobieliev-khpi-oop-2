package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public class TrainTicket implements Serializable {

    private String id;
    private String route;
    private String date;
    private int seat;
    private double price;

    public TrainTicket(String id, String route, String date, int seat, double price) {
        this.id = id;
        this.route = route;
        this.date = date;
        this.seat = seat;
        this.price = price;
    }

    public String toFileString() {
        return "TRAIN;" + id + ";" + route + ";" + date + ";" + seat + ";" + price;
    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "id='" + id + '\'' +
                ", route='" + route + '\'' +
                ", date='" + date + '\'' +
                ", seat=" + seat +
                ", price=" + price +
                '}';
    }
}