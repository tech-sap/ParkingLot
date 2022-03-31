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
    void shouldBeAbleToParkWhenAllParkingSlotsAreFree() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingSystem = new ParkingLot(10);
        Car car = new Car();

        parkingSystem.park(car);
        boolean isParked = parkingSystem.isParked(car);

        assertThat(isParked, is(equalTo(true)));
    }

    @Test
    void shouldNotBeAbleToParkWhenNoParkingSlotsAreFree() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingSystem = new ParkingLot(1);

        parkingSystem.park(new Car());

        assertThrows(ParkingLotFullException.class, () -> parkingSystem.park(new Car()));
    }

    @Test
    void shouldNotBeAbleToParkWhenTheSameCarIsParkAgain() throws ParkingLotFullException, AlreadyParkedException {
        ParkingLot parkingSystem = new ParkingLot(5);
        Car car = new Car();

        parkingSystem.park(car);

        assertThrows(AlreadyParkedException.class, () -> parkingSystem.park(car));
    }

    @Test
    void shouldBeAbleToUnParkCarWhenCarIsParked() throws ParkingLotFullException, AlreadyParkedException, VehicleNotParkedException {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        parkingLot.park(car);

        parkingLot.unPark(car);

        boolean isParked = parkingLot.isParked(car);
        assertThat(isParked, is(equalTo(false)));
    }

    @Test
    void shouldNotBeAbleUnParkWhenCarNotAlreadyParked() {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        assertThrows(VehicleNotParkedException.class, () -> parkingLot.unPark(car));
    }
}
