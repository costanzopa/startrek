package com.mercadolibre.challenge.model.weather.report;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.challenge.model.weather.report.WeatherReport;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by costa on 19/9/2018.
 */
public class WeatherReportTests {
    private WeatherReport report;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        report = WeatherReport.getInstance();
    }


    /***
     * All planets and sun are collinear
     */
    @Test
    public void checkIfCreateWeatherPredictions() {
        List<WeatherPrediction> predictions = this.report.getWeatherPredictions();
         assertTrue(!predictions.isEmpty());
    }
}
