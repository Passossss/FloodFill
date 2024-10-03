package Aula;

public class DynamicStack<T> {
    private Object[] stack;
    private int top;
    private int capacity;

    public DynamicStack() {
        this.capacity = 10;
        this.stack = new Object[capacity];
        this.top = 0;
    }

    public void push(T item) {
        if (top >= capacity) {
            resize();
        }
        stack[top++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) stack[--top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void resize() {
        capacity *= 2;
        Object[] newStack = new Object[capacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
}
