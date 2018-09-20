package com.mercadolibre.challenge.repository;

import com.mercadolibre.challenge.sevice.WeatherPrediction;

/**
 * Created by costa on 20/9/2018.
 */
public interface WeatherPredictionRepositoryCustom {

    WeatherPrediction findMaxWeatherPrediction();

    long countOptimalConditionDays();
}
