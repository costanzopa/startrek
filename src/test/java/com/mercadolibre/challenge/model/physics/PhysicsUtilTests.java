package com.mercadolibre.challenge.model.physics;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by costa on 15/9/2018.
 */
public class PhysicsUtilTests {

    @Mock
    private PhysicsUtil util;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void getDistanceWithAngleZeroDegrees() {
        Coordinate c1 = new Coordinate(300, 0);
        Coordinate c2 = new Coordinate(500, 0);

        double expectedValue = 200.0;
        double distance = PhysicsUtil.calculateDistance(c1, c2);

        assertEquals(expectedValue, distance);

    }

    @Test
    public void getDistanceWithAngle90Degrees() {
        Coordinate c1 = new Coordinate(500, 90);
        Coordinate c2 = new Coordinate(100, 90);

        double expectedValue = 400.0;
        double distance = PhysicsUtil.calculateDistance(c1, c2);

        assertEquals(expectedValue, distance);

    }


    @Test
    public void getDistanceWithAngle90Degrees45Degrees() {
        Coordinate c1 = new Coordinate(500, 90);
        Coordinate c2 = new Coordinate(300.0, 500.0);

        double expectedValue = 300.0;
        double distance = PhysicsUtil.calculateDistance(c1, c2);

        assertEquals(expectedValue, distance);
    }

    @Test
    public void getPerimiterZeroDegrees90Degree180Degrees() {
        Coordinate c1 = new Coordinate(500, 0);
        Coordinate c2 = new Coordinate(500, 90);
        Coordinate c3 = new Coordinate(500, 180);
        List<Coordinate> list = new ArrayList<Coordinate>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        double expectedValue = 2414.21;
        double perimeter = PhysicsUtil.calculatePerimeterOfATriangle(list);

        assertEquals(expectedValue, perimeter);
    }


    @Test
    public void verifyAreCollinearTrue() {
        Coordinate c1 = new Coordinate(500, 90);
        Coordinate c2 = new Coordinate(300, -90);
        Coordinate c3 = new Coordinate(100, 90);
        List<Coordinate> list = new ArrayList<Coordinate>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        boolean expectedValue = true;
        boolean collinear = PhysicsUtil.areCollinear(list);

        assertEquals(expectedValue, collinear);
    }

    @Test
    public void verifyAreCollinearFalse() {
        Coordinate c1 = new Coordinate(500, 180);
        Coordinate c2 = new Coordinate(300, -90);
        Coordinate c3 = new Coordinate(100, 90);
        List<Coordinate> list = new ArrayList<Coordinate>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        boolean collinear = PhysicsUtil.areCollinear(list);

        assertFalse(collinear);
    }

    @Test
    public void verifyAreCollinearCartesianTrue() {
        Coordinate c1 = new Coordinate(1.0,1.0);
        Coordinate c2 = new Coordinate(1.0, 4.0);
        Coordinate c3 = new Coordinate(1.0, 5.0);
        List<Coordinate> list = new ArrayList<Coordinate>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        boolean expectedValue = true;
        boolean collinear = PhysicsUtil.areCollinear(list);

        assertEquals(expectedValue, collinear);
    }


    @Test
    public void verifyIfPointIsInsideTheTriangleTrue() {
        Coordinate coordinate = new Coordinate(0.0, 1.0);
        Coordinate c1 = new Coordinate(2.0, 0.0);
        Coordinate c2 = new Coordinate(-2.0, 0.0);
        Coordinate c3 = new Coordinate(0.0, 2.0);
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(c1);
        coordinates.add(c2);
        coordinates.add(c3);

        boolean inside = PhysicsUtil.isInsideTheTriangle(coordinates, coordinate);

        assertTrue(inside);
    }


    @Test
    public void verifyIfCoordinatesIsInsideTheTriangleFalse(){
        Coordinate coordinate = new Coordinate(0.0, 25.0);
        Coordinate c1 = new Coordinate(12.0, 0.0);
        Coordinate c2 = new Coordinate(-22.0, 0.0);
        Coordinate c3 = new Coordinate(0.0, 22.0);
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(c1);
        coordinates.add(c2);
        coordinates.add(c3);

        boolean inside = PhysicsUtil.isInsideTheTriangle(coordinates, coordinate);

        assertFalse(inside);
    }

    @Test
    public void verifyIfCoordinatesPolarIsInsideTheTriangleFalse(){
        Coordinate coordinate = new Coordinate(0, 0);
        Coordinate c1 = new Coordinate(2.0, 0.0);
        Coordinate c2 = new Coordinate(-2.0, 0.0);
        Coordinate c3 = new Coordinate(0.0, 2.0);
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(c1);
        coordinates.add(c2);
        coordinates.add(c3);

        boolean inside = PhysicsUtil.isInsideTheTriangle(coordinates, coordinate);

        assertFalse(inside);
    }


}
