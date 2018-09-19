package com.mercadolibre.challenge.model.weather.entities;

import com.mercadolibre.challenge.model.entities.CelestialBody;

import java.util.List;

/**
 * Created by costa on 17/9/2018.
 */
public class Normal extends Weather implements IWeather{

    private static final String NORMAL_WEATHER = "normal";

    public Normal(List<CelestialBody> planets, CelestialBody sun) {
        super(planets, sun);
        this.setName(NORMAL_WEATHER);
    }

    @Override
    public boolean evaluate() {
        return (this.planetsAreCollinear()&& !this.planetsAreCollinearWithSun());
    }

}
