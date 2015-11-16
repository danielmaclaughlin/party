/**
 * Location.java
 * 
 * Version: 0.1
 *
 * 02.11.2015
 *
 * Copyright by danielmaclaughlin
 */
package org.wahlzeit.model;

public class Location {
    private String name = null;
    private Coordinate coordinate = null;
    private static CoordinateManager coordMan = CoordinateManager.getInstance();

    /**
     * Constructs new location with
     * 
     * @methodtype constructor
     * @param name
     */
    public Location(String name) {
	this.name = name;
    }

    /**
     * Constructs new location with
     * 
     * @methodtype constructor
     * @param name
     * @param coordinate
     */
    public Location(String name, Coordinate coordinate) {
	this.name = name;
	this.coordinate = coordinate;
    }

    /**
     * Constructs new location with
     * 
     * @methodtype constructor
     * @param name
     * @param latitude
     * @param longitude
     */
    public Location(String name, double latitude, double longitude) {
	this(name, coordMan.getNewCoordinate(CoordinateManager.CoordinateType.SPHERIC, latitude, longitude));
    }

    /**
     * Constructs new location with
     * 
     * @methodtype constructor
     * @param latitude
     * @param longitude
     */
    public Location(double latitude, double longitude) {
	this.setCoordinate(coordMan.getNewCoordinate(CoordinateManager.CoordinateType.SPHERIC, latitude, longitude));
    }

    /**
     * Constructs new location with
     * 
     * @methodtype constructor
     * @param name
     * @param x
     * @param y
     * @param z
     */
    public Location(String name, double x, double y, double z) {
	this(name, coordMan.getNewCoordinate(CoordinateManager.CoordinateType.CARTESIAN, x, y, z));
    }

    /**
     * Constructs new location with
     * 
     * @methodtype constructor
     * @param latitude
     * @param longitude
     */
    public Location(double x, double y, double z) {
	this.setCoordinate(coordMan.getNewCoordinate(CoordinateManager.CoordinateType.CARTESIAN, x, y, z));
    }

    /**
     * @return the coordinate
     */
    public Coordinate getCoordinate() {
	return coordinate;
    }

    /**
     * @param coordinate
     *            the coordinate to set
     */
    public void setCoordinate(Coordinate coordinate) {
	this.coordinate = coordinate;
    }

    /**
     * @methodtype get
     * @return Name of Location
     */
    public String getName() {
	return this.name;
    }

    @Override
    /**
     * @methodtype conversion
     * @return String representation of location (name)
     */
    public String toString() {
	return this.name;
    }
}
