package ua.khpi.oop.lab09.demo;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MainTest {

    @Test
    void shouldFindBestInteger() {
        List<Integer> scores = List.of(1200, 2500, 1800, 3100);

        assertEquals(3100, Main.findBest(scores));
    }

    @Test
    void shouldFindBestString() {
        List<String> ranks = List.of("Bronze", "Silver", "Gold", "Platinum");

        assertEquals("Silver", Main.findBest(ranks));
    }

    @Test
    void shouldReturnNullForEmptyList() {
        List<Integer> empty = Collections.emptyList();

        assertNull(Main.findBest(empty));
    }

    @Test
    void shouldReturnNullForNullList() {
        List<Integer> nullList = null;

        assertNull(Main.findBest(nullList));
    }
}