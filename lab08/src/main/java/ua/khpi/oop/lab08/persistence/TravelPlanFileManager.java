package ua.khpi.oop.lab08.persistence;

import ua.khpi.oop.lab08.exception.InvalidTravelDataException;
import ua.khpi.oop.lab08.model.HotelBooking;
import ua.khpi.oop.lab08.model.MuseumPass;
import ua.khpi.oop.lab08.model.TrainTicket;
import ua.khpi.oop.lab08.service.TravelPlan;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TravelPlanFileManager {

    public void saveAsText(TravelPlan travelPlan, Path path) throws IOException {
        ensureParentDirectory(path);

        List<String> lines = new java.util.ArrayList<>();

        travelPlan.getHotelBookings().forEach(item -> lines.add(item.toFileString()));
        travelPlan.getTrainTickets().forEach(item -> lines.add(item.toFileString()));
        travelPlan.getMuseumPasses().forEach(item -> lines.add(item.toFileString()));

        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public TravelPlan loadFromText(Path path) throws IOException, InvalidTravelDataException {
        TravelPlan travelPlan = new TravelPlan();
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        int lineNumber = 1;

        for (String line : lines) {
            if (line.isBlank()) {
                lineNumber++;
                continue;
            }

            String[] parts = line.split(";", -1);

            try {
                switch (parts[0]) {
                    case "HOTEL" -> {
                        if (parts.length != 6) {
                            throw new InvalidTravelDataException("Invalid HOTEL field count at line " + lineNumber);
                        }

                        travelPlan.addHotelBooking(new HotelBooking(
                                parts[1],
                                parts[2],
                                parts[3],
                                Integer.parseInt(parts[4]),
                                Double.parseDouble(parts[5])
                        ));
                    }

                    case "TRAIN" -> {
                        if (parts.length != 6) {
                            throw new InvalidTravelDataException("Invalid TRAIN field count at line " + lineNumber);
                        }

                        travelPlan.addTrainTicket(new TrainTicket(
                                parts[1],
                                parts[2],
                                parts[3],
                                Integer.parseInt(parts[4]),
                                Double.parseDouble(parts[5])
                        ));
                    }

                    case "MUSEUM" -> {
                        if (parts.length != 5) {
                            throw new InvalidTravelDataException("Invalid MUSEUM field count at line " + lineNumber);
                        }

                        travelPlan.addMuseumPass(new MuseumPass(
                                parts[1],
                                parts[2],
                                parts[3],
                                Double.parseDouble(parts[4])
                        ));
                    }

                    default -> throw new InvalidTravelDataException("Unknown record type at line " + lineNumber);
                }
            } catch (NumberFormatException exception) {
                throw new InvalidTravelDataException("Invalid number format at line " + lineNumber, exception);
            }

            lineNumber++;
        }

        return travelPlan;
    }

    public void serialize(TravelPlan travelPlan, Path path) throws IOException {
        ensureParentDirectory(path);

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(travelPlan);
        }
    }

    public TravelPlan deserialize(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(Files.newInputStream(path))) {
            return (TravelPlan) inputStream.readObject();
        }
    }

    private void ensureParentDirectory(Path path) throws IOException {
        Path parent = path.getParent();

        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}