package com.mercadolibre.challenge.sevice;

import java.util.List;

/**
 * Created by costa on 20/9/2018.
 */
public interface IWeatherService {

    void add(WeatherPrediction prediction);
    WeatherPrediction update(WeatherPrediction prediction);
    WeatherPrediction delete(Integer id);
    WeatherPrediction get(Integer id);
    List<WeatherPrediction> getAll();

    WeatherPrediction getMaxRainFall();

    long countPeriodsOfWeather(String weather);
}
