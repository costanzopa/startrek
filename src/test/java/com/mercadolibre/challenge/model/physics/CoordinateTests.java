package com.mercadolibre.challenge.model.physics;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by costa on 15/9/2018.
 */
public class CoordinateTests {

    @Mock
    private Coordinate coordinate;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void getCoordinatesFromCartesianConstructor() {
        double x = 1;
        double y = 2;

        when(coordinate.getX()).thenReturn(x);
        when(coordinate.getY()).thenReturn(y);
        Coordinate testCoordinate = new Coordinate(1.0, 2.0);
        assertEquals(testCoordinate.getX(),coordinate.getX());
        assertEquals(testCoordinate.getY(),coordinate.getY());
    }


    @Test
    public void getCoordinatesFromPolarNineTyDegrees() {
        int radius          = 10;
        int angle           = 90;
        double x            =  0;
        double y            = 10;

        when(coordinate.getX()).thenReturn(x);
        when(coordinate.getY()).thenReturn(y);
        Coordinate testCoordinate = new Coordinate(radius, angle);
        assertEquals(testCoordinate.getX(),coordinate.getX());
        assertEquals(testCoordinate.getY(),coordinate.getY());
    }

    @Test
    public void getCoordinatesFromPolarMinusNineTyDegrees() {
        int radius          = 10;
        int angle           = -90;
        double x            =  0;
        double y            = -10;

        when(coordinate.getX()).thenReturn(x);
        when(coordinate.getY()).thenReturn(y);
        Coordinate testCoordinate = new Coordinate(radius, angle);
        assertEquals(testCoordinate.getX(),coordinate.getX());
        assertEquals(testCoordinate.getY(),coordinate.getY());
    }

    @Test
    public void comparateEqualsCartesianCoordinates() {
        int radius          = 10;
        int fistAngle       = -90;
        int secondAngle     = 270;
        double x            =  0;
        double y            = -10;

        Coordinate coordinateOne = new Coordinate(radius, fistAngle);
        Coordinate coordinateTwo = new Coordinate(radius, secondAngle);

        assertEquals(coordinateOne.getX(),coordinateTwo.getX());
        assertEquals(coordinateOne.getY(),coordinateTwo.getY());
    }


}
