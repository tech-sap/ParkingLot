package com.thoughtworks.parkingsystem;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ParkingLotTest {
    @Test
    void shouldBeAbleToParkWhenAllParkingSlotsAreFree() {
        ParkingLot parkingSystem = new ParkingLot(10);

        boolean isParked = parkingSystem.park(new Car());

        assertThat(isParked, is(equalTo(true)));
    }

    @Test
    void shouldNotBeAbleToParkWhenNoParkingSlotsAreFree() {
        ParkingLot parkingSystem = new ParkingLot(1);

        boolean isParkedOne = parkingSystem.park(new Car());
        boolean isParkedTwo = parkingSystem.park(new Car());

        assertThat(isParkedTwo, is(equalTo(false)));
    }

    @Test
    void shouldNotBeAbleToParkWhenTheSameCarIsParkAgain() {
        ParkingLot parkingSystem = new ParkingLot(5);

        Car car = new Car();

        boolean isParked = parkingSystem.park(car);
        isParked = parkingSystem.park(car);

        assertThat(isParked, is(equalTo(false)));
    }
}
