package com.mercadolibre.challenge.model.physics;

/**
 * Created by Pablo Costanzo on 15/9/2018.
 * Models a point in the galaxy.
 *
 */
public class Coordinate {

    private double x;
    private double y;
    private int angle;
    private int radius;

    public Coordinate(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public  Coordinate(int radius, int angle) {
        this.setAngle(angle);
        this.setRadius(radius);
    }

    /**
     * Calculate the y coordinate
     * @param radius in km
     * @param angle in degrees
     * @return the value of the y coordinate
     */

    private double calculateX(int radius, int angle) {
        double xCoordinate = Math.cos(Math.toRadians(angle)) * radius;
        // round 2 decimals
        return Math.round(xCoordinate*100.0)/100.0;
    }

    /**
     * Calculate the x coordinate
     * @param radius in km
     * @param angle in degrees
     * @return the value of the x coordinate
     */

    private double calculateY(int radius, int angle) {
        double yCoordinate = Math.sin(Math.toRadians(angle)) * radius;
        // round 2 decimals
        return Math.round(yCoordinate*100.0)/100.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public void setAngle(int angle) {
        this.angle = angle;
        this.setX(this.calculateX(radius, angle));
        this.setY(this.calculateY(radius, angle));
    }

    public void setRadius(int radius) {
        this.radius = radius;
        this.setX(this.calculateX(radius, angle));
        this.setY(this.calculateY(radius, angle));
    }

}
