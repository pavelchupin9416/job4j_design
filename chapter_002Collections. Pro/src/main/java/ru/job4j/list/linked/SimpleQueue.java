package ru.job4j.list.linked;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int inCount = 0;
    int outCount = 0;

    public T poll() {
        T result = null;
        if(outCount > 0) {
            result = out.pop();
            outCount--;
        } else if (inCount > 0) {
            while (inCount > 0) {
                T temp = in.pop();
                out.push(temp);
                inCount--;
                outCount++;
            }
            result = out.pop();
            outCount--;
        }
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public void push(T value) {
        in.push(value);
        inCount++;
    }
}
