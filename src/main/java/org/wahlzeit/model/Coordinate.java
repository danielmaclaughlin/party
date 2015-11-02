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

public class Coordinate {
    private double latitude = Double.MIN_VALUE;
    private double longitude = Double.MIN_VALUE;
    final double RADIUS = 6371.0d;

    /**
     * Constructs new coordinate with
     * 
     * @methodtype constructor
     * @param latitude
     * @param longitude
     * @throws IllegalArgumentException
     *             if any given Parameter is invalid;
     */
    public Coordinate(double latitude, double longitude) throws IllegalArgumentException {
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
     * @methodtype get:
     * @param to
     *            the destination
     * @return
     * @throws IllegalArgumentException
     *             if to is null
     */
    public double getDistance(Coordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	return RADIUS * Math.acos(Math.sin(this.latitude) * Math.sin(to.getLatitude())
		+ Math.cos(this.latitude) * Math.cos(to.getLatitude()) * Math.cos(to.getLongitude() - this.longitude))
		* Math.PI / 180.0d;
    }

    /**
     * @methodtype get
     * @param to
     *            the destination
     * @return own distance to the destination
     * @throws IllegalArgumentException
     *             if to is null
     */
    public double getLatitudinalDistance(Coordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	double distance = to.getLatitude() - this.latitude;
	if (Math.abs(distance) > 90) {
	    distance = (distance < 0) ? distance + 180 : distance - 180;
	}
	return Math.abs(distance);
    }

    /**
     * @methodtype get
     * @param to
     * @return own distance to the destination
     * @throws IllegalArgumentException
     *             if to is null
     */
    public double getLongitudinalDistance(Coordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	double distance = to.getLongitude() - this.longitude;
	if (Math.abs(distance) > 180) {
	    distance = (distance < 0) ? distance + 360 : distance - 360;
	}
	return Math.abs(distance);
    }

    /**
     * @methodtype set
     * @param latitude
     * @throws IllegalArgumentException
     *             if latitude is lower than -90.0d, greater than 90.0d, or
     *             equals Double.NaN
     */
    public void setLatitude(double latitude) throws IllegalArgumentException {
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
    public void setLongitude(double longitude) throws IllegalArgumentException {
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
     * @param latitude
     * @param longitude
     * @throws IllegalArgumentException
     *             if any given Parameter is invalid;
     */
    public void setCoordinate(double latitude, double longitude) throws IllegalArgumentException {
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
     * @methodtype conversion
     * @return the String representation of a Coordinate "[latitude, longitude]"
     */
    @Override
    public String toString() {
	return "[" + this.latitude + ", " + this.longitude + "]";
    }

    /**
     * @methodype comparison
     * @return true if equal, false if not.
     */
    @Override
    public boolean equals(Object object) {
	if (this.hashCode() == object.hashCode())
	    return true;
	if (object == null)
	    return false;
	Coordinate obj = (Coordinate) object;
	if (Double.compare(obj.latitude, latitude) != 0)
	    return false;
	if (Double.compare(obj.longitude, longitude) != 0)
	    return false;
	return true;
    }

    /**
     * @methodtype comparison
     * @return unique identifier for a single Object.
     */
    @Override
    public int hashCode() {
	return Double.valueOf(this.latitude * 2).hashCode() + Double.valueOf(this.longitude * 61).hashCode();
    }
}
