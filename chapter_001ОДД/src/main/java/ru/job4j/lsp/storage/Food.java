package ru.job4j.lsp.storage;

import java.util.Date;
import java.util.Objects;

/**
 *Class Food класс для описания продукта.
 *@author chupin
 *@since 10.08.2020
 */

public class Food {
    private String name;
    private Date expaireDate;
    private Date createDate;
    private double price;
    private int discount;

    public Food(String name, Date expaireDate, Date createDate, int price, int discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double shellLife() {
        Double shellLife;
        int totalDays = (int) (this.expaireDate.getTime() - this.createDate.getTime()) / (1000 * 60 * 60 * 24);
        int lastDays = (int) (new Date().getTime() - this.createDate.getTime()) / (1000 * 60 * 60 * 24);
        shellLife = (double) lastDays / totalDays;
        return shellLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 &&
                discount == food.discount &&
                Objects.equals(name, food.name) &&
                Objects.equals(expaireDate, food.expaireDate) &&
                Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expaireDate, createDate, price, discount);
    }
}

