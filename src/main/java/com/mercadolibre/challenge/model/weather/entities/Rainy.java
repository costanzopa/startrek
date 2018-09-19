package com.mercadolibre.challenge.model.weather.entities;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.physics.Coordinate;
import com.mercadolibre.challenge.model.physics.PhysicsUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by costa on 17/9/2018.
 */
public class Rainy extends Weather implements IWeather {
    private static final String RAINY_WEATHER = "lluvia";

    public Rainy() {
        super();
        this.setName(RAINY_WEATHER);
    }

    public Rainy(List<CelestialBody> planets, CelestialBody sun) {
        super(planets, sun);
        this.setName(RAINY_WEATHER);
    }

    @Override
    public boolean evaluate() {
        boolean isRainy = false;
        if (!this.planetsAreCollinear()) {
            if (this.getPlanets() != null && this.getPlanets().size() == 3) {
                List<Coordinate> planetsCoordinates = new ArrayList<>();
                for (int j = 0; j < this.getPlanets().size(); j++) {
                    Coordinate c1 = this.getPlanets().get(j).getCoordinate();
                    planetsCoordinates.add(c1);
                }
                isRainy = PhysicsUtil.isInsideTheTriangle(planetsCoordinates, this.getSun().getCoordinate());
                if (isRainy)
                    this.setRainFall(PhysicsUtil.calculatePerimeterOfATriangle(planetsCoordinates));
            }
        }
        return isRainy;
    }
}
