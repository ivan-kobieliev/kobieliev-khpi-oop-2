package ua.khpi.oop.lab07.model;

import ua.khpi.oop.lab07.contracts.Reservable;
import ua.khpi.oop.lab07.contracts.Payable;

public class TrainTicket implements Reservable, Payable {

    private String route;
    private boolean reserved;

    public TrainTicket(String route) {
        this.route = route;
    }

    @Override
    public String reserve(String customerName) {
        if (reserved) {
            return "Ticket already reserved";
        }
        reserved = true;
        return "Train ticket reserved for " + customerName + " (" + route + ")";
    }

    @Override
    public String pay(double amount) {
        return "Payment of " + amount + " completed for route " + route;
    }
}