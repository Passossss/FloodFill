package Util;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<T> {
    private ArrayList<T> data;
    private int base = 0;

    public Queue() {
        data = new ArrayList<>();
    }

    public void add(T item) {
        data.add(item);
    }

    public void addRange(T[] items) {
        for (T item : items) {
            add(item);
        }
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T temp = data.get(base);
        base++; // Avança o índice da base
        return temp;
    }

    public void clear() {
        data.clear();
        base = 0;
    }

    public boolean isEmpty() {
        return base >= data.size();
    }

    public int currentSize() {
        return data.size() - base;
    }

    @Override
    public String toString() {
        return currentSize() + " elements";
    }
}
