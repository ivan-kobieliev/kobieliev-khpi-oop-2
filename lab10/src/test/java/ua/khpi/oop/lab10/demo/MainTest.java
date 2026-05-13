package ua.khpi.oop.lab10.demo;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab10.model.CartItem;
import ua.khpi.oop.lab10.model.Product;
import ua.khpi.oop.lab10.model.StoreContainer;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldSupportBasicCartOperations() {
        StoreContainer<CartItem> cart = new StoreContainer<>();

        Product laptop = new Product("Laptop", 35000.0);
        Product mouse = new Product("Mouse", 700.0);

        CartItem firstItem = new CartItem(laptop, 1);
        CartItem secondItem = new CartItem(mouse, 2);

        cart.add(firstItem);
        cart.add(secondItem);

        assertEquals(2, cart.size());
        assertFalse(cart.isEmpty());
        assertEquals(firstItem, cart.get(0));
        assertEquals(secondItem, cart.get(1));

        CartItem removed = cart.remove(0);

        assertEquals(firstItem, removed);
        assertEquals(1, cart.size());
        assertEquals(secondItem, cart.get(0));
    }

    @Test
    void shouldSupportGenericUsageWithDifferentTypes() {
        StoreContainer<String> messages = new StoreContainer<>();
        messages.add("First message");
        messages.add("Second message");

        assertEquals(2, messages.size());
        assertEquals("First message", messages.get(0));
        assertEquals("Second message", messages.get(1));

        StoreContainer<Integer> numbers = new StoreContainer<>();
        numbers.add(10);
        numbers.add(20);

        assertEquals(2, numbers.size());
        assertEquals(10, numbers.get(0));
        assertEquals(20, numbers.get(1));
    }
}