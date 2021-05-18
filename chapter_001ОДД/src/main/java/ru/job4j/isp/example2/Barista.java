package ru.job4j.isp.example2;

public class Barista {
    private final Coffee coffee;
    private final Tea tea;
    private final HotChocolate hotChocolate;


    public Barista(Coffee coffee, Tea tea, HotChocolate hotChocolate) {
        this.coffee = coffee;
        this.tea = tea;
        this.hotChocolate = hotChocolate;
    }

    public void makeCoffee() {
        coffee.makeCoffee();
    }

    public void makeTea() {
        coffee.makeCoffee();
    }

    public void makeChocolate() {
        coffee.makeCoffee();
    }

}
