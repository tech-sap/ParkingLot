package com.thoughtworks.parkingsystem;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ParkingSystemTest {
    @Test
    void shouldReturnParkedWhenAllParkingSlotsAreFree() {
        ParkingSystem parkingSystem = new ParkingSystem(10);

        boolean isParked = parkingSystem.park(new Car());

        assertThat(isParked, is(equalTo(true)));
    }
}
