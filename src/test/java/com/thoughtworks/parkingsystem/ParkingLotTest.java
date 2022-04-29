package com.thoughtworks.parkingsystem;

import com.thoughtworks.exceptions.AlreadyParkedException;
import com.thoughtworks.exceptions.ParkingLotFullException;
import com.thoughtworks.exceptions.VehicleNotParkedException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {
    @Test
    void shouldBeAbleToParkWhenAllParkingSlotsAreFree() throws ParkingLotFullException, AlreadyParkedException, InterruptedException {
        ParkingLot parkingSystem = new ParkingLot(10);
        Car car = new Car();

        parkingSystem.park(car);
        boolean isParked = parkingSystem.isParked(car);

        Thread.sleep(3000);
        assertThat(isParked, is(equalTo(true)));
    }

    @Test
    void shouldNotBeAbleToParkWhenNoParkingSlotsAreFree() throws ParkingLotFullException, AlreadyParkedException, InterruptedException {
        ParkingLot parkingSystem = new ParkingLot(1);

        parkingSystem.park(new Car());

        Thread.sleep(3000);
        assertThrows(ParkingLotFullException.class, () -> parkingSystem.park(new Car()));
    }

    @Test
    void shouldNotBeAbleToParkWhenTheSameCarIsParkAgain() throws ParkingLotFullException, AlreadyParkedException, InterruptedException {
        ParkingLot parkingSystem = new ParkingLot(5);
        Car car = new Car();

        parkingSystem.park(car);

        Thread.sleep(3000);
        assertThrows(AlreadyParkedException.class, () -> parkingSystem.park(car));
    }

    @Test
    void shouldBeAbleToUnParkCarWhenCarIsParked() throws ParkingLotFullException, AlreadyParkedException, VehicleNotParkedException, InterruptedException {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        parkingLot.park(car);

        parkingLot.unPark(car);

        Thread.sleep(3000);
        boolean isParked = parkingLot.isParked(car);
        assertThat(isParked, is(equalTo(false)));
    }

    @Test
    void shouldNotBeAbleUnParkWhenCarNotAlreadyParked() throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        Thread.sleep(3000);
        assertThrows(VehicleNotParkedException.class, () -> parkingLot.unPark(car));
    }
}
