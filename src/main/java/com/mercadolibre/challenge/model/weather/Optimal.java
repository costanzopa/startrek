package com.mercadolibre.challenge.model.weather;

import com.mercadolibre.challenge.model.entities.CelestialBody;

import java.util.List;

/**
 * Created by Pablo Costanzo on 17/9/2018.
 * Model a best condition weather.
 */
public class Optimal extends Weather implements IWeather{
    private static final String OPTIMAL_WEATHER = "optimal";

    public Optimal() {
        super();
        this.setName(OPTIMAL_WEATHER);
    }

    public Optimal(List<CelestialBody> planets, CelestialBody sun) {
        super(planets, sun);
        this.setName(OPTIMAL_WEATHER);
    }

    @Override
    public boolean evaluate() {
        return (this.planetsAreCollinear()&& !this.planetsAreCollinearWithSun());
    }

}
