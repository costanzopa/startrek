package com.mercadolibre.challenge.model.weather.report;


import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.entities.Galaxy;
import com.mercadolibre.challenge.model.weather.entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by costa on 18/9/2018.
 */
public class WeatherReport {
    private List<WeatherPrediction> weatherPredictions;
    private int beginDate;
    private int endDate;
    private Galaxy galaxy;
    private List<IWeather> weathers;

    private static WeatherReport instance = null;
    public static WeatherReport getInstance(){
        if(instance == null){
            instance = new WeatherReport();
        }
        return instance;
    }

    public WeatherReport() {
        //TODO refactor Magic Numbers
        this.setBeginDate(1);
        this.setEndDate(10);
        this.galaxy = Galaxy.getInstance();
        this.initWeathers();
        this.weatherPredictions = new ArrayList<>();
        for (int i = this.getBeginDate(); i < this.getEndDate(); i++) {
            WeatherPrediction weatherPrediction = this.getWeatherPrediction(i);
            //TODO STORE IN REPOSITORY
            weatherPredictions.add(weatherPrediction);
        }
    }

    private void initWeathers() {
        this.setWeathers(Arrays.asList(new Drought(), new Optimal(), new Rainy(), new Standard()));
    }


    private WeatherPrediction getWeatherPrediction(int day) {
        WeatherPrediction weatherPrediction = new WeatherPrediction("normal", 0.0);
        this.getGalaxy().move(day);
        this.updateWeathers(this.getGalaxy().getPlanets(), this.getGalaxy().getSun());
        for(IWeather weather : this.getWeathers()) {
            if(weather.evaluate()) {
                weatherPrediction = weather.getWeatherPrediction();
                break;
            }
        }

        weatherPrediction.setDay(day);
        return weatherPrediction;
    }

    private void updateWeathers(List<CelestialBody> planets, CelestialBody sun) {
       List<IWeather>  weathers = this.getWeathers();
       weathers.forEach(weather -> weather.setParameters(planets, sun));
    }

    private List<IWeather> getWeathers() {
        return this.weathers;
    }

   /* // return all predictions
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

    }*/

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

    public void setWeathers(List<IWeather> weathers) {
        this.weathers = weathers;
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }
}
