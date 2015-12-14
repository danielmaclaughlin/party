/**
 * CartesianCoordinate.java
 *
 * Version: 0.1
 *
 * 09.11.2015
 *
 * Copyright by danielmaclaughlin
 */

package org.wahlzeit.model;

import java.io.Serializable;

import org.wahlzeit.model.CoordinateManager.CoordinateType;

public class CartesianCoordinate extends AbstractCoordinate implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1973018372329860096L;
    
    private final CoordinateType type = CoordinateType.CARTESIAN;
    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    /**
     * @return the x
     */
    public double getX() {
	return x;
    }

    /**
     * @return the y
     */
    public double getY() {
	return y;
    }

    /**
     * @return the z
     */
    public double getZ() {
	return z;
    }

    /**
     * @param x
     *            the x to set
     */
    private void setX(double x) {
	this.x = x;
    }

    /**
     * @param y
     *            the y to set
     */
    private void setY(double y) {
	this.y = y;
    }

    /**
     * @param z
     *            the z to set
     */
    private void setZ(double z) {
	this.z = z;
    }

    /**
     * @return the type
     */
    public CoordinateType getCoordinateType() {
	return type;
    }

    /*
     * @see
     * org.wahlzeit.model.AbstractCoordinate#getDistance(org.wahlzeit.model.
     * Coordinate)
     */
    @Override
    public double getDistance(Coordinate to) {
	return CoordinateManager.getInstance().getDistanceBetween(this, to);
    }

    /**
     * @param to
     * @return
     */
    public double getDistance(CartesianCoordinate to) {
	return Math.abs(Math.sqrt(
		Math.pow(to.getX() - this.x, 2) + Math.pow(to.getY() - this.y, 2) + Math.pow(to.getZ() - this.z, 2)));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wahlzeit.model.AbstractCoordinate#isEqual(org.wahlzeit.model.
     * Coordinate)
     */
    @Override
    public boolean isEqual(Coordinate other) {
	return CoordinateManager.getInstance().areEqual(this, other);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	return CoordinateManager.getInstance().calculateHashCodeForCoordinate(this);
    }
    

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	CartesianCoordinate other = (CartesianCoordinate) obj;
	if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
	    return false;
	}
	if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
	    return false;
	}
	if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z)) {
	    return false;
	}
	return true;
    }

}
