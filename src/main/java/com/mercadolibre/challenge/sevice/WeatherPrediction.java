package com.mercadolibre.challenge.sevice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by costa on 17/9/2018.
 */

@Document(collection = "weathers")
public class WeatherPrediction {
    @Id
    private Integer day;
    private String weather;
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
