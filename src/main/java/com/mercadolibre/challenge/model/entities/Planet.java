package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;

/**
 * Created by Pablo Costanzo on 16/9/2018.
 * Implement a planet.
 */
public class Planet extends CelestialBody {

    public Planet(String name, Coordinate coordinate, int angularSpeed) {
        super(name, coordinate, angularSpeed);
    }
}
