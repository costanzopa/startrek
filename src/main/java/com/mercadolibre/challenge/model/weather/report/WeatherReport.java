package com.mercadolibre.challenge.model.weather.report;


import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.entities.Planet;
import com.mercadolibre.challenge.model.entities.Sun;
import com.mercadolibre.challenge.model.physics.Coordinate;
import com.mercadolibre.challenge.model.weather.entities.*;
import javafx.beans.binding.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by costa on 18/9/2018.
 */
public class WeatherReport {
    private List<WeatherPrediction> weatherPredictions;
    private int beginDate;
    private int endDate;
    private CelestialBody sun;
    private List<CelestialBody> planets;
    private List<IWeather> weathers;

    private static WeatherReport instance = null;
    public static WeatherReport getInstance(){
        if(instance == null){
            instance = new WeatherReport();
        }
        return instance;
    }

    public WeatherReport(){
        this.setBeginDate(1);
        this.setEndDate(10);
        this.initGalaxy();
        this.weatherPredictions = new ArrayList<>();

        for (int i = this.getBeginDate(); i < this.getEndDate(); i++) {
            WeatherPrediction weatherPrediction = this.getWeatherPrediction(i);
            weatherPredictions.add(weatherPrediction);
        }
    }


    private WeatherPrediction getWeatherPrediction(int day) {
        WeatherPrediction weatherPrediction = null;
        this.planets.forEach(planet -> planet.getLocation(day));

        this.getWeathers(this.planets, this.sun);
        for(IWeather weather : this.weathers) {
            if(weather.evaluate()) {
                weatherPrediction = weather.getWeatherPrediction();
                break;
            }
        }
        return weatherPrediction;
    }

    private void getWeathers(List<CelestialBody> planets, CelestialBody sun) {
        IWeather drought = new Drought(planets, sun);
        IWeather normal = new Normal(planets, sun);
        IWeather rainy = new Rainy(planets, sun);
        this.weathers = new ArrayList<>();
        this.weathers.add(drought);
        this.weathers.add(normal);
        this.weathers.add(rainy);
    }

    private void initGalaxy() {
        Coordinate c1 = new Coordinate(500, 0);
        CelestialBody ferengi = new Planet("ferengi", c1, -1);
        Coordinate c2 = new Coordinate(2000, 0);
        CelestialBody betasoide = new Planet("betasoide", c2, -3);
        Coordinate c3 = new Coordinate(1000, 0);
        CelestialBody vulcano = new Planet("vulcano", c3, -5);
        this.sun = new Sun();
        this.planets =  new ArrayList<>();
        this.planets.add(ferengi);
        this.planets.add(betasoide);
        this.planets.add(vulcano);
    }

    // return all predictions
    public List<WeatherPrediction> fetchPredictions() {
        return this.weatherPredictions;
    }

    // return WeatherPrediction by id
    public WeatherPrediction getWeatherPredictionByDay(int day) {
        for(WeatherPrediction w: this.weatherPredictions) {
            if(w.getDay() == day) {
                return w;
            }
        }
        return null;
    }

    // search blog by Weather
    public List<WeatherPrediction> searchWeather(String wheather) {
        List<WeatherPrediction> searchedWeatherPrediction = new ArrayList<>();
        for(WeatherPrediction b: this.weatherPredictions) {
            if(b.getWeather().toLowerCase().equals(wheather.toLowerCase())) {
                searchedWeatherPrediction.add(b);
            }
        }
        return searchedWeatherPrediction;
    }

    // create Weather Prediction
    public WeatherPrediction createAWeatherPrediction(int day, String weather, double rainFall) {
        WeatherPrediction newWeatherPrediction = new WeatherPrediction(day, weather, rainFall);
        this.weatherPredictions.add(newWeatherPrediction);
        return newWeatherPrediction;
    }

    // update Weather Prediction
    public WeatherPrediction updateWeatherPrediction(int day, String weather, double rainFall) {
        for(WeatherPrediction w: this.getWeatherPredictions()) {
            if(w.getDay() == day) {
                int weatherIndex = this.getWeatherPredictions().indexOf(w);
                w.setWeather(weather);
                w.setRainFall(rainFall);
                this.getWeatherPredictions().set(weatherIndex, w);
                return w;
            }

        }
        return null;
    }

    // delete weather by id
    public boolean delete(int day){
        int weatherIndex = -1;
        for(WeatherPrediction w: this.getWeatherPredictions()) {
            if(w.getDay() == day) {
                weatherIndex = this.getWeatherPredictions().indexOf(w);
                continue;
            }
        }
        if(weatherIndex > -1){
            this.getWeatherPredictions().remove(weatherIndex);
        }
        return true;
    }

    // Get Max RainFall in the weather Predictions
    public WeatherPrediction getMaxRainFall(){
        Comparator<WeatherPrediction> comparator = Comparator.comparing( WeatherPrediction::getRainFall );
        
        WeatherPrediction maxWeatherPredictionRainFall = this.getWeatherPredictions().stream().max(comparator).get();
        return maxWeatherPredictionRainFall;

    }

    public List<WeatherPrediction> getWeatherPredictions() {
        return weatherPredictions;
    }

    public void setWeatherPredictions(List<WeatherPrediction> weatherPredictions) {
        this.weatherPredictions = weatherPredictions;
    }

    public int getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(int beginDate) {
        this.beginDate = beginDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
