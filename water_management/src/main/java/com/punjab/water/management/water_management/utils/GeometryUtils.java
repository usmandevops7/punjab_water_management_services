package com.punjab.water.management.water_management.utils;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;
import org.locationtech.jts.io.ParseException;

/**
 * Utility class for handling geometry operations with PostGIS
 */
public class GeometryUtils {

    private static final GeometryFactory geometryFactory = new GeometryFactory();
    private static final WKTReader wktReader = new WKTReader(geometryFactory);
    private static final WKTWriter wktWriter = new WKTWriter();

    /**
     * Convert WKT (Well-Known Text) string to Geometry object
     * @param wkt Well-Known Text representation of geometry
     * @return Geometry object
     * @throws ParseException if WKT is invalid
     */
    public static Geometry wktToGeometry(String wkt) throws ParseException {
        if (wkt == null || wkt.trim().isEmpty()) {
            return null;
        }
        return wktReader.read(wkt);
    }

    /**
     * Convert Geometry object to WKT (Well-Known Text) string
     * @param geometry Geometry object
     * @return WKT string representation
     */
    public static String geometryToWkt(Geometry geometry) {
        if (geometry == null) {
            return null;
        }
        return wktWriter.write(geometry);
    }

    /**
     * Create a polygon from coordinates
     * @param coordinates Array of coordinate pairs [x1,y1,x2,y2,...]
     * @return WKT string of the polygon
     */
    public static String createPolygonWkt(double[] coordinates) {
        if (coordinates == null || coordinates.length < 6) {
            throw new IllegalArgumentException("At least 3 points (6 coordinates) are required for a polygon");
        }

        StringBuilder wkt = new StringBuilder("POLYGON((");
        for (int i = 0; i < coordinates.length; i += 2) {
            if (i > 0) wkt.append(",");
            wkt.append(coordinates[i]).append(" ").append(coordinates[i + 1]);
        }
        // Close the polygon by repeating the first point
        wkt.append(",").append(coordinates[0]).append(" ").append(coordinates[1]);
        wkt.append("))");

        return wkt.toString();
    }

    /**
     * Validate if a WKT string represents a valid geometry
     * @param wkt Well-Known Text string
     * @return true if valid, false otherwise
     */
    public static boolean isValidWkt(String wkt) {
        try {
            wktToGeometry(wkt);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Calculate the area of a geometry in square meters
     * @param wkt Well-Known Text string
     * @return Area in square meters, or null if invalid
     */
    public static Double calculateArea(String wkt) {
        try {
            Geometry geometry = wktToGeometry(wkt);
            return geometry.getArea();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Check if two geometries intersect
     * @param wkt1 First geometry WKT
     * @param wkt2 Second geometry WKT
     * @return true if geometries intersect, false otherwise
     */
    public static boolean geometriesIntersect(String wkt1, String wkt2) {
        try {
            Geometry geom1 = wktToGeometry(wkt1);
            Geometry geom2 = wktToGeometry(wkt2);
            return geom1.intersects(geom2);
        } catch (ParseException e) {
            return false;
        }
    }
}
