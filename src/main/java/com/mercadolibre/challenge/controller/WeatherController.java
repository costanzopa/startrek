package com.mercadolibre.challenge.controller;

import com.mercadolibre.challenge.sevice.IWeatherService;
import com.mercadolibre.challenge.sevice.WeatherPrediction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Pablo Costanzo on 20/9/2018.
 * Weather controller.
 */
@RestController
@RequestMapping("/weathers")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Weather Predictions.")
public class WeatherController {

    private IWeatherService weatherService;

    public WeatherController(IWeatherService weatherService){
        this.weatherService = weatherService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @GetMapping(value = "/list", produces = "application/json")
    @ApiOperation("Returns list of all weather predictions in the system.")
    ResponseEntity<List<WeatherPrediction>> getAll(){
        List<WeatherPrediction> weatherPredictions = weatherService.getAll();
        return new ResponseEntity(weatherPredictions, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ApiOperation("Add a new weather prediction.")
    ResponseEntity<WeatherPrediction> add(@RequestBody WeatherPrediction weatherPrediction) {
        weatherService.add(weatherPrediction);
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    @ApiOperation("Update a weather prediction.")
    ResponseEntity<WeatherPrediction> update(@RequestBody WeatherPrediction weatherPrediction) {
        weatherService.update(weatherPrediction);
        ResponseEntity responseEntity;
        if (weatherPrediction != null)
            responseEntity = new ResponseEntity(weatherPrediction, HttpStatus.OK);
        else
            responseEntity= new ResponseEntity(weatherPrediction, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    @ApiOperation("Returns a specific weather prediction by their identifier (day). 404 if does not exist.")
    ResponseEntity<WeatherPrediction> get(@PathVariable("id") Integer id) {
        WeatherPrediction weatherPrediction = weatherService.get(id);
        ResponseEntity responseEntity;
        if (weatherPrediction != null)
            responseEntity = new ResponseEntity(weatherPrediction, HttpStatus.OK);
        else
            responseEntity= new ResponseEntity(weatherPrediction, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    @ApiOperation("Deletes a weather prediction from the system. 404 if the prediction's identifier is not found.")
    ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        WeatherPrediction weatherPrediction = weatherService.delete(id);
        ResponseEntity responseEntity;
        JSONObject json = new JSONObject();
        if (weatherPrediction != null) {
            json.put("result", "Weather Prediction deleted successfully.");
            responseEntity = new ResponseEntity(json, HttpStatus.OK);
        } else {
            json.put("result","Weather Prediction with " +id +" not found.");
            responseEntity= new ResponseEntity(json, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping(value = "/maxRainFall", produces = "application/json")
    @ApiOperation("Get the day when the rain will be maximum.")
    ResponseEntity<WeatherPrediction> getMaxRainFall() {
        WeatherPrediction weatherPrediction = weatherService.getMaxRainFall();
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @GetMapping(value = "/countPeriodsOfWeather/{weather}", produces = "application/json")
    @ApiOperation("Counts the periods of a given {weather}.")
    ResponseEntity<WeatherPrediction> countPeriodsOfWeather(@PathVariable("weather") String weather) {
        long countDays = weatherService.countPeriodsOfWeather(weather);
        JSONObject json = new JSONObject();
        json.put("weather", weather);
        json.put("daysCount", countDays);

        return new ResponseEntity(json, HttpStatus.OK);
    }
}
