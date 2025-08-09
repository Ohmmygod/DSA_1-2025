package Lab05.pack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack_670764java<T> {   // extends ArrayList<T> {
                            // extends would expose MyStack object for calling any of the ArrayList's methods
    private ArrayList<T> items = new ArrayList<>();

    public void push(T d) {
        items.add(d);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = size() - 1; i > 0; i--)
            sb.append(items.get(i) + ", "); 
        if (items.size() > 0)
            sb.append(items.get(0));
        sb.append("]");
        return sb.toString();
    }
}
