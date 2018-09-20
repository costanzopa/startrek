package com.mercadolibre.challenge.controller;

import com.mercadolibre.challenge.sevice.IWeatherService;
import com.mercadolibre.challenge.sevice.WeatherPrediction;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by costa on 20/9/2018.
 */
@RestController
@RequestMapping("/weathers")
public class WeatherPredictionController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/all")
    ResponseEntity<List<WeatherPrediction>> getAll(){
        List<WeatherPrediction> weatherPredictions = weatherService.getAll();
        return new ResponseEntity(weatherPredictions, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<WeatherPrediction> add(@RequestBody WeatherPrediction weatherPrediction) {
        weatherService.add(weatherPrediction);
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<WeatherPrediction> update(@RequestBody WeatherPrediction weatherPrediction) {
        weatherService.update(weatherPrediction);
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<WeatherPrediction> get(@PathVariable("id") Integer id) {
        WeatherPrediction weatherPrediction = weatherService.get(id);
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        weatherService.delete(id);
        return new ResponseEntity("Success!", HttpStatus.OK);
    }

    @GetMapping("/maxRainfall")
    ResponseEntity<WeatherPrediction> getMaxRainFall() {
        WeatherPrediction weatherPrediction = weatherService.getMaxRainFall();
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @GetMapping("/countOptimalDays")
    ResponseEntity<WeatherPrediction> getOptimalDays() {
        long optimalDays = weatherService.countOptimalDays();
        JSONObject json = new JSONObject();
        json.put("weather", "optimal");
        json.put("count", optimalDays);

        return new ResponseEntity(json, HttpStatus.OK);
    }
}
