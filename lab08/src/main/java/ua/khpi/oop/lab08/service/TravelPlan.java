package ua.khpi.oop.lab08.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ua.khpi.oop.lab08.model.HotelBooking;
import ua.khpi.oop.lab08.model.MuseumPass;
import ua.khpi.oop.lab08.model.TrainTicket;

public class TravelPlan implements Serializable {

    private final List<HotelBooking> hotelBookings = new ArrayList<>();
    private final List<TrainTicket> trainTickets = new ArrayList<>();
    private final List<MuseumPass> museumPasses = new ArrayList<>();

    public void addHotelBooking(HotelBooking hotelBooking) {
        hotelBookings.add(hotelBooking);
    }

    public void addTrainTicket(TrainTicket trainTicket) {
        trainTickets.add(trainTicket);
    }

    public void addMuseumPass(MuseumPass museumPass) {
        museumPasses.add(museumPass);
    }

    public List<HotelBooking> getHotelBookings() {
        return List.copyOf(hotelBookings);
    }

    public List<TrainTicket> getTrainTickets() {
        return List.copyOf(trainTickets);
    }

    public List<MuseumPass> getMuseumPasses() {
        return List.copyOf(museumPasses);
    }

    public int size() {
        return hotelBookings.size() + trainTickets.size() + museumPasses.size();
    }

    public void printAll() {
        hotelBookings.forEach(System.out::println);
        trainTickets.forEach(System.out::println);
        museumPasses.forEach(System.out::println);
    }
}