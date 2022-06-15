package ru.job4j.map.hashmap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *Class SimpleMap собственная структура данных - HashMap.
 *@author Chupin Pavel
 *@since 15.06.2022
 */


public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = true;
        if (count > capacity * LOAD_FACTOR) {
            expand();
        }
        int h=hash(key.hashCode());
        int index = indexFor(h);
        MapEntry<K, V> map = new MapEntry<>(key, value);
        if (table[index] != null) {
            result = false;
        }
        table[index] = map;
        count++;
        modCount++;
        return result;
    }

    private int hash(int hashCode) {
        int h = hashCode;
        return (h)^(h>>16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {

    }

    @Override
    public V get(K key) {
        if (count != 0) {
            int h = hash(key.hashCode());
            int index = indexFor(h);
            if(table[index] != null){
            return table[index].value;}
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (count != 0) {
            int hash = hash(key.hashCode());
            int index = indexFor(hash);
            if (table[index] != null) {
            table[index] = null;
            modCount++;
            return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            private int point = 0;
            private final MapEntry<K, V>[] data = table;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = point; i < data.length; i++) {
                    if (data[i] != null) {
                        point = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}