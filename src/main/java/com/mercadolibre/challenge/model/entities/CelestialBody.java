package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;

/**
 * Created by Pablo Costanzo on 16/9/2018.
 * Implement a planet.
 */
public abstract class CelestialBody  {
    private String  name;
    private Coordinate coordinate;
    private int angularSpeed;


    public CelestialBody(String name,  Coordinate coordinate, int angularSpeed) {
        this.setName(name);
        this.setCoordinate(coordinate);
        this.setAngularSpeed(angularSpeed);
    }

    public CelestialBody() {
        super();
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setAngularSpeed(int angularSpeed) {
        this.angularSpeed = angularSpeed;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getAngularSpeed() {
        return angularSpeed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Coordinate getLocation(int day) {
        Coordinate c1 = this.getCoordinate();
        int angularSpeed = this.getAngularSpeed();
        c1.setAngle(day*angularSpeed);
        return this.getCoordinate();
    }
}
