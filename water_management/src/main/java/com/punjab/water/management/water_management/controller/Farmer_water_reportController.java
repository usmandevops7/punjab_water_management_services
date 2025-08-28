package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Farmer_water_report;
import com.punjab.water.management.water_management.service.Farmer_water_reportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmer-water-report")
public class Farmer_water_reportController {

    @Autowired
    private Farmer_water_reportService farmer_water_reportService;

    @GetMapping
    public ResponseEntity<List<Farmer_water_report>> getAllFarmer_water_reports() {
        List<Farmer_water_report> farmer_water_reports = farmer_water_reportService.findAll();
        return ResponseEntity.ok(farmer_water_reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer_water_report> getFarmer_water_reportById(@PathVariable String id) {
        Optional<Farmer_water_report> farmer_water_report = farmer_water_reportService.findById(id);
        return farmer_water_report.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Farmer_water_report> createFarmer_water_report(@RequestBody Farmer_water_report farmer_water_report) {
        Farmer_water_report savedFarmer_water_report = farmer_water_reportService.save(farmer_water_report);
        return ResponseEntity.ok(savedFarmer_water_report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer_water_report> updateFarmer_water_report(@PathVariable String id, @RequestBody Farmer_water_report farmer_water_report) {
        Optional<Farmer_water_report> existingFarmer_water_report = farmer_water_reportService.findById(id);
        if (existingFarmer_water_report.isPresent()) {
            // The ID from path variable will be used for the update
            Farmer_water_report updatedFarmer_water_report = farmer_water_reportService.save(farmer_water_report);
            return ResponseEntity.ok(updatedFarmer_water_report);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer_water_report(@PathVariable String id) {
        Optional<Farmer_water_report> farmer_water_report = farmer_water_reportService.findById(id);
        if (farmer_water_report.isPresent()) {
            farmer_water_reportService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
