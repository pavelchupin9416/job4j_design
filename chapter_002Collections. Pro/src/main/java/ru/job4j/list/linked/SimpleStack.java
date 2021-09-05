package ru.job4j.list.linked;

/**
 *Class SimpleStack контейнер Stack.
 *@author Chupin Pavel
 *@since 10.08.2021
 */

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();
    int count = 0;

    public T pop() {
        count--;
        return linked.deleteFirst();
    }

    public boolean empty() {
        return count == 0 ? true : false;
    }

    public void push(T value) {
        linked.addFirst(value);
        count++;
    }
}
