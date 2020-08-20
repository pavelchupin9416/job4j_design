package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

/**
 *Class ParkingTruck класс отвечает за парковку грузовых автомобилей.
 *@author chupin
 *@since 20.08.2020
 */

public class ParkingTruck implements Parking {

    List<Transport> transports = new ArrayList<>();

    @Override
    public void park(Transport transport) {

    }

    @Override
    public void leave(Transport transport) {

    }
}
