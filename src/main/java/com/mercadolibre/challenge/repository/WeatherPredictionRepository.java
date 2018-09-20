package com.mercadolibre.challenge.repository;

import com.mercadolibre.challenge.model.weather.report.WeatherPrediction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by costa on 20/9/2018.
 */
@Repository
public interface WeatherPredictionRepository extends MongoRepository<WeatherPrediction, String>{
}
