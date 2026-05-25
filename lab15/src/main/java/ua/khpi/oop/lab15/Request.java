package ua.khpi.oop.lab15;

public class Request {
    private final int id;
    private final String clientName;
    private final String text;

    public Request(int id, String clientName, String text) {
        if (id <= 0) {
            throw new IllegalArgumentException("Request id must be positive");
        }
        if (clientName == null || clientName.isBlank()) {
            throw new IllegalArgumentException("Client name must not be empty");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Request text must not be empty");
        }

        this.id = id;
        this.clientName = clientName;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Request{id=" + id +
                ", clientName='" + clientName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}