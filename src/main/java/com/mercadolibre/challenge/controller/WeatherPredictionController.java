package com.mercadolibre.challenge.controller;

import com.mercadolibre.challenge.model.weather.report.WeatherPrediction;
import com.mercadolibre.challenge.repository.WeatherPredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by costa on 20/9/2018.
 */
@RestController
@RequestMapping("/weatherPredictions")
public class WeatherPredictionController {
    @Autowired
    private WeatherPredictionRepository weatherPredictionRepository;


    public WeatherPredictionController(WeatherPredictionRepository weatherPredictionRepository) {
        this.weatherPredictionRepository = weatherPredictionRepository;
    }

    @GetMapping("/all")
    List<WeatherPrediction> getAll(){
        List<WeatherPrediction> weatherPredictions = this.weatherPredictionRepository.findAll();
        return weatherPredictions;
    }

}
