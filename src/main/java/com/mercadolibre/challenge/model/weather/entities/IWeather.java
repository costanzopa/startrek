package com.mercadolibre.challenge.model.weather.entities;

import com.mercadolibre.challenge.model.weather.report.WeatherPrediction;

/**
 * Created by costa on 17/9/2018.
 */
public interface IWeather {

    boolean evaluate();
    double  getRainFall();
    WeatherPrediction getWeatherPrediction();

}
