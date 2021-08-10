package ru.job4j.list.linked;

/**
 *Class SimpleStack контейнер Stack.
 *@author Chupin Pavel
 *@since 10.08.2021
 */

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
