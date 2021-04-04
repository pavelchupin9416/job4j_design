package ru.job4j.lsp.parking;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingTest {
    @Test
    public void park() {
        Car car = new Car("фк345а");
        Truck truck = new Truck("ар435о", 2);
        Parking parking = new Parking(5, 1);
        parking.park(car);
        parking.park(truck);
        List<Transport> vehicles = new ArrayList<>();
        vehicles.add(car);
        assertThat(vehicles, is(parking.getTransports()));
    }

    @Test
    public void park2() {
        Car car = new Car("фк345а");
        Truck truck = new Truck("ар455о", 20);
        Truck truck2 = new Truck("ар435о", 2);
        Parking parking = new Parking(5, 1);
        parking.park(car);
        parking.park(truck2);
        Boolean result = parking.park(truck);
        assertThat(result, is(false));
    }

    @Test
    public void leave() {
        Car car = new Car("фк345а");
        Car car2 = new Car("ар435о");
        Parking parking = new Parking(5, 1);
        parking.park(car);
        parking.park(car2);
        parking.leave(car2);
        List<Transport> vehicles = new ArrayList<>();
        vehicles.add(car);
        assertThat(vehicles, is(parking.getTransports()));
    }

    @Test
    public void leaveTruck() {
        Truck truck = new Truck("ар455о", 20);
        Truck truck2 = new Truck("ар435о", 2);
        Truck truck3 = new Truck("ар895о", 2);
        Parking parking = new Parking(5, 2);
        boolean t1 = parking.park(truck);
        boolean t2 =  parking.park(truck2);
        boolean t3 = parking.park(truck3);
        boolean t4 =  parking.leave(truck2);
        List<Transport> vehicles = new ArrayList<>();
        vehicles.add(truck);
        assertThat(vehicles, is(parking.getTransportsTruck()));
    }
}
