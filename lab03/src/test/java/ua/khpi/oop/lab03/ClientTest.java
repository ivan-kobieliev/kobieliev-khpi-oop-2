package ua.khpi.oop.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void createClientSuccess() {
        Client client = new Client("C-1", "Іван Кобєлєв");

        assertEquals("C-1", client.getClientId());
        assertEquals("Іван Кобєлєв", client.getFullName());
    }

    @Test
    void createClientWithNullIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Client(null, "Іван")
        );
    }

    @Test
    void createClientWithBlankNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Client("C-1", " ")
        );
    }
}