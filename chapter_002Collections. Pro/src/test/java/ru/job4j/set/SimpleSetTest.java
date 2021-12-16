package ru.job4j.set;

import org.junit.Test;
import ru.job4j.list.SimpleArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddThenIt() {
        Set<Integer> set = new SimpleSet<>();
        set.add(2);
        int rsl = set.iterator().next();
        assertThat(rsl, is(2));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        Set<Integer> set = new SimpleSet<>();
        set.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Set<Integer> set = new SimpleSet<>();
        set.add(3);
        Iterator<Integer> it =  set.iterator();
        set.add(4);
        it.next();
    }

}