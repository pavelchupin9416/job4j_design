package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;
/**
 *Class ParkingCar класс отвечает за парковку легковых автомобилей.
 *@author chupin
 *@since 20.08.2020
 */
public class ParkingCar implements Parking {

    List<Transport> transports = new ArrayList<>();

    @Override
    public void park(Transport transport) {

    }

    @Override
    public void leave(Transport transport) {

    }
}
