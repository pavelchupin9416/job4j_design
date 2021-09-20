package ru.job4j.list.linked;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int inCount = 0;
    int outCount = 0;

    public T poll() {
        if (in.empty() & out.empty()) {
            throw new NoSuchElementException();
        }
        T result = null;
        if (!out.empty()) {
            result = out.pop();
            outCount--;
        } else if (!in.empty()) {
            while (!in.empty()) {
                T temp = in.pop();
                out.push(temp);
                inCount--;
                outCount++;
            }
            result = out.pop();
            outCount--;
        }
        return result;
    }

    public void push(T value) {
        in.push(value);
        inCount++;
    }
}
