package Util;

public class Queue<T> {
    private Object[] data;
    private int base = 0, top = 0, size = 5;

    public Queue() {
        data = new Object[size];
    }

    public void add(T item) {
        if (top >= size) {
            resize();
        }
        data[top++] = item;
    }

    public void addRange(T[] items) {
        while (top + items.length > size) {
            resize();
        }
        System.arraycopy(items, 0, data, top, items.length);
        top += items.length;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T temp = (T) data[base];
        return temp;
    }

    public void clear() {
        data = new Object[size];
        base = top = 0;
    }

    public boolean isEmpty() {
        return base == top;
    }

    public int currentSize() {
        return top - base;
    }

    private void resize() {
        size *= 2;
        Object[] newData = new Object[size];
        System.arraycopy(data, base, newData, 0, top - base);
        top -= base;
        base = 0;
        data = newData;
    }

    @Override
    public String toString() {
        return currentSize() + " elements";
    }
}
