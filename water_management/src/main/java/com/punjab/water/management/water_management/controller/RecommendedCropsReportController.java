package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.RecommendedCropsReport;
import com.punjab.water.management.water_management.service.RecommendedCropsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recommended-crops-report")
public class RecommendedCropsReportController {

    @Autowired
    private RecommendedCropsReportService recommendedCropsReportService;

    @GetMapping
    public ResponseEntity<List<RecommendedCropsReport>> getAllRecommendedCropsReports() {
        List<RecommendedCropsReport> recommendedCropsReports = recommendedCropsReportService.findAll();
        return ResponseEntity.ok(recommendedCropsReports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendedCropsReport> getRecommendedCropsReportById(@PathVariable Integer id) {
        Optional<RecommendedCropsReport> recommendedCropsReport = recommendedCropsReportService.findById(id);
        return recommendedCropsReport.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RecommendedCropsReport> createRecommendedCropsReport(@RequestBody RecommendedCropsReport recommendedCropsReport) {
        RecommendedCropsReport savedRecommendedCropsReport = recommendedCropsReportService.save(recommendedCropsReport);
        return ResponseEntity.ok(savedRecommendedCropsReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecommendedCropsReport> updateRecommendedCropsReport(@PathVariable Integer id, @RequestBody RecommendedCropsReport recommendedCropsReport) {
        Optional<RecommendedCropsReport> existingRecommendedCropsReport = recommendedCropsReportService.findById(id);
        if (existingRecommendedCropsReport.isPresent()) {
            recommendedCropsReport.setRec_id(id);
            RecommendedCropsReport updatedRecommendedCropsReport = recommendedCropsReportService.save(recommendedCropsReport);
            return ResponseEntity.ok(updatedRecommendedCropsReport);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendedCropsReport(@PathVariable Integer id) {
        Optional<RecommendedCropsReport> recommendedCropsReport = recommendedCropsReportService.findById(id);
        if (recommendedCropsReport.isPresent()) {
            recommendedCropsReportService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
