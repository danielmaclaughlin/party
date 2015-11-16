/**
 * CoordinateManager.java
 *
 * Version: 
 *
 * 16.11.2015
 *
 * Copyright by danielmaclaughlin
 */

package org.wahlzeit.model;

/**
 * CoordinateManager.java
 * 
 * Version: 0.1
 * 
 * 16.11.2015
 * 
 * Copyright by danielmaclaughlin
 * 
 * The CoordinateManager instance cares of all types of coordinates and serves
 * methods for creating converting and comparing between the different types of
 * coordinates. Every coordinate type class has to serve a function for
 * computing distance between two coordinates of its type. the rest is done
 * here.
 */
public class CoordinateManager implements Coordinate {
    /**
     * A coordinate can has CoordinateType.SPHERIC or CoordinateType.CARTESIAN.
     * If getting the type returns null you are probably trying to operate on
     * the CoordinateManager instance.
     */
    public enum CoordinateType {
	SPHERIC, CARTESIAN
    };

    private final double EQUALITYEPSILON = 0.01;

    protected static final CoordinateManager instance = new CoordinateManager();

    public static final CoordinateManager getInstance() {
	return instance;
    }

    /**
     * @param type
     *            - specify desired type of coordinate
     * @param args
     *            - insert [latitude, longitude] in degrees for spheric
     *            coordinate, and [x,y,z] for cartesian coordinate
     * @return new coordinate of the desired type
     */
    public Coordinate getNewCoordinate(CoordinateType type, double... args) {
	if (type == CoordinateType.SPHERIC) {
	    return new SphericCoordinate(args[0], args[1]);
	}
	if (type == CoordinateType.CARTESIAN) {
	    return new CartesianCoordinate(args[0], args[1], args[2]);
	} else {
	    return null;
	}
    }

    /**
     * Two coordinates are equal as long as their distance is smaller than
     * EQUALITYEPSILON
     * 
     * @param one
     * @param two
     * @return
     */
    public boolean areEqual(Coordinate one, Coordinate two) {
	if (getDistanceBetween(one, two) <= EQUALITYEPSILON) {
	    return true;
	}
	return false;
    }

    /**
     * returns the distance between two coordinates
     * 
     * @param one
     * @param two
     * @return
     */
    public double getDistanceBetween(Coordinate one, Coordinate two) {
	if (one.getCoordinateType() == CoordinateType.SPHERIC) {
	    if (two.getCoordinateType() == CoordinateType.SPHERIC) {
		return calculateDistanceEQ(one, two);
	    }
	    if (two.getCoordinateType() == CoordinateType.CARTESIAN) {
		return calculateDistanceNE(one, two);
	    }
	}
	if (one.getCoordinateType() == CoordinateType.CARTESIAN) {
	    if (two.getCoordinateType() == CoordinateType.SPHERIC) {
		return calculateDistanceNE(one, two);
	    }
	    if (two.getCoordinateType() == CoordinateType.CARTESIAN) {
		return calculateDistanceEQ(one, two);
	    }
	}
	// should never be reached
	return -1;
    }

    /**
     * Calculate Distance between two coordinates of same types
     * 
     * @param one
     * @param two
     * @return the distance of two coordinates of the same type.
     */
    private double calculateDistanceEQ(Coordinate one, Coordinate two) {
	assert (one.getCoordinateType() == two.getCoordinateType());
	return one.getDistance(two);
    }

    /**
     * Calculate Distance between two coordinates of different types
     * 
     * @param one
     * @param two
     * @return the distance of two coordinates of different types
     */
    private double calculateDistanceNE(Coordinate one, Coordinate two) {
	return one.getDistance(convertCoordinate(two, CoordinateType.SPHERIC));
    }

    /**
     * @param coordinate
     *            the coordinate to convert
     * @param to
     *            the target CoordinateType
     * @return new instance representing the @coordinate in the desired @type
     */
    private Coordinate convertCoordinate(Coordinate coordinate, CoordinateType to) {
	if (to == CoordinateType.SPHERIC) {
	    assert (coordinate.getCoordinateType() == CoordinateType.CARTESIAN);
	    CartesianCoordinate c = (CartesianCoordinate) coordinate;
	    double latitudeRad = Math.atan2(c.getZ(), Math.sqrt(Math.pow(c.getX(), 2) + Math.pow(c.getY(), 2)));
	    double longitudeRad = Math.atan2(c.getY(), c.getX());
	    return new SphericCoordinate(Math.toDegrees(latitudeRad), Math.toDegrees(longitudeRad));
	}
	if (to == CoordinateType.CARTESIAN) {
	    assert (coordinate.getCoordinateType() == CoordinateType.SPHERIC);
	    SphericCoordinate s = (SphericCoordinate) coordinate;
	    double x = Math.cos(Math.toRadians(s.getLatitude())) * Math.cos(Math.toRadians(s.getLongitude()));
	    double y = Math.cos(Math.toRadians(s.getLatitude())) * Math.sin(Math.toRadians(s.getLongitude()));
	    double z = Math.sin(Math.toRadians(s.getLatitude()));
	    return new CartesianCoordinate(x, y, z);
	}
	// should never be reached
	return null;
    }

    /**
     * @return always null for a CoordinateManager instance
     */
    @Override
    public CoordinateType getCoordinateType() {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * @return always -1 for a CoordinateManager instance
     */
    @Override
    public double getDistance(Coordinate to) {
	// TODO Auto-generated method stub
	return -1;
    }

    /**
     * @return always false for a CoordinateManager instance
     */
    @Override
    public boolean isEqual(Coordinate to) {
	// TODO Auto-generated method stub
	return false;
    }
}
