/**
 * SphericCoordinate.java
 *
 * Version: 0.4
 *
 * 26.10.2015
 *
 * Copyright by danielmaclaughlin
 */
package org.wahlzeit.model;

import java.io.Serializable;

import org.wahlzeit.model.CoordinateManager.CoordinateType;

public class SphericCoordinate extends AbstractCoordinate implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7244110068435642350L;
    
    private final CoordinateType type = CoordinateType.SPHERIC;
    private double latitude = Double.MIN_VALUE;
    private double longitude = Double.MIN_VALUE;
    private double radius = 6371.0d;

    /**
     * Constructs new coordinate with
     * 
     * @methodtype constructor
     * @param latitude
     * @param longitude
     * @throws IllegalArgumentException
     *             if any given Parameter is invalid;
     */
    public SphericCoordinate(double latitude, double longitude) throws IllegalArgumentException {
	if (latitude < -90.0 || latitude > 90.0) {
	    throw new IllegalArgumentException("The given value for latitude is out of range [-90.0;+90.0]");
	}
	if (longitude < -180.0 || longitude > 180.0) {
	    throw new IllegalArgumentException("The given value for longitude is out of range [-180.0;+180.0]");
	}
	if (Double.isNaN(latitude) || Double.isNaN(longitude)) {
	    throw new IllegalArgumentException("Latitude or longitude must not be Double.NaN");
	}
	this.latitude = latitude;
	this.longitude = longitude;
    }
    

    /**
     * @return the CoordinateType
     */
    public CoordinateType getCoordinateType() {
	return type;
    }

    /**
     * @methodtype get
     * @return latitude
     */
    public double getLatitude() {
	return this.latitude;
    }

    /**
     * @methodtype get
     * @return longitude
     */
    public double getLongitude() {
	return this.longitude;
    }

    /**
     * @methodtype get
     * @return the radius
     */
    public double getRadius() {
	return radius;
    }

    @Override
    public double getDistance(Coordinate to) {
	return CoordinateManager.getInstance().getDistanceBetween(this, to);
    }

    /**
     * @methodtype get:
     * @param to
     *            the destination
     * @return
     * @throws IllegalArgumentException
     *             if to is null
     */
    public double getDistance(SphericCoordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	return radius
		* Math.acos(Math.sin(Math.toRadians(this.latitude)) * Math.sin(Math.toRadians(to.getLatitude()))
			+ Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(to.getLatitude()))
				* Math.cos(Math.toRadians(to.getLongitude()) - Math.toRadians(this.longitude)))
		* Math.PI / 180.0d;
    }

    /**
     * @methodtype set
     * @param latitude
     * @throws IllegalArgumentException
     *             if latitude is lower than -90.0d, greater than 90.0d, or
     *             equals Double.NaN
     */
    private void setLatitude(double latitude) throws IllegalArgumentException {
	if (latitude < -90.0 || latitude > 90.0) {
	    throw new IllegalArgumentException("The given value for latitude is out of range [-90.0;+90.0]");
	}
	if (Double.isNaN(latitude)) {
	    throw new IllegalArgumentException("Latitude must not be Double.NaN");
	}
	this.latitude = latitude;
    }

    /**
     * @methodtype set
     * @param longitude
     * @throws IllegalArgumentException
     *             if longitude is lower than -180.0d, greater than 180.0d, or
     *             equals Double.NaN
     */
    private void setLongitude(double longitude) throws IllegalArgumentException {
	if (longitude < -180.0 || longitude > 180.0) {
	    throw new IllegalArgumentException("The given value for longitude is out of range [-180.0;+180.0]");
	}
	if (Double.isNaN(longitude)) {
	    throw new IllegalArgumentException("Longitude must not be Double.NaN");
	}
	this.longitude = longitude;
    }

    /**
     * @methodtype set
     * @param radius
     *            the radius to set
     * @throws IllegalArgumentException
     *             the radius may not be negative
     */
    private void setRadius(double radius) {
	if (radius > 0) {
	    this.radius = radius;
	} else {
	    throw new IllegalArgumentException("Radius has to be greater than 0");
	}
    }

    /* (non-Javadoc)
     * @see org.wahlzeit.model.AbstractCoordinate#isEqual(org.wahlzeit.model.Coordinate)
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
	return CoordinateManager.getInstance().areEqual(this, coordinate);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int myHashCode() {
	return hashCode();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	return CoordinateManager.getInstance().calculateHashCodeForCoordinate(this);
    }

    /* (non-Javadoc)
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
	SphericCoordinate other = (SphericCoordinate) obj;
	if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude)) {
	    return false;
	}
	if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude)) {
	    return false;
	}
	if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
	    return false;
	}
	return true;
    }

}


