package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (column >= data[row].length & data.length > 1) {
            column = 0;
            row++;
            while (row < (data.length - 1) && column == data[row].length) {
                row++;
            }

        }
        if (row >= data.length | data[row].length == 0) {
            result = false;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}