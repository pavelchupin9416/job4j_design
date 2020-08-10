package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Warehouse класс для хранения продуктов на складе.
 *@author chupin
 *@since 10.08.2020
 */
public class Warehouse extends Storage {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        double shelLife = food.shellLife();
        if (shelLife < 0.25) {
        foods.add(food);
        }
    }

    @Override
    public Food get(int index) {
        return foods.get(index);
    }
}
