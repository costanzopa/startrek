package com.mercadolibre.challenge.model.entities;

import com.mercadolibre.challenge.model.physics.Coordinate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by costa on 16/9/2018.
 * To Practice TDD
 */
public class PlanetTests {

    @Mock
    private Planet planet;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void tddForCreatingPlanetsPropertiesAssertTrue() {
        Coordinate initPosition = new Coordinate(1.0,2.0);
        String name   = "Ferengi";
        int angularSpeed   = -1;

        when(planet.getName()).thenReturn(name);
        when(planet.getAngularSpeed()).thenReturn(angularSpeed);
        when(planet.getCoordinate()).thenReturn(initPosition);

        CelestialBody ferengi = new Planet(name, initPosition,angularSpeed);
        assertEquals(ferengi.getName(), planet.getName());
        assertEquals(ferengi.getCoordinate().getX(), planet.getCoordinate().getX());
        assertEquals(ferengi.getCoordinate().getY(), planet.getCoordinate().getY());
        assertEquals(ferengi.getAngularSpeed(), planet.getAngularSpeed());
    }

    @Test
    public void moveAPlanet90DaysGetLocationAssert() {
        Coordinate initPosition = new Coordinate(20,0);
        String name             = "Ferengi";
        int angularSpeed        = -1;

        CelestialBody ferengi = new Planet(name, initPosition,angularSpeed);
        ferengi.getLocation(90);
        Coordinate expected   = new Coordinate(20, -90);
        assertEquals(ferengi.getCoordinate().getX(), expected.getX());
        assertEquals(ferengi.getCoordinate().getY(), expected.getY());
    }



}
