package ru.job4j.list.linked;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *Class SimpleLinkedList контейнер на базе связанного списка.
 *@author Chupin Pavel
 *@since 25.07.2021
 */


public class SimpleLinkedList<E> implements List<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    @Override
    public void add(E value) {
        if (last == null) {
            first = new Node<>(null, value, null);
            last = first;
        } else {
            final Node<E> temp = new Node<>(last, value, null);
            last.next = temp;
            last = temp;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Iterator<E> it = this.iterator();
        int count = 0;
        E temp =  it.next();
        while (count < index) {
            temp = it.next();
            count++;
        }
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedIterator();
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    public class SimpleLinkedIterator implements Iterator<E> {
        private Node<E> temp = first;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            E value = temp.item;
            temp = temp.next;
            return value;
        }
    }
}