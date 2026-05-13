package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab10.model.CartItem;
import ua.khpi.oop.lab10.model.Product;
import ua.khpi.oop.lab10.model.StoreContainer;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        StoreContainer<CartItem> cart = new StoreContainer<>();

        Product laptop = new Product("Laptop", 35000.0);
        Product mouse = new Product("Mouse", 700.0);
        Product keyboard = new Product("Keyboard", 1500.0);

        cart.add(new CartItem(laptop, 1));
        cart.add(new CartItem(mouse, 2));
        cart.add(new CartItem(keyboard, 1));

        System.out.println("Cart size: " + cart.size());
        System.out.println("Cart capacity: " + cart.capacity());

        System.out.println("\nAccess by index:");
        System.out.println(cart.get(0));
        System.out.println(cart.get(1));

        System.out.println("\nIteration with iterator:");
        Iterator<CartItem> iterator = cart.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }

        System.out.println("\nIteration with for-each:");
        for (CartItem item : cart) {
            System.out.println("- " + item);
        }

        System.out.println("\nRemoving item at index 1:");
        CartItem removedItem = cart.remove(1);
        System.out.println("Removed: " + removedItem);

        System.out.println("\nCart after removal:");
        for (CartItem item : cart) {
            System.out.println("- " + item);
        }

        System.out.println("\nGeneric container with String:");
        StoreContainer<String> messages = new StoreContainer<>();
        messages.add("First message");
        messages.add("Second message");

        for (String message : messages) {
            System.out.println("- " + message);
        }
    }
}