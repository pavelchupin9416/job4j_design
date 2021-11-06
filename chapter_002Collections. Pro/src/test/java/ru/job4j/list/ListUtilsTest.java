package ru.job4j.list;

import org.hamcrest.core.Is;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 1, 4, 2));
        ListUtils.removeIf(input, x -> x > 3);
        assertThat(input, is(Arrays.asList(1, 2)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 1, 4, 2));
        ListUtils.replaceIf(input, x -> x > 3, 3);
        assertThat(input, is(Arrays.asList(3, 1, 3, 2)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 7, 1, 4, 6, 3, 5, 1, 9, 2, 6));
        List<Integer> remove = new ArrayList<>(Arrays.asList(5, 1, 4, 2));
        ListUtils.removeAll(input, remove);
        assertThat(input, is(Arrays.asList(7, 6, 3, 9, 6)));
    }


}