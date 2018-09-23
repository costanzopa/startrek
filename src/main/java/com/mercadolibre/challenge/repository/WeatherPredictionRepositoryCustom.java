package com.mercadolibre.challenge.repository;

import com.mercadolibre.challenge.sevice.WeatherPrediction;

/**
 * Created by Pablo Costanzo on 20/9/2018.
 * Program to interfaces not implementations
 */
public interface WeatherPredictionRepositoryCustom {

    WeatherPrediction findMaxWeatherPredictionRainFall();

    long countPeriodsOfWeather(String weather);
}
