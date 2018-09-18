package com.mercadolibre.challenge.model.weather;

import com.mercadolibre.challenge.model.entities.CelestialBody;

import java.util.List;

/**
 * Created by costa on 17/9/2018.
 */
public class Rainy extends Weather implements IWeather {
    private static final String RAINY_WEATHER = "drought";

    public Rainy(List<CelestialBody> planets, CelestialBody sun) {
        super(planets, sun);
        this.setName(RAINY_WEATHER);
    }

    @Override
    public boolean hasThisWeather() {
        return (!this.planetsAreCollinear());
    }
}
