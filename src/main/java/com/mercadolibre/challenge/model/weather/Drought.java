package com.mercadolibre.challenge.model.weather;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import java.util.List;

/**
 * Created by Pablo Costanzo on 17/9/2018.
 * Drought Day
 */
public class Drought extends Weather {

    private static final String DROUGHT_WEATHER = "drought";

    public Drought() {
        super();
        this.setName(DROUGHT_WEATHER);
    }

    public Drought(List<CelestialBody> planets, CelestialBody sun) {
        super(planets, sun);
        this.setName(DROUGHT_WEATHER);
    }


    @Override
    public boolean evaluate() {
        return (this.planetsAreCollinear() && this.planetsAreCollinearWithSun());
    }

}
