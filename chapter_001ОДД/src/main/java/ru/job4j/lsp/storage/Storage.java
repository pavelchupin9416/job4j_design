package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Storage класс для хранения продуктов.
 *@author chupin
 *@since 10.08.2020
 */

public interface Storage {

    public void add(Food food);

    public Food get(int index);

    public List<Food> getFoods();

    public void clear();

    boolean accept(Food food);
}
