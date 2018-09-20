package com.mercadolibre.challenge.model.weather.entities;

import com.mercadolibre.challenge.model.entities.CelestialBody;
import com.mercadolibre.challenge.model.physics.Coordinate;
import com.mercadolibre.challenge.model.physics.PhysicsUtil;
import com.mercadolibre.challenge.sevice.WeatherPrediction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by costa on 17/9/2018.
 */
public abstract class Weather {
    private String name;
    private List<CelestialBody> planets;
    private CelestialBody sun;
    private double rainFall;

    public Weather() {
        this.setRainFall(0);
    }

    public Weather(List<CelestialBody> cb1, CelestialBody cb2) {
        this.setPlanets(cb1);
        this.setSun(cb2);
        this.setRainFall(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CelestialBody> getPlanets() {
        return planets;
    }

    private void setPlanets(List<CelestialBody> planets) {
        this.planets = planets;
    }

    public CelestialBody getSun() {
        return sun;
    }

    public void setSun(CelestialBody sun) {
        this.sun = sun;
    }

    public boolean planetsAreCollinear() {
        boolean areCollinear = false;
        if (this.getPlanets() != null && this.getPlanets().size() == 3) {
            List<Coordinate> coordinatesPlanets = new ArrayList<>();

            for (int i = 0; i < this.getPlanets().size(); i++) {
                Coordinate c1 = this.getPlanets().get(i).getCoordinate();
                coordinatesPlanets.add(c1);
            }
            areCollinear = PhysicsUtil.areCollinear(coordinatesPlanets);
        }
        return areCollinear;
    }

    public boolean planetsAreCollinearWithSun() {
        boolean areCollinear = false;
        if (this.getPlanets() != null && this.getPlanets().size() == 3) {
            List<Coordinate> planetsWithSun = new ArrayList<>();
            Coordinate coordinateSun = this.getSun().getCoordinate();
            planetsWithSun.add(coordinateSun);

            for (int j = 1; j < this.getPlanets().size(); j++) {
                Coordinate c2 = this.getPlanets().get(j).getCoordinate();
                planetsWithSun.add(c2);
            }

            areCollinear = PhysicsUtil.areCollinear(planetsWithSun);
        }
        return areCollinear;
    }

    public double getRainFall() {
        return rainFall;
    }

    public void setRainFall(double rainFall) {
        this.rainFall = rainFall;
    }

    public WeatherPrediction getWeatherPrediction() {
        WeatherPrediction weatherPrediction = new WeatherPrediction(this.getName(), this.getRainFall());
        return weatherPrediction;
    }

    public void setParameters(List<CelestialBody> planets, CelestialBody sun) {
        this.setPlanets(planets);
        this.setSun(sun);
    }
}
