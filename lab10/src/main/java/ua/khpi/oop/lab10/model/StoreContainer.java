package ua.khpi.oop.lab10.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StoreContainer<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 2;

    private T[] items;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public StoreContainer() {
        this.capacity = DEFAULT_CAPACITY;
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public StoreContainer(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }

        this.capacity = initialCapacity;
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T item) {
        if (size == capacity) {
            grow();
        }

        items[size++] = item;
    }

    public T get(int index) {
        checkIndex(index);

        return items[index];
    }

    public T remove(int index) {
        checkIndex(index);

        T removedItem = items[index];

        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        items[--size] = null;

        return removedItem;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        capacity *= GROWTH_FACTOR;

        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newItems, 0, size);

        items = newItems;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StoreContainerIterator();
    }

    private class StoreContainerIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in container");
            }

            return items[currentIndex++];
        }
    }
}