package com.mercadolibre.challenge.sevice;

import com.mercadolibre.challenge.model.weather.entities.IWeather;

import java.util.List;

/**
 * Created by costa on 20/9/2018.
 */
public interface IWeatherService {

    void add(WeatherPrediction prediction);
    void update(WeatherPrediction prediction);
    void delete(Integer id);
    WeatherPrediction get(Integer id);
    List<WeatherPrediction> getAll();

    WeatherPrediction getMaxRainFall();

    long countOptimalDays();
}
