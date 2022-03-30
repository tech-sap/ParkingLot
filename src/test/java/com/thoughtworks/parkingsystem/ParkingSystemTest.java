package com.thoughtworks.parkingsystem;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ParkingSystemTest {
    @Test
    void shouldReturnParkedWhenAllParkingSlotsAreFree() {
        ParkingSystem parkingSystem = new ParkingSystem();

        boolean isParked = parkingSystem.park();

        assertThat(isParked, is(equalTo(true)));
    }
}
