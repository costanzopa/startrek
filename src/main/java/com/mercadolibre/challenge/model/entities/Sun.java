package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;

/**
 * Created by costa on 17/9/2018.
 */
public class Sun extends CelestialBody {
    private Sun(String name, Coordinate coordinate, int angularSpeed) {
        super(name, coordinate, angularSpeed);
    }

    public Sun() {
        super("Sun", new Coordinate(0,0), 0);
    }

}
