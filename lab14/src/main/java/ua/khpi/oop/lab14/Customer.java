package ua.khpi.oop.lab14;

import java.util.Objects;

public class Customer {
    private final String id;
    private final String name;
    private final String phone;

    public Customer(String id, String name, String phone) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Customer id cannot be empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer customer)) return false;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + " (" + phone + ")";
    }
}