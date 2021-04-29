package ru.job4j.isp.example2;

public class CoffeeMachine implements  Coffee {
    @Override
    public void makeCoffee() {
        System.out.println("Кофе готов!");
    }
}
