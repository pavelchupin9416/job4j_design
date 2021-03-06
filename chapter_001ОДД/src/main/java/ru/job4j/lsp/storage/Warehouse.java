package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Warehouse класс для хранения продуктов на складе.
 *@author chupin
 *@since 10.08.2020
 */
public class Warehouse implements Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public Food get(int index) {
        return foods.get(index);
    }

    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public void clear() {
        foods.clear();
    }

    @Override
    public boolean accept(Food food) {
        boolean bool = false;
        double shelLife = food.shellLife();
        if (shelLife < 0.25) {
            bool = true;
        }
        return bool;
    }
}
