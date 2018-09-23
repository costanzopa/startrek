package com.mercadolibre.challenge.sevice;

import com.mercadolibre.challenge.model.weather.Weather;

import java.util.List;

/**
 * Created by Pablo Costanzo on 20/9/2018.
 * Auxiliary methods to weather prediction.
 */
public interface IWeatherService {

    WeatherPrediction add(WeatherPrediction prediction);
    WeatherPrediction update(WeatherPrediction prediction);
    WeatherPrediction delete(Integer id);
    WeatherPrediction get(Integer id);
    List<WeatherPrediction> getAll();

    WeatherPrediction getMaxRainFall();

    long countPeriodsOfWeather(String weather);
}
