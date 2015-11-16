/**
 * Coordinate.java
 *
 * Version: 0.3
 *
 * 26.10.2015
 *
 * Copyright by danielmaclaughlin
 */
package org.wahlzeit.model;

import org.wahlzeit.model.CoordinateManager.CoordinateType;

public interface Coordinate {
    /**
     * @param to
     *            - destination
     * @return - distance to destination
     */
    public double getDistance(Coordinate to);

    /**
     * @param to
     *            - other Coordinate
     * @return true if the distance to the given Coordinate is greater than
     *         EQALITYEPSILON defined in
     * @see org.wahlzeit.model.CoordinateManager
     */
    public boolean isEqual(Coordinate to);

    /**
     * @return - Type of a Coordinate (spheric/cartesian) 
     * @see org.wahlzeit.model.CoordinateManager.CoordinateType
     */
    public CoordinateType getCoordinateType();
}
