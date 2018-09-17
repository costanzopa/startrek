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
public class SunTests {

    @Mock
    private Sun sunMock;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void tddForCreatingSunPropertiesAssertTrue() {
        Coordinate initPosition = new Coordinate(0.0,0.0);
        String name   = "Sun";
        int angularSpeed   = 0;

        when(sunMock.getName()).thenReturn(name);
        when(sunMock.getAngularSpeed()).thenReturn(angularSpeed);
        when(sunMock.getCoordinate()).thenReturn(initPosition);

        CelestialBody sun = new Sun();
        assertEquals(sun.getName(), sunMock.getName());
        assertEquals(sun.getCoordinate().getX(), sunMock.getCoordinate().getX());
        assertEquals(sun.getCoordinate().getY(), sunMock.getCoordinate().getY());
        assertEquals(sun.getAngularSpeed(), sunMock.getAngularSpeed());
    }


    @Test
    public void sunShouldNotMoveAssert() {
        CelestialBody sun = new Sun();
        sun.getLocation(90);
        Coordinate expected   = new Coordinate(0, 0);
        assertEquals(sun.getCoordinate().getX(), expected.getX());
        assertEquals(sun.getCoordinate().getY(), expected.getY());
    }
}
