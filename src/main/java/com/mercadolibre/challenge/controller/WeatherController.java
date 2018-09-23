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
@Api(value="/weathers", description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Weather Predictions.", produces ="application/json")
public class WeatherController {

    private IWeatherService weatherService;

    public WeatherController(IWeatherService weatherService){
        this.weatherService = weatherService;
    }


    @GetMapping(value = "/list", produces = "application/json")
    @ApiOperation("Returns list of all weather predictions in the system.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved list.", response=WeatherPrediction.class)})
    ResponseEntity<List<WeatherPrediction>> getAll(){
        List<WeatherPrediction> weatherPredictions = weatherService.getAll();
        return new ResponseEntity(weatherPredictions, HttpStatus.OK);
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ApiOperation("Add a new weather prediction.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved a weather prediction.", response=WeatherPrediction.class),
            @ApiResponse(code = 403, message = "The resource you were trying to add already exists.", response=WeatherPrediction.class)
    })
    ResponseEntity<WeatherPrediction> add(@RequestBody WeatherPrediction prediction) {
        WeatherPrediction weatherPrediction = weatherService.add(prediction);
        ResponseEntity responseEntity;
        if (weatherPrediction != null)
            responseEntity = new ResponseEntity(weatherPrediction, HttpStatus.OK);
        else
            responseEntity= new ResponseEntity(weatherPrediction, HttpStatus.FORBIDDEN);

        return responseEntity;
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    @ApiOperation("Update a weather prediction.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update weather prediction.", response=WeatherPrediction.class),
            @ApiResponse(code = 404, message = "The resource you were trying to update is not found.")})
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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully show weather prediction.", response=WeatherPrediction.class),
            @ApiResponse(code = 404, message = "The resource you were trying to show is not found.")})
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
    @ApiOperation("Deletes a weather prediction from the system.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deletec weather prediction.", response=WeatherPrediction.class),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found.")})
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
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved the day that rained most.")})
    ResponseEntity<WeatherPrediction> getMaxRainFall() {
        WeatherPrediction weatherPrediction = weatherService.getMaxRainFall();
        return new ResponseEntity(weatherPrediction, HttpStatus.OK);
    }

    @GetMapping(value = "/countPeriodsOfWeather/{weather}", produces = "application/json")
    @ApiOperation("Counts the periods of a given {weather}.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved the number of days with a weather.")})
    ResponseEntity<WeatherPrediction> countPeriodsOfWeather(@PathVariable("weather") String weather) {
        long countDays = weatherService.countPeriodsOfWeather(weather);
        JSONObject json = new JSONObject();
        json.put("weather", weather);
        json.put("daysCount", countDays);

        return new ResponseEntity(json, HttpStatus.OK);
    }
}
