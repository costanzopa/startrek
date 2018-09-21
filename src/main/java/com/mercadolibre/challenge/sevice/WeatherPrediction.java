package com.mercadolibre.challenge.sevice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by costa on 17/9/2018.
 */

@Document(collection = "weathers")
@ApiModel(description = "Class representing a weather prediction for the galaxy far far away")
public class WeatherPrediction {
    @Id
    @ApiModelProperty(notes = "Unique identifier of the weather prediction. No two weathers predictions can have the same id.", example = "1", required = true, position = 0)
    private Integer day;
    @NotBlank
    @ApiModelProperty(notes = "Weather that predicts the service.", example = "rainy", required = true, position = 1)
    private String weather;
    @ApiModelProperty(notes = "Rain measured in the day. Non-negative double.", example = "34.00", position = 3)
    private double rainFall;

    public WeatherPrediction(){

    }

    public WeatherPrediction(double rainFall){
        this.setRainFall(rainFall);
    }

    public WeatherPrediction(String weather, double rainFall) {
        this.setWeather(weather);
        this.setRainFall(rainFall);
    }

    public WeatherPrediction(int day, String weather, double rainFall) {
        this.setWeather(weather);
        this.setRainFall(rainFall);
        this.setDay(day);
    }

    public WeatherPrediction(String id, int day, String weather, double rainFall) {
        this.setWeather(weather);
        this.setRainFall(rainFall);
        this.setDay(day);
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getRainFall() {
        return rainFall;
    }

    public void setRainFall(double rainFall) {
        this.rainFall = rainFall;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
