package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pablo Costanzo on 19/9/2018.
 * Encapsulate al the entities inside
 * Implement the singleton Pattern
 */

public class Galaxy {
    //CONSTANTS
   private final String FERENGI_NAME = "ferengi";
   private final int FERENGI_RADIUS  = 500;
   private final int FERENGI_ANGULAR_SPEED = -1;

   private final String BETASOIDE_NAME = "ferengi";
   private final int BETASOIDE_RADIUS = 2000;
   private final int BETASOIDE_ANGULAR_SPEED = -3;

   private final String VULCANO_NAME = "vulcano";
   private final int VULCANO_RADIUS = 1000;
   private final int VULCANO_ANGULAR_SPEED = 5;

   private final int ORIGIN_ANGLE = 0;



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
        Coordinate c1 = new Coordinate(FERENGI_RADIUS, ORIGIN_ANGLE);
        CelestialBody ferengi = new Planet(FERENGI_NAME, c1, FERENGI_ANGULAR_SPEED);
        Coordinate c2 = new Coordinate(BETASOIDE_RADIUS, ORIGIN_ANGLE);
        CelestialBody betasoide = new Planet(BETASOIDE_NAME, c2, BETASOIDE_ANGULAR_SPEED);
        Coordinate c3 = new Coordinate(VULCANO_RADIUS, ORIGIN_ANGLE);
        CelestialBody vulcano = new Planet(VULCANO_NAME, c3, VULCANO_ANGULAR_SPEED);
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
