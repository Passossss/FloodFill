package Util;

public class List<T> {
    private T[] data;
    private int size;
    private int count = 0;

    public boolean isEmpty() {
        return this.count == 0;
    }


}
