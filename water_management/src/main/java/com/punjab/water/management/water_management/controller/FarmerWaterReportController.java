package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.FarmerWaterReport;
import com.punjab.water.management.water_management.service.FarmerWaterReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmer-water-report")
public class FarmerWaterReportController {

    @Autowired
    private FarmerWaterReportService farmerWaterReportService;

    @GetMapping
    public ResponseEntity<List<FarmerWaterReport>> getAllFarmerWaterReports() {
        List<FarmerWaterReport> farmerWaterReports = farmerWaterReportService.findAll();
        return ResponseEntity.ok(farmerWaterReports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerWaterReport> getFarmerWaterReportById(@PathVariable Integer id) {
        Optional<FarmerWaterReport> farmerWaterReport = farmerWaterReportService.findById(id);
        return farmerWaterReport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FarmerWaterReport> createFarmerWaterReport(@RequestBody FarmerWaterReport farmerWaterReport) {
        FarmerWaterReport savedFarmerWaterReport = farmerWaterReportService.save(farmerWaterReport);
        return ResponseEntity.ok(savedFarmerWaterReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmerWaterReport> updateFarmerWaterReport(@PathVariable Integer id, @RequestBody FarmerWaterReport farmerWaterReport) {
        Optional<FarmerWaterReport> existingFarmerWaterReport = farmerWaterReportService.findById(id);
        if (existingFarmerWaterReport.isPresent()) {
            farmerWaterReport.setReport_id(id);
            FarmerWaterReport updatedFarmerWaterReport = farmerWaterReportService.save(farmerWaterReport);
            return ResponseEntity.ok(updatedFarmerWaterReport);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmerWaterReport(@PathVariable Integer id) {
        Optional<FarmerWaterReport> farmerWaterReport = farmerWaterReportService.findById(id);
        if (farmerWaterReport.isPresent()) {
            farmerWaterReportService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
