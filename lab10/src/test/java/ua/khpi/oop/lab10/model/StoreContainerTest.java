package ua.khpi.oop.lab10.model;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StoreContainerTest {

    @Test
    void shouldBeEmptyAfterCreation() {
        StoreContainer<String> container = new StoreContainer<>();

        assertTrue(container.isEmpty());
        assertEquals(0, container.size());
        assertEquals(10, container.capacity());
    }

    @Test
    void shouldAddAndGetItems() {
        StoreContainer<String> container = new StoreContainer<>();

        container.add("First");
        container.add("Second");

        assertFalse(container.isEmpty());
        assertEquals(2, container.size());
        assertEquals("First", container.get(0));
        assertEquals("Second", container.get(1));
    }

    @Test
    void shouldRemoveItemAndShiftElements() {
        StoreContainer<String> container = new StoreContainer<>();

        container.add("First");
        container.add("Second");
        container.add("Third");

        String removed = container.remove(1);

        assertEquals("Second", removed);
        assertEquals(2, container.size());
        assertEquals("First", container.get(0));
        assertEquals("Third", container.get(1));
    }

    @Test
    void shouldThrowExceptionForInvalidIndex() {
        StoreContainer<String> container = new StoreContainer<>();
        container.add("Item");

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(2));
    }

    @Test
    void shouldGrowWhenCapacityIsFull() {
        StoreContainer<Integer> container = new StoreContainer<>(2);

        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals(3, container.size());
        assertEquals(4, container.capacity());
    }

    @Test
    void shouldIterateWithIterator() {
        StoreContainer<String> container = new StoreContainer<>();

        container.add("A");
        container.add("B");
        container.add("C");

        Iterator<String> iterator = container.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldThrowExceptionWhenIteratorHasNoMoreElements() {
        StoreContainer<String> container = new StoreContainer<>();
        Iterator<String> iterator = container.iterator();

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void shouldIterateWithForEach() {
        StoreContainer<String> container = new StoreContainer<>();

        container.add("A");
        container.add("B");
        container.add("C");

        int count = 0;

        for (String item : container) {
            assertNotNull(item);
            count++;
        }

        assertEquals(3, count);
    }

    @Test
    void shouldWorkWithCartItems() {
        StoreContainer<CartItem> container = new StoreContainer<>();

        Product product = new Product("Mouse", 700.0);
        CartItem item = new CartItem(product, 2);

        container.add(item);

        assertEquals(1, container.size());
        assertEquals(item, container.get(0));
    }

    @Test
    void shouldThrowExceptionForNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new StoreContainer<>(-1));
    }
}