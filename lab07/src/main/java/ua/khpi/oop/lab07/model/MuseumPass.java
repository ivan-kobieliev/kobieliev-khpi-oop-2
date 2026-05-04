package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Payable;

public class MuseumPass implements Payable {

    private String museumName;

    public MuseumPass(String museumName) {
        this.museumName = museumName;
    }

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " for museum pass to " + museumName;
    }
}