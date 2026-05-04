package ua.khpi.oop.lab08.model;

import java.io.Serializable;

public class MuseumPass implements Serializable {

    private String id;
    private String museumName;
    private String date;
    private double price;

    public MuseumPass(String id, String museumName, String date, double price) {
        this.id = id;
        this.museumName = museumName;
        this.date = date;
        this.price = price;
    }

    public String toFileString() {
        return "MUSEUM;" + id + ";" + museumName + ";" + date + ";" + price;
    }

    @Override
    public String toString() {
        return "MuseumPass{" +
                "id='" + id + '\'' +
                ", museumName='" + museumName + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}