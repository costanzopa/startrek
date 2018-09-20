package com.mercadolibre.challenge.model.weather.report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by costa on 17/9/2018.
 */

@Document(collection = "weatherPredictions")
public class WeatherPrediction {
    @Id
    private String id;
    private int day;
    private String weather;
    @Indexed(direction = IndexDirection.DESCENDING)
    private double rainFall;

    public WeatherPrediction(){

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
        this.setId(id);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
