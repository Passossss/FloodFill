package Aula;

import java.util.NoSuchElementException;

public abstract class Stack<T> {
    private int count = 0;
    protected T[] data;

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = data[--count];
        data[count] = null;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int currentSize() {
        return count;
    }
}
