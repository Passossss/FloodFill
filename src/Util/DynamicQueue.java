package Util;

public class DynamicQueue<T> extends Queue<T> {
    private int currentSize = 5;
    private Object[] data;
    private int top = 0, base = 0;

    public DynamicQueue() {
        this.data = new Object[currentSize];
    }

    @Override
    public void add(T item) {
        if (top >= currentSize) {
            resize();
        }
        data[top++] = item;
    }

    @Override
    public void addRange(T[] items) {
        while (top + items.length > currentSize) {
            resize();
        }
        System.arraycopy(items, 0, data, top, items.length);
        top += items.length;
    }

    @Override
    public void clear() {
        currentSize = 5;
        data = new Object[currentSize];
        top = base = 0;
    }

    private void resize() {
        currentSize *= 2;
        Object[] newData = new Object[currentSize];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public T get(int index) {
        if (index < 0 || index >= top) {
            throw new IndexOutOfBoundsException("Index inválido.");
        }
        return (T) data[index];
    }
}
