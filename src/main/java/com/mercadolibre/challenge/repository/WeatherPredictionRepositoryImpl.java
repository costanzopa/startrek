package com.mercadolibre.challenge.repository;

import com.mercadolibre.challenge.sevice.WeatherPrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by costa on 20/9/2018.
 */
public class WeatherPredictionRepositoryImpl implements WeatherPredictionRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;

    WeatherPredictionRepositoryImpl() {

    }

    @Override
    public WeatherPrediction findMaxWeatherPrediction() {
        final Query query = new Query()
                .limit(1)
                .with(new Sort(Sort.Direction.DESC, "rainFall"));

        return mongoTemplate.findOne(query, WeatherPrediction.class);
    }

    @Override
    public long countOptimalConditionDays() {
        Query query = new Query();
        query.addCriteria(Criteria.where("weather").is("optimo"));
        return mongoTemplate.count(query, WeatherPrediction.class);
    }


}
