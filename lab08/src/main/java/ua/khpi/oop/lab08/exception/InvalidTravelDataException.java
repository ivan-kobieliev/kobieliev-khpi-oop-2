package ua.khpi.oop.lab08.exception;

public class InvalidTravelDataException extends Exception {

    public InvalidTravelDataException(String message) {
        super(message);
    }

    public InvalidTravelDataException(String message, Throwable cause) {
        super(message, cause);
    }
}