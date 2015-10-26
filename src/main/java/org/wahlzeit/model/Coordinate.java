/**
 * Coordinate.java
 *
 * Version: 0.1
 *
 * 26.10.2015
 *
 * Copyright by danielmaclaughlin
 */
package org.wahlzeit.model;

/*
 * This Class handles the location-information for a photo.
 */
public class Coordinate {
    private double latitude = Double.MIN_VALUE;
    private double longitude = Double.MIN_VALUE;

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

    public double getLatitude() {
	return this.latitude;
    }

    public double getLongitude() {
	return this.longitude;
    }

    public Coordinate getDistance(Coordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	return new Coordinate(getLatitudinalDistance(to), getLongitudinalDistance(to));
    }

    public double getLatitudinalDistance(Coordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	double distance = to.getLatitude() - this.latitude;
	if (Math.abs(distance) > 90) {
	    distance = (distance < 0) ? distance + 180 : distance - 180;
	}
	return distance;
    }

    public double getLongitudinalDistance(Coordinate to) throws IllegalArgumentException {
	if (to == null)
	    throw new IllegalArgumentException("The destination coordinate cannot be null");
	double distance = to.getLongitude() - this.longitude;
	if (Math.abs(distance) > 180) {
	    distance = (distance < 0) ? distance + 360 : distance - 360;
	}
	return distance;
    }

    /*
     * Just in case these setter-functions may be necessary in the future.
     */

    // public void setLatitude(double latitude) {
    // this.latitude = latitude;
    // }
    //
    // public void setLongitude(double longitude) {
    // this.longitude = longitude;
    // }
    //
    // public void setCoordinate(double latitude, double longitude) {
    // this.latitude = latitude;
    // this.longitude = longitude;
    // }

}
