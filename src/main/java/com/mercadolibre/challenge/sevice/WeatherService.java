package com.mercadolibre.challenge.sevice;


import com.mercadolibre.challenge.config.AppConfig;
import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.entities.Galaxy;
import com.mercadolibre.challenge.model.weather.*;
import com.mercadolibre.challenge.repository.WeatherPredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Pablo Costanzo on 18/9/2018.
 * Service for the weather prediction controller
 */
@Service
@Configurable
public class WeatherService implements IWeatherService {

    private final String DEFAULT_WEATHER_NAME = "normal";
    private final double DEFAULT_WEATHER_RAINFALL = 0.0;

    @Autowired
    private WeatherPredictionRepository weatherPredictionsRepository;

    @Autowired
    private AppConfig config;

    private int beginDate;
    private int endDate;
    private Galaxy galaxy;
    private List<IWeather> weathers;

    public WeatherService() {
    }

    public WeatherService(WeatherPredictionRepository weatherPredictionsRepository) {
        this.weatherPredictionsRepository = weatherPredictionsRepository;
    }

    public void execute() {
        this.setBeginDate(config.getBeginDate());
        this.setEndDate(config.getEndDate());
        this.galaxy = Galaxy.getInstance();
        this.initWeathers();
        this.weatherPredictionsRepository.deleteAll();
        for (int i = this.getBeginDate(); i < this.getEndDate(); i++) {
            WeatherPrediction weatherPrediction = this.getWeatherPrediction(i);
            this.weatherPredictionsRepository.save(weatherPrediction);
        }
    }
    private void initWeathers() {
        this.setWeathers(Arrays.asList(new Drought(), new Optimal(), new Rainy(), new Normal()));
    }

    private WeatherPrediction getWeatherPrediction(int day) {
        WeatherPrediction weatherPrediction = new WeatherPrediction(DEFAULT_WEATHER_NAME, DEFAULT_WEATHER_RAINFALL);
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

    @Override
    public WeatherPrediction add(WeatherPrediction prediction) {
        WeatherPrediction weatherPrediction = this.weatherPredictionsRepository.findWeatherPredictionByDay(prediction.getDay());
        if(weatherPrediction == null) {
            weatherPrediction = prediction;
            this.weatherPredictionsRepository.save(prediction);
        } else {
            weatherPrediction = null;
        }
        return weatherPrediction;
    }

    @Override
    public WeatherPrediction update(WeatherPrediction prediction) {
        WeatherPrediction weatherPrediction = this.weatherPredictionsRepository.findWeatherPredictionByDay(prediction.getDay());
        if(weatherPrediction != null) {
            weatherPrediction.setRainFall(prediction.getRainFall());
            weatherPrediction.setWeather(prediction.getWeather());
            this.weatherPredictionsRepository.save(weatherPrediction);
        }
        return weatherPrediction;
    }

    @Override
    public WeatherPrediction delete(Integer id) {
        WeatherPrediction weatherPrediction = this.weatherPredictionsRepository.findWeatherPredictionByDay(id);
        if(weatherPrediction != null) {
            this.weatherPredictionsRepository.delete(weatherPrediction);
        }
        return weatherPrediction;
    }

    @Override
    public WeatherPrediction get(Integer id) {
        return this.weatherPredictionsRepository.findWeatherPredictionByDay(id);

    }

    @Override
    public List<WeatherPrediction> getAll() {
        return this.weatherPredictionsRepository.findAll();
    }

    @Override
    public WeatherPrediction getMaxRainFall() {
        return this.weatherPredictionsRepository.findMaxWeatherPredictionRainFall();
    }

    @Override
    public long countPeriodsOfWeather(String weather) {
        return this.weatherPredictionsRepository.countPeriodsOfWeather(weather);
    }

    public void setWeatherPredictionsRepository(WeatherPredictionRepository weatherPredictionsRepository) {
        this.weatherPredictionsRepository = weatherPredictionsRepository;
    }
}
