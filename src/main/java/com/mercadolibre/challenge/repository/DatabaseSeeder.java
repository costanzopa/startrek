package com.mercadolibre.challenge.repository;

import com.mercadolibre.challenge.sevice.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Pablo Costanzo on 20/9/2018.
 * Initialize the seed database.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner{
    @Autowired
    WeatherService report;
    @Autowired
    WeatherPredictionRepository weatherPredictionsRepository;

    @Override
    public void run(String... strings) throws Exception {
        report.setWeatherPredictionsRepository(weatherPredictionsRepository);
        report.execute();
    }
}
