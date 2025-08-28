package com.punjab.water.management.water_management.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class InsertDistrictsFromExcel {

    public static void main(String[] args) {
        String excelFile = "WC_Samples.xlsx";  // Path to your Excel file
        String sheetName = "PriatReport";
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";  // Replace with your DB URL (e.g., jdbc:sqlite:/path/to/db.sqlite for SQLite)
        String dbUser = "your_username";  // DB credentials
        String dbPassword = "your_password";

        Set<String> uniqueDistricts = new HashSet<>();

        // Step 1: Read Excel and extract unique districts
        try (FileInputStream fis = new FileInputStream(excelFile)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.out.println("Sheet '" + sheetName + "' not found.");
                return;
            }

            // Iterate over rows, starting from row 1 (index 0 is header)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;

                Cell districtCell = row.getCell(1);  // District is in column 1 (zero-based)
                if (districtCell != null && districtCell.getCellType() == CellType.STRING) {
                    String district = districtCell.getStringCellValue().trim();
                    if (!district.isEmpty()) {
                        uniqueDistricts.add(district);
                    }
                }
            }

            System.out.println("Unique Districts Found: " + uniqueDistricts);

        } catch (IOException e) {
            System.out.println("Error reading Excel: " + e.getMessage());
            return;
        }

        // Step 2: Insert into database
        String insertSql = "INSERT IGNORE INTO district (name) VALUES (?)";  // Use IGNORE to skip duplicates if UNIQUE constraint exists
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            for (String district : uniqueDistricts) {
                pstmt.setString(1, district);
                pstmt.executeUpdate();
            }

            System.out.println("Inserted " + uniqueDistricts.size() + " unique districts into the database.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
