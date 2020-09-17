package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

/**
 *Class Shop класс для хранения продуктов в магазине.
 *@author chupin
 *@since 10.08.2020
 */
public class Shop implements Storage {
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
    public boolean accept(Food food) {
        boolean bool = false;
        double shelLife = food.shellLife();
        if (0.25 <= shelLife & shelLife <= 0.75) {
            bool = true;
        } else if (shelLife > 0.75 & shelLife < 1) {
            food.setDiscount(20);
            bool = true;
        }
        return bool;
    }
}
