package ru.job4j.lsp.parking;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingTest {
    @Test
    public void park() throws Exception {
        Car car = new Car("фк345а");
        Truck truck = new Truck("ар435о", 2);
        Parking parking = new Parking(5, 1);
        parking.park(car);
        parking.park(truck);
        List<Transport> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);
        assertThat(vehicles, is(parking.transports));
    }

    @Test (expected = Exception.class)
    public void park2() throws Exception {
        Car car = new Car("фк345а");
        Truck truck = new Truck("ар455о", 20);
        Truck truck2 = new Truck("ар435о", 2);
        Parking parking = new Parking(5, 1);
        parking.park(car);
        parking.park(truck2);
        parking.park(truck);
    }

    @Test
    public void leave() throws Exception {
        Car car = new Car("фк345а");
        Truck truck = new Truck("ар435о", 2);
        Parking parking = new Parking(5, 1);
        parking.park(car);
        parking.park(truck);
        parking.leave(truck);
        List<Transport> vehicles = new ArrayList<>();
        vehicles.add(car);
        assertThat(vehicles, is(parking.transports));
    }
}
