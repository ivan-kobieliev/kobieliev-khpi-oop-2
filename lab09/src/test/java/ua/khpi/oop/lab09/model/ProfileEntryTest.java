package ua.khpi.oop.lab09.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileEntryTest {

    @Test
    void shouldCreateEntryWithStringAndInteger() {
        ProfileEntry<String, Integer> entry = new ProfileEntry<>("Score", 100);

        assertEquals("Score", entry.getEntity());
        assertEquals(100, entry.getMetadata());
    }

    @Test
    void shouldCreateEntryWithPlayer() {
        Player player = new Player("Shadow", 25);
        ProfileEntry<Player, String> entry = new ProfileEntry<>(player, "Active profile");

        assertEquals(player, entry.getEntity());
        assertEquals("Active profile", entry.getMetadata());
    }

    @Test
    void shouldReturnCorrectString() {
        ProfileEntry<String, Integer> entry = new ProfileEntry<>("Level", 10);

        assertEquals("ProfileEntry{entity=Level, metadata=10}", entry.toString());
    }
}