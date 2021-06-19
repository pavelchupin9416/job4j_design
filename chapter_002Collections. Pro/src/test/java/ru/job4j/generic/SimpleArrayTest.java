package ru.job4j.generic;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class SimpleArrayTest {

    /**
     * Тест добавления элемента.
     */
    @Test
    public void addElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("first");
        simpleArray.add("second");
        assertThat(simpleArray.get(0), is("first"));
        assertThat(simpleArray.get(1), is("second"));
    }



    /**
     * Тест замены элемента.
     */
    @Test
    public void setElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.set(1, 5);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(5));
    }

    /**
     * Тест удаления элемента.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.remove(2);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), null);
        simpleArray.add(25);
        assertThat(simpleArray.get(2), is(25));
    }

    /**
     * Тест получения ошибки выхода за границы массива.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOfBounds() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }
    /**
     * Тестирование итератора.
     */
    @Test
    public void complexIteratorTest() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        Iterator<Integer> iterator = simpleArray.iterator();
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
    }

    /**
     * Тест итератора с исключением.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorExeption() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        Iterator<String> iterator = simpleArray.iterator();
        simpleArray.add("first");
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("first"));
        assertThat(iterator.next(), is("second"));
    }
}
