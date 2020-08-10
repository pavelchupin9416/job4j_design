package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Trash класс для хранения продуктов просроченных продуктов.
 *@author chupin
 *@since 10.08.2020
 */
public class Trash extends Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        double shelLife = food.shellLife();
        if (shelLife >= 1) {
            foods.add(food);
        }
    }

    @Override
    public Food get(int index) {
        return foods.get(index);
    }
    }


