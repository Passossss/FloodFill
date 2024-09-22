package Aula;

import java.util.NoSuchElementException;

public class DynamicStack<T> {
    private T[] data;
    private int count = 0;
    private int currentStackSize = 3;

    public DynamicStack() {
        this.data = (T[]) new Object[currentStackSize];
    }

    public int currentSize() {
        return count;
    }

    public void push(T item) {
        if (count >= currentStackSize) {
            resizeArray();
        }
        data[count++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = data[--count];
        data[count] = null;
        return item;
    }

    public void clear() {
        count = 0;
        currentStackSize = 3;
        data = (T[]) new Object[currentStackSize];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data[count - 1];
    }

    public void pushRange(T[] items) {
        if (items.length + count > currentStackSize) {
            resizeArray();
        }
        System.arraycopy(items, 0, data, count, items.length);
        count += items.length;
    }

    private void resizeArray() {
        currentStackSize *= 2;
        T[] newData = (T[]) new Object[currentStackSize];
        System.arraycopy(data, 0, newData, 0, count);
        data = newData;
    }
}
