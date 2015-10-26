/**
 * Test.java
 *
 * Version: 0.1
 *
 * 26.10.2015
 *
 * Copyright by danielmaclaughlin
 */
package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CoordinateTest {
    private final int NUMBEROFCHECKS = 250;

    @Rule
    public final ExpectedException expexc = ExpectedException.none();

    @SuppressWarnings("unused")
    @Test
    public void testCoordinateConstructor() {
	// test constructor with valid inputs
	for (int i = 0; i < NUMBEROFCHECKS; i++) {
	    double lat = Math.random() * 180 - 90;
	    double lon = Math.random() * 360 - 180;
	    Coordinate x = new Coordinate(lat, lon);
	    assertNotNull(x);
	}

	// test constructor with limits
	Coordinate a = new Coordinate(0.0, 0.0);
	Coordinate b = new Coordinate(90.0, 180.0);
	Coordinate c = new Coordinate(-90.0, -180.0);
	Coordinate d = new Coordinate(90.0, -180.0);
	Coordinate e = new Coordinate(-90.0, 180.0);
	assertNotNull(a);
	assertNotNull(b);
	assertNotNull(c);
	assertNotNull(d);
	assertNotNull(e);

	// test constructor out of limits
	expexc.expect(IllegalArgumentException.class);
	Coordinate f = new Coordinate(Double.NaN, Double.NaN);
	expexc.expect(IllegalArgumentException.class);
	Coordinate g = new Coordinate(Double.MIN_VALUE, Double.MAX_VALUE);
	expexc.expect(IllegalArgumentException.class);
	Coordinate h = new Coordinate(2000.0, -2000.0);
	expexc.expect(IllegalArgumentException.class);
	Coordinate i = new Coordinate(-2000.0, 2000.0);
    }

    @Test
    public void testCoordinateGetLatitude() {
	Coordinate a = new Coordinate(20.0, -20.0);
	assertEquals(a.getLatitude(), 20.0, 0.0);
    }

    @Test
    public void testCoordinateGetLongitude() {
	Coordinate a = new Coordinate(20.0, -20.0);
	assertEquals(a.getLongitude(), -20.0, 0.0);
    }

    @Test
    public void testCoordinateGetLatituinalDistance() {
	for (int i = 0; i < NUMBEROFCHECKS; i++) {
	    double lat1 = Math.random() * 180 - 90;
	    double lon1 = 0.0;
	    double lat2 = Math.random() * 180 - 90;
	    double lon2 = 0.0;
	    Coordinate x = new Coordinate(lat1, lon1);
	    Coordinate y = new Coordinate(lat2, lon2);
	    assertFalse(x.getLatitudinalDistance(y) > 90.0);
	    assertFalse(x.getLatitudinalDistance(y) < -90.0);
	}
    }

    @Test
    public void testCoordinateGetLongitudinalDistance() {
	for (int i = 0; i < NUMBEROFCHECKS; i++) {
	    double lat1 = 0.0;
	    double lon1 = Math.random() * 360 - 180;
	    double lat2 = 0.0;
	    double lon2 = Math.random() * 360 - 180;
	    Coordinate x = new Coordinate(lat1, lon1);
	    Coordinate y = new Coordinate(lat2, lon2);
	    assertFalse(x.getLongitudinalDistance(y) > 180.0);
	    assertFalse(x.getLongitudinalDistance(y) < -180.0);
	}
    }

    @Test
    public void testCoordinateGetDistance() {
	for (int i = 0; i < NUMBEROFCHECKS; i++) {
	    double lat1 = Math.random() * 180 - 90;
	    double lon1 = Math.random() * 360 - 180;
	    double lat2 = Math.random() * 180 - 90;
	    double lon2 = Math.random() * 360 - 180;
	    Coordinate x = new Coordinate(lat1, lon1);
	    Coordinate y = new Coordinate(lat2, lon2);
	    assertNotNull(x.getDistance(y));
	    assertFalse(x.getDistance(y).getLatitudinalDistance(y) > 90.0);
	    assertFalse(x.getDistance(y).getLatitudinalDistance(y) < -90.0);
	    assertFalse(x.getDistance(y).getLongitudinalDistance(y) > 180.0);
	    assertFalse(x.getDistance(y).getLongitudinalDistance(y) < -180.0);
	    // test getDistance method for invalid parameter
	    expexc.expect(IllegalArgumentException.class);
	    x.getDistance(null);
	}
    }

}
