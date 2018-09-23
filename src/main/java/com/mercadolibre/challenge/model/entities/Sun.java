package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;

/**
 * Created by Pablo Costanzo on 17/9/2018.
 * Implement the sun.
 */
public class Sun extends CelestialBody {
    public Sun() {
        super("Sun", new Coordinate(0,0), 0);
    }
}
