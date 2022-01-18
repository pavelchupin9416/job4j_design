package ru.job4j.set;

import ru.job4j.list.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

/**
 *Class SimpleSet коллекция set на массиве.
 *@author Chupin Pavel
 *@since 16.12.2021
 */

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    @Override
    public boolean add(T value) {
        boolean result = !contains(value);
        if (result) {
            set.add(value);
        }
        return  result;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T element: set) {
            if (Objects.equals(value, element)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

}
