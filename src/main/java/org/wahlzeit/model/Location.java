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
	public Coordinate coordinate = null;

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
		this(name, new Coordinate(latitude, longitude));
	}

	/**
	 * Constructs new location with
	 * 
	 * @methodtype constructor
	 * @param latitude
	 * @param longitude
	 */
	public Location(double latitude, double longitude) {
		this.coordinate = new Coordinate(latitude, longitude);
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
