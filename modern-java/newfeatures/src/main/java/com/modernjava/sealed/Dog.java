package com.modernjava.sealed;

public class Dog /*extends Vehicle*/extends FlyingCar{
    //cannot extend Vehicle because it is not in the permits list.
    // but once FlyingCar extends Car and it is not-sealed, the Dog becomes a Vehicle.
}
