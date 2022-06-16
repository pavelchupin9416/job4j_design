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
        } else {
        table[index] = map;
        count++;
        modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        int h = hashCode;
        return (h)^(h>>>16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        SimpleMap<K, V> mapNew = new SimpleMap<>();
        mapNew.capacity=capacity * 2;
        mapNew.table = new MapEntry[mapNew.capacity];
        Iterator<K> it = iterator();
        while (it.hasNext()) {
            K key = it.next();
            mapNew.put(key, get(key));
        }
        table = mapNew.table;
        capacity = capacity * 2;
    }



    @Override
    public V get(K key) {
        V result = null;
        if (count != 0) {
            int h = hash(key.hashCode());
            int index = indexFor(h);
            if(table[index] != null){
                if (table[index].key.equals(key)) {
                result = table[index].value;
                }
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (count != 0) {
            int hash = hash(key.hashCode());
            int index = indexFor(hash);
            if (table[index] != null) {
            table[index] = null;
            modCount++;
            result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = point; i < table.length; i++) {
                    if (table[i] != null) {
                        point = i;
                        result = true;
                    }
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
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