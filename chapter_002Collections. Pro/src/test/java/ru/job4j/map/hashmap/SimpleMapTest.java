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
        assertThat(map.get(0), is("first"));
    }

    @Test
    public void whenGetMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertNull(map.get(0));
    }

    @Test
    public void whenGetMapSameIndex() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        assertThat(map.put(0, "first"), is(true));
        assertNull(map.get(56));
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
    public void whenExpend() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(70, "first");
        map.put(71,"second");
        map.put(72,"2");
        map.put(73,"3");
        map.put(74,"4");
        map.put(75,"5");
        map.put(76,"6");
        map.put(77,"7");
        map.put(78,"8");
        map.put(79,"9");
        assertThat(map.get(70), is("first"));
        assertThat(map.get(79), is("9"));
    }

    @Test
    public void whenRemoveMapFalse() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "first");
        map.put(1,"second");
        assertThat(map.remove(3),is(false));
    }

    @Test
    public void whenRemoveMapFalse2() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "first");
        map.put(1,"second");
        assertThat(map.remove(56),is(false));
    }
}
