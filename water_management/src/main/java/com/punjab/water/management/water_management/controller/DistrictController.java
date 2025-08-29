package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.District;
import com.punjab.water.management.water_management.service.DistrictService;
import com.punjab.water.management.water_management.utils.GeometryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.findAll();
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Integer id) {
        Optional<District> district = districtService.findById(id);
        return district.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        District savedDistrict = districtService.save(district);
        return ResponseEntity.ok(savedDistrict);
    }

    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable Integer id, @RequestBody District district) {
        Optional<District> existingDistrict = districtService.findById(id);
        if (existingDistrict.isPresent()) {
            district.setDistrict_id(id);
            District updatedDistrict = districtService.save(district);
            return ResponseEntity.ok(updatedDistrict);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Integer id) {
        Optional<District> district = districtService.findById(id);
        if (district.isPresent()) {
            districtService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/boundary")
    public ResponseEntity<District> updateDistrictBoundary(@PathVariable Integer id, @RequestBody String boundaryWkt) {
        Optional<District> existingDistrict = districtService.findById(id);
        if (existingDistrict.isPresent()) {
            District district = existingDistrict.get();
            
            // Validate the WKT geometry
            if (!GeometryUtils.isValidWkt(boundaryWkt)) {
                return ResponseEntity.badRequest().build();
            }
            
            district.setBoundary(boundaryWkt);
            District updatedDistrict = districtService.save(district);
            return ResponseEntity.ok(updatedDistrict);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/boundary/area")
    public ResponseEntity<Double> getDistrictArea(@PathVariable Integer id) {
        Optional<District> district = districtService.findById(id);
        if (district.isPresent() && district.get().getBoundary() != null) {
            Double area = GeometryUtils.calculateArea(district.get().getBoundary());
            return ResponseEntity.ok(area);
        }
        return ResponseEntity.notFound().build();
    }

}
