package com.mercadolibre.challenge.model.weather;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.sevice.WeatherPrediction;

import java.util.List;

/**
 * Created by Pablo Costanzo on 17/9/2018.
 * Methods to obtain data of the day.
 */
public interface IWeather {

    boolean evaluate();
    double  getRainFall();
    void    setParameters(List<CelestialBody> planets, CelestialBody sun);
    WeatherPrediction getWeatherPrediction();

}
