package ua.khpi.oop.lab08.demo;

import ua.khpi.oop.lab08.exception.InvalidTravelDataException;
import ua.khpi.oop.lab08.model.HotelBooking;
import ua.khpi.oop.lab08.model.MuseumPass;
import ua.khpi.oop.lab08.model.TrainTicket;
import ua.khpi.oop.lab08.persistence.TravelPlanFileManager;
import ua.khpi.oop.lab08.service.TravelPlan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        TravelPlan travelPlan = new TravelPlan();

        travelPlan.addHotelBooking(new HotelBooking(
                "HB001", "Kyiv Central Hotel", "2026-05-10", 3, 2400.0
        ));
        travelPlan.addTrainTicket(new TrainTicket(
                "TT001", "Kharkiv - Lviv", "2026-05-11", 12, 850.0
        ));
        travelPlan.addMuseumPass(new MuseumPass(
                "MP001", "National Art Museum", "2026-05-12", 300.0
        ));

        TravelPlanFileManager fileManager = new TravelPlanFileManager();

        Path textPath = Path.of("build", "lab08", "travel-plan.txt");
        Path binaryPath = Path.of("build", "lab08", "travel-plan.bin");
        Path brokenPath = Path.of("build", "lab08", "broken-travel-plan.txt");

        try {
            fileManager.saveAsText(travelPlan, textPath);
            System.out.println("Saved to text file: " + textPath);

            TravelPlan restoredFromText = fileManager.loadFromText(textPath);
            System.out.println("Restored from text file:");
            restoredFromText.printAll();

            fileManager.serialize(restoredFromText, binaryPath);
            System.out.println("Serialized to binary file: " + binaryPath);

            TravelPlan restoredFromBinary = fileManager.deserialize(binaryPath);
            System.out.println("Restored from binary file:");
            restoredFromBinary.printAll();

            Files.writeString(brokenPath, "HOTEL;ONLY_ONE_FIELD");
            fileManager.loadFromText(brokenPath);

        } catch (InvalidTravelDataException exception) {
            System.err.println("Travel data error: " + exception.getMessage());
        } catch (IOException exception) {
            System.err.println("File error: " + exception.getMessage());
        } catch (ClassNotFoundException exception) {
            System.err.println("Serialization error: " + exception.getMessage());
        }
    }
}