package com.mercadolibre.challenge.model.weather.entities;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.sevice.WeatherPrediction;

import java.util.List;

/**
 * Created by costa on 17/9/2018.
 */
public interface IWeather {

    boolean evaluate();
    double  getRainFall();
    void    setParameters(List<CelestialBody> planets, CelestialBody sun);
    WeatherPrediction getWeatherPrediction();

}
