package com.mercadolibre.challenge.model.weather.report;


import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.entities.Galaxy;
import com.mercadolibre.challenge.model.weather.entities.*;
import com.mercadolibre.challenge.repository.WeatherPredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by costa on 18/9/2018.
 */
public class WeatherReport {

    private WeatherPredictionRepository weatherPredictionsRepository;

    private int beginDate;
    private int endDate;
    private Galaxy galaxy;
    private List<IWeather> weathers;


    public WeatherReport(WeatherPredictionRepository weatherPredictionsRepository) {

        this.weatherPredictionsRepository = weatherPredictionsRepository;

    }

    public void execute() {
        this.setBeginDate(1);
        this.setEndDate(3650);
        this.galaxy = Galaxy.getInstance();
        this.initWeathers();
        this.weatherPredictionsRepository.deleteAll();
        for (int i = this.getBeginDate(); i < this.getEndDate(); i++) {
            WeatherPrediction weatherPrediction = this.getWeatherPrediction(i);
            this.weatherPredictionsRepository.save(weatherPrediction);
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
