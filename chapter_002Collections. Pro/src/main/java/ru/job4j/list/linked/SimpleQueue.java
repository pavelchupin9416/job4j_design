package ru.job4j.list.linked;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T result = null;
        try {
            T value = out.pop();
            result = value;
        }  catch (NoSuchElementException e) {
            try {T temp = in.pop();
                while (true) {
                    out.push(temp);
                    temp = in.pop();
                }
            } catch (NoSuchElementException r) {
                result = out.pop();
            }
        }
        return result;
    }

    public void push(T value) {
        in.push(value);
    }
}
