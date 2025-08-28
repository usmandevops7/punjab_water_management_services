package com.punjab.water.management.water_management.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUTMToLatLong {

    public static void main(String[] args) {
        String inputFile = "C:\\projects\\Punjab_Agri_Water_Management\\Documents\\Branch_Canal.xlsx";
        String outputFile = "C:\\projects\\Punjab_Agri_Water_Management\\Documents\\Branch_Canal_Modified.xlsx";
        int zone = 42; // UTM Zone for Rahimyar Khan, Pakistan
        boolean isNorthern = true; // Northern Hemisphere

        try (FileInputStream fis = new FileInputStream(inputFile)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Branch_Canal"); // Sheet name from the document

            if (sheet == null) {
                System.out.println("Sheet 'Branch_Canal' not found.");
                return;
            }

            // Process each row
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                int lastCellNum = row.getLastCellNum();

                if (rowIndex == 0) {
                    // Add headers for LAT and LONG
                    Cell latHeader = row.createCell(lastCellNum);
                    latHeader.setCellValue("LAT");

                    Cell longHeader = row.createCell(lastCellNum + 1);
                    longHeader.setCellValue("LONG");
                } else {
                    // Get X (easting) and Y (northing) from columns 0 and 1
                    Cell xCell = row.getCell(0);
                    Cell yCell = row.getCell(1);

                    if (xCell == null || yCell == null) {
                        continue; // Skip rows with null cells
                    }

                    // Try to get numeric values from cells (handle both numeric and string types)
                    double easting, northing;
                    try {
                        easting = getNumericValue(xCell);
                        northing = getNumericValue(yCell);
                    } catch (NumberFormatException e) {
                        continue; // Skip rows with non-numeric values
                    }

                    // Convert UTM to Lat/Long
                    double[] latLong = utmToLatLong(easting, northing, zone, isNorthern);

                    // Add LAT and LONG to new columns
                    Cell latCell = row.createCell(lastCellNum);
                    latCell.setCellValue(latLong[0]);

                    Cell longCell = row.createCell(lastCellNum + 1);
                    longCell.setCellValue(latLong[1]);
                }
            }

            // Write to output file
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbook.write(fos);
            }

            System.out.println("Conversion complete. Output saved to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts UTM coordinates to Latitude and Longitude using WGS84 datum.
     *
     * @param easting Easting (X) in meters
     * @param northing Northing (Y) in meters
     * @param zone UTM zone
     * @param isNorthern True if northern hemisphere, false if southern
     * @return double[] {latitude, longitude} in degrees
     */
    public static double[] utmToLatLong(double easting, double northing, int zone, boolean isNorthern) {
        double a = 6378137.0; // Semi-major axis
        double f = 1.0 / 298.257223563; // Flattening
        double b = a * (1 - f); // Semi-minor axis
        double e2 = 2 * f - f * f; // Eccentricity squared
        double eprime2 = e2 / (1 - e2); // Second eccentricity squared
        double k0 = 0.9996; // Scale factor
        double lon0 = (zone * 6) - 183; // Central meridian in degrees
        double N0 = isNorthern ? 0.0 : 10000000.0; // False northing
        double E0 = 0.0; // False easting (set to 0 based on data analysis)

        double x = easting - E0;
        double y = northing - N0;

        double M = y / k0;
        double mu = M / (a * (1 - e2 / 4 - 3 * e2 * e2 / 64 - 5 * e2 * e2 * e2 / 256));

        double e1 = (1 - Math.sqrt(1 - e2)) / (1 + Math.sqrt(1 - e2));
        double phi1 = mu + (3 * e1 / 2 - 27 * e1 * e1 * e1 / 32) * Math.sin(2 * mu)
                + (21 * e1 * e1 / 16 - 55 * e1 * e1 * e1 * e1 / 32) * Math.sin(4 * mu)
                + (151 * e1 * e1 * e1 / 96) * Math.sin(6 * mu)
                + (1097 * e1 * e1 * e1 * e1 / 512) * Math.sin(8 * mu);

        double C1 = eprime2 * Math.pow(Math.cos(phi1), 2);
        double T1 = Math.pow(Math.tan(phi1), 2);
        double N1 = a / Math.sqrt(1 - e2 * Math.pow(Math.sin(phi1), 2));
        double R1 = a * (1 - e2) / Math.pow(1 - e2 * Math.pow(Math.sin(phi1), 2), 1.5);
        double D = x / (N1 * k0);

        double latRad = phi1 - (N1 * Math.tan(phi1) / R1)
                * (Math.pow(D, 2) / 2 - (5 + 3 * T1 + 10 * C1 - 4 * Math.pow(C1, 2) - 9 * eprime2) * Math.pow(D, 4) / 24
                + (61 + 90 * T1 + 298 * C1 + 45 * Math.pow(T1, 2) - 252 * eprime2 - 3 * Math.pow(C1, 2))
                * Math.pow(D, 6) / 720);

        double latitude = Math.toDegrees(latRad);

        double lonRad = (D - (1 + 2 * T1 + C1) * Math.pow(D, 3) / 6
                + (5 - 2 * C1 + 28 * T1 - 3 * Math.pow(C1, 2) + 8 * eprime2 + 24 * Math.pow(T1, 2)) * Math.pow(D, 5) / 120)
                / Math.cos(phi1);

        double longitude = lon0 + Math.toDegrees(lonRad);

        return new double[] { latitude, longitude };
    }
    
    /**
     * Helper method to extract numeric value from a cell, handling both numeric and string types.
     *
     * @param cell The cell to extract the numeric value from
     * @return The numeric value as a double
     * @throws NumberFormatException if the cell cannot be converted to a number
     */
    private static double getNumericValue(Cell cell) throws NumberFormatException {
        if (cell == null) {
            throw new NumberFormatException("Cell is null");
        }
        
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                String stringValue = cell.getStringCellValue().trim();
                if (stringValue.isEmpty()) {
                    throw new NumberFormatException("Empty string value");
                }
                return Double.parseDouble(stringValue);
            case FORMULA:
                // For formula cells, try to get the calculated value
                try {
                    return cell.getNumericCellValue();
                } catch (Exception e) {
                    throw new NumberFormatException("Formula cell cannot be converted to number");
                }
            default:
                throw new NumberFormatException("Cell type " + cell.getCellType() + " cannot be converted to number");
        }
    }
}
