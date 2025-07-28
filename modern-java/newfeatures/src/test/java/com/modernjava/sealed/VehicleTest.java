package com.modernjava.sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void vehicleTest(){
        var car = new Car();
        var truck = new Truck();
        var dog = new Dog();
        assertInstanceOf(Vehicle.class, car);
        assertInstanceOf(Vehicle.class, truck);
        //dog cannot be Vehicle. You cannot even test the instanceof
        assertInstanceOf(Vehicle.class, dog);
    }

    @Test
    void drive(){
        var car = new Car();
        var truck = new Truck();

        assertEquals("CAR", car.drive());
        assertEquals("TRUCK", truck.drive());
    }
}