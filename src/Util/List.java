package Util;

import java.util.ArrayList;
import java.util.function.Predicate;

public class List<T> {
    private ArrayList<T> data;
    private int count = 0;

    public List() {
        this.data = new ArrayList<>();
    }

    public boolean remove(int pos) {
        if (pos < 0 || pos >= count) {
            return false;
        }
        data.remove(pos);
        count--;
        return true;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public T getData(int pos) {
        if (pos < 0 || pos >= count) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return data.get(pos);
    }

    public int getIndex(Predicate<T> func) {
        for (int i = 0; i < getSize(); i++) {
            if (func.test(data.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return this.count;
    }

    public void add(T element) {
        data.add(element);
        count++;
    }
}
