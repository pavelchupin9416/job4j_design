package ru.job4j.map.hashmap;

import org.junit.Test;
import ru.job4j.list.ListUtils;
import ru.job4j.list.SimpleArray;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {

    @Test
    public void whenPutMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertThat(map.put(0, "first"), is(true));
        assertThat(map.get(0), is("first"));
    }

    @Test
    public void whenPutMapFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertThat(map.put(0, "first"), is(true));
        assertThat(map.put(0, "two"), is(false));
    }

    @Test
    public void whenGetMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertNull(map.get(0));
    }

    @Test()
    public void whenGetOutBound() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "first");
        assertNull(map.get(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "first");
        Iterator<Integer> it = map.iterator();
        map.put(2, "two");
        it.next();
    }

    @Test
    public void whenRemoveMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "first");
        map.put(1,"second");
        assertThat(map.remove(0),is(true));
        assertNull(map.get(0));
    }

    @Test
    public void whenRemoveMapFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "first");
        map.put(1,"second");
        assertThat(map.remove(3),is(false));
    }
}
