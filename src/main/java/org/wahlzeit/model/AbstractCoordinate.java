/**
 * AbstractCoordinate.java
 *
 * Version: 0.1
 *
 * 16.11.2015
 *
 * Copyright by danielmaclaughlin
 */

package org.wahlzeit.model;

import org.wahlzeit.model.CoordinateManager.CoordinateType;

public abstract class AbstractCoordinate implements Coordinate{
    /* (non-Javadoc)
     * @see org.wahlzeit.model.Coordinate#getDistance(org.wahlzeit.model.Coordinate)
     */
    public abstract double getDistance(Coordinate coordinate);
    public abstract boolean isEqual (Coordinate coordinate);
    public abstract CoordinateType getCoordinateType();
}
