package Util;

public class StaticQueue<T> {
    private final int size;
    private Object[] data; // Uso de Object[] para evitar problemas com genéricos
    private int top = 0, base = 0;

    public StaticQueue(int size) {
        this.size = size;
        this.data = new Object[this.size]; // Criação do array de Object
    }

    public void add(T item) {
        if (isFull()) {
            throw new StackOverflowError("StaticQueue is full");
        }
        this.data[this.top] = item;
        this.top++;
    }

    public void addRange(T[] items) {
        int topAfterPushRange = items.length + top;
        if (topAfterPushRange > size) {
            throw new StackOverflowError("StaticQueue will overflow");
        }
        System.arraycopy(items, 0, data, top, items.length);
        top = topAfterPushRange;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) data[base]; // Cast explícito
        base++;
        return item;
    }

    public void clear() {
        this.data = new Object[this.size]; // Criação de um novo array de Object
        this.top = 0;
        this.base = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return this.top >= this.size;
    }

    public boolean isEmpty() {
        return this.top == this.base;
    }

    public int currentSize() {
        return this.top - this.base;
    }
}