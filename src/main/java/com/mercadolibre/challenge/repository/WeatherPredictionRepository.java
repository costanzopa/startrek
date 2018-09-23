package com.mercadolibre.challenge.repository;

import com.mercadolibre.challenge.sevice.WeatherPrediction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pablo Costanzo on 20/9/2018.
 * Model the mongo repository.
 */
@Repository
public interface WeatherPredictionRepository extends MongoRepository<WeatherPrediction, Integer>, WeatherPredictionRepositoryCustom {
    WeatherPrediction findWeatherPredictionByDay(Integer id);
}
