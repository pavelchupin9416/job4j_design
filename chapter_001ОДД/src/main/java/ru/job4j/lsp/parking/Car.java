package ru.job4j.lsp.parking;

/**
 *Class Car класс описывает легковой автомобиль.
 *@author chupin
 *@since 20.08.2020
 */

public class Car implements Transport {

    private String number;

    public Car(String number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return 1;
    }

}
