package ru.job4j.isp.example2;

public class CoffeeAutomate implements  Coffee, HotChocolate, Tea {
    @Override
    public void makeCoffee() {
        System.out.println("Кофе готов!");
    }

    @Override
    public void makeChocolate() {
        System.out.println("Горячий шоколад готов!");
    }

    @Override
    public void makeTea() {
        System.out.println("Чай заварен!");
    }
}
