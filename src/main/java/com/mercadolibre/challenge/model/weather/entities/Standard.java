package com.mercadolibre.challenge.model.weather.entities;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.physics.Coordinate;
import com.mercadolibre.challenge.model.physics.PhysicsUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by costa on 19/9/2018.
 */
public class Standard extends Weather implements IWeather {
    //TODO REFACTOR HARDCODE
    private static final String STANDARD_WEATHER = "normal";

    public Standard() {
        super();
        this.setName(STANDARD_WEATHER);
    }

    public Standard(List<CelestialBody> planets, CelestialBody sun) {
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
