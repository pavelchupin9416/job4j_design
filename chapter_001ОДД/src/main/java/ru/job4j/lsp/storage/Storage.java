package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Storage класс для хранения продуктов.
 *@author chupin
 *@since 10.08.2020
 */

public class Storage {

    private List<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public Food get(int index) {
        return foods.get(index);
    }
}
