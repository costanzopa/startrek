package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;

/**
 * Created by costa on 16/9/2018.
 */
public class Planet extends CelestialBody {

    public Planet(String name, Coordinate coordinate, int angularSpeed) {
        super(name, coordinate, angularSpeed);
    }

    public Planet() {
        super();
    }
}
