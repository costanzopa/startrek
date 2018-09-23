package com.mercadolibre.challenge.model.physics;

import java.util.List;

/**
 * Created by Pablo Costanzo on 15/9/2018.
 * Utils for the physics solution problems.
 */
public class PhysicsUtil {

    /**
     *
     * @param c1 x1,y1
     * @param c2 x2,y2
     * @return distance in km of the 2 coordinates
     */
    public static double calculateDistance(Coordinate c1, Coordinate c2) {
        return Math.sqrt( Math.pow( (c1.getX() - c2.getX()), 2 ) + Math.pow( (c1.getY() - c2.getY()), 2 ));
    }

    /**
     * Calculates the perimeter of a triangle
     * @param coordinates coordinates of in R2
     * @return the perimeter of a tringle round 2 decimals.
     */

    public static double calculatePerimeterOfATriangle(List<Coordinate> coordinates) {
        double perimeter = 0.0;

        if (coordinates != null && coordinates.size() == 3) {
            double firstDistance = calculateDistance(coordinates.get(0), coordinates.get(1));
            double secondDistance = calculateDistance(coordinates.get(1), coordinates.get(2));
            double thirdDistance = calculateDistance(coordinates.get(0), coordinates.get(2));
            perimeter += firstDistance + secondDistance + thirdDistance;
        }

        return Math.round(perimeter*100.0)/100.0;
    }

    /**
     * Verify if three points are collinear
     * @param coordinates coordinates of in R2
     * @return true if ar collinear, false if they ar not
     */

    public static boolean areCollinear(List<Coordinate> coordinates) {
        boolean collinear = false;
        if (coordinates != null && coordinates.size() == 3) {
            double verify = (coordinates.get(0).getX() * (coordinates.get(1).getY() - coordinates.get(2).getY())) +
                    (coordinates.get(1).getX() * (coordinates.get(2).getY() - coordinates.get(0).getY())) +
                    (coordinates.get(2).getX() * (coordinates.get(0).getY() - coordinates.get(1).getY()));

            if (verify == 0.00) {
                collinear = true;
            }
        }
        return collinear;
    }

    /**
     *
     * @param triangle Three coordinates in R2 that conform a triangle
     * @param coordinate R2 point to verify
     * @return true if its inside the triangle not if it is not
     */

    public static boolean isInsideTheTriangle(List<Coordinate> triangle, Coordinate coordinate) {
        boolean isInside = false;

        if (triangle != null && triangle.size() == 3 && coordinate != null) {
            boolean b1, b2, b3;

            b1 = sign(coordinate, triangle.get(0), triangle.get(1)) < 0.00f;
            b2 = sign(coordinate, triangle.get(1), triangle.get(2)) < 0.00f;
            b3 = sign(coordinate, triangle.get(2), triangle.get(0)) < 0.00f;

            isInside = ((b1 == b2) && (b2 == b3));
        }

        return isInside;
    }


    private static double sign(Coordinate c1, Coordinate c2, Coordinate c3) {
        return (c1.getX() - c3.getX()) * (c2.getY() - c3.getY()) - (c2.getX() - c3.getX()) * (c1.getY() - c3.getY());
    }


}
