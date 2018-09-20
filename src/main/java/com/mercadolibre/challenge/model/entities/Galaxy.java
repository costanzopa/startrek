package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by costa on 19/9/2018.
 */
public class Galaxy {
   private List<CelestialBody> planets;
   private CelestialBody sun;

    private static Galaxy instance = null;
    public static Galaxy getInstance(){
        if(instance == null){
            instance = new Galaxy();
        }
        return instance;
    }

    private Galaxy() {
        //TODO Refactoring magic numbers and hardcode
        Coordinate c1 = new Coordinate(500, 0);
        CelestialBody ferengi = new Planet("ferengi", c1, -1);
        Coordinate c2 = new Coordinate(2000, 0);
        CelestialBody betasoide = new Planet("betasoide", c2, -3);
        Coordinate c3 = new Coordinate(1000, 0);
        CelestialBody vulcano = new Planet("vulcano", c3, 5);
        this.setSun(new Sun());
        this.setPlanets(Arrays.asList(ferengi, betasoide, vulcano));
    }

    public void move(int day) {
        this.getPlanets().forEach(planet -> planet.getLocation(day));
    }

    public void setPlanets(List<CelestialBody> planets) {
        this.planets = planets;
    }

    public List<CelestialBody> getPlanets() {
        return planets;
    }

    public void setSun(Sun sun) {
        this.sun = sun;
    }

    public CelestialBody getSun() {
        return sun;
    }

}
