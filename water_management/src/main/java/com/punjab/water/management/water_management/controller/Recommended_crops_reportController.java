package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Recommended_crops_report;
import com.punjab.water.management.water_management.service.Recommended_crops_reportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recommended-crops-report")
public class Recommended_crops_reportController {

    @Autowired
    private Recommended_crops_reportService recommended_crops_reportService;

    @GetMapping
    public ResponseEntity<List<Recommended_crops_report>> getAllRecommended_crops_reports() {
        List<Recommended_crops_report> recommended_crops_reports = recommended_crops_reportService.findAll();
        return ResponseEntity.ok(recommended_crops_reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommended_crops_report> getRecommended_crops_reportById(@PathVariable String id) {
        Optional<Recommended_crops_report> recommended_crops_report = recommended_crops_reportService.findById(id);
        return recommended_crops_report.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recommended_crops_report> createRecommended_crops_report(@RequestBody Recommended_crops_report recommended_crops_report) {
        Recommended_crops_report savedRecommended_crops_report = recommended_crops_reportService.save(recommended_crops_report);
        return ResponseEntity.ok(savedRecommended_crops_report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recommended_crops_report> updateRecommended_crops_report(@PathVariable String id, @RequestBody Recommended_crops_report recommended_crops_report) {
        Optional<Recommended_crops_report> existingRecommended_crops_report = recommended_crops_reportService.findById(id);
        if (existingRecommended_crops_report.isPresent()) {
            // The ID from path variable will be used for the update
            Recommended_crops_report updatedRecommended_crops_report = recommended_crops_reportService.save(recommended_crops_report);
            return ResponseEntity.ok(updatedRecommended_crops_report);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommended_crops_report(@PathVariable String id) {
        Optional<Recommended_crops_report> recommended_crops_report = recommended_crops_reportService.findById(id);
        if (recommended_crops_report.isPresent()) {
            recommended_crops_reportService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
