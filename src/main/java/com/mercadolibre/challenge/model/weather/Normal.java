package com.mercadolibre.challenge.model.weather;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.physics.Coordinate;
import com.mercadolibre.challenge.model.physics.PhysicsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo Costanzo on 19/9/2018.
 * Normal day not rainy optimal or drought.
 * */
public class Normal extends Weather {
    private static final String STANDARD_WEATHER = "normal";

    public Normal() {
        super();
        this.setName(STANDARD_WEATHER);
    }

    public Normal(List<CelestialBody> planets, CelestialBody sun) {
        super(planets, sun);
        this.setName(STANDARD_WEATHER);
    }

    @Override
    public boolean evaluate() {
        CelestialBody sun = this.getSun();
        List<Coordinate> coordinates = new ArrayList<>();
        this.getPlanets().forEach(planet -> coordinates.add(planet.getCoordinate()));
        return (!this.planetsAreCollinearWithSun() && !PhysicsUtil.isInsideTheTriangle(coordinates, sun.getCoordinate()));
    }
}
