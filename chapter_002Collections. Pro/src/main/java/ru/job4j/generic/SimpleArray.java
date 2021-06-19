package ru.job4j.generic;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

/**
 *Class SimpleArray реалтзации обертки над массивом.
 *@author Chupin Pavel
 *@since 19.06.2021
 */

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int ind = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * Метод добавляет элемент в массив.
     * @param model добавляемы объект.
     */
    public void add(T model) throws IndexOutOfBoundsException {
        array[ind++] = model;
    }

    /**
     * Метод заменяет элемент в массив.
     * @param model заменяемый объект.
     * @param index номер элмента.
     */
    public void set(int index, T model) throws IndexOutOfBoundsException {
        checkIndex(index, ind);
        array[index] = model;
    }


    /**
     * Метод находит элемент в массив.
     * @param index номер элмента.
     */
    public T get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, ind);
        return (T) array[index];
    }

    /**
     * Метод удаляет элемент в массив.
     * @param index номер элмента.
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, ind);
        System.arraycopy(array, index + 1, array, index,
                array.length - index - 1);
        array[--this.ind] = null;
    }


    /**
     * Метод создает итератор массива.
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < ind && array[currentIndex] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

