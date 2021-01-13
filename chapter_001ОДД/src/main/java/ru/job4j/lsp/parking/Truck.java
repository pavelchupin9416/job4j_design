package ru.job4j.lsp.parking;

/**
 *Class Truck класс описывает грузовой автомобиль.
 *@author chupin
 *@since 20.08.2020
 */

public class Truck implements Transport {

    private String number;
    private int size;

    public Truck(String number, int size) {
        this.number = number;
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean IsTruck() {
        return true;
    }
}
