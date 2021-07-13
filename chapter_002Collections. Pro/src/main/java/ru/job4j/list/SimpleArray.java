package ru.job4j.list;

import java.util.*;

/**
 *Class SimpleArray динамический список на массиве.
 *@author Chupin Pavel
 *@since 12.07.2021
 */

public class SimpleArray<T> implements Iterable<T> {

    private Object[] arrays = new Object[10];
    private int size = 0;
    private int modCount = 0;

    public void add(T model) {
        if (size == arrays.length) {
            arrays = grow();
        }
        arrays[size++] = model;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) arrays[index];
    }

    public int size() {
        return this.size;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        arrays[index] = model;
        modCount++;
    }


    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(arrays, index + 1, arrays, index, size - index - 1);
        arrays[size - 1] = null;
        size--;
        modCount++;
    }

    private Object[] grow() {
        return Arrays.copyOf(arrays, arrays.length * 2);
    }

    public Object[] getArrays() {
        return arrays;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) arrays[point++];
            }
        };
        return it;
    }

}
