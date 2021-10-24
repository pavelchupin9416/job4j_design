package ru.job4j.list.linked;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();


    public T poll() {
        if (in.empty() && out.empty()) {
            throw new NoSuchElementException();
        }
        T result = null;
       if (out.empty()) {
           while (!in.empty()) {
               T temp = in.pop();
               out.push(temp);
           }
       }
       result = out.pop();
        return result;
    }

    public void push(T value) {
        in.push(value);
    }
}
