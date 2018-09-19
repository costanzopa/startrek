package com.mercadolibre.challenge.model.weather.report;

/**
 * Created by costa on 17/9/2018.
 */
public class WeatherPrediction {
    private int day;
    private String weather;
    private double rainFall;


    public WeatherPrediction(String weather, double rainFall) {
        this.setWeather(weather);
        this.setRainFall(rainFall);
    }

    public WeatherPrediction(int day, String weather, double rainFall) {
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
