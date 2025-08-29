package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Crop;
import com.punjab.water.management.water_management.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crop")
public class CropController {

    @Autowired
    private CropService cropService;

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        List<Crop> crops = cropService.findAll();
        return ResponseEntity.ok(crops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable Integer id) {
        Optional<Crop> crop = cropService.findById(id);
        return crop.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop savedCrop = cropService.save(crop);
        return ResponseEntity.ok(savedCrop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crop> updateCrop(@PathVariable Integer id, @RequestBody Crop crop) {
        Optional<Crop> existingCrop = cropService.findById(id);
        if (existingCrop.isPresent()) {
            crop.setCrop_id(id);
            Crop updatedCrop = cropService.save(crop);
            return ResponseEntity.ok(updatedCrop);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Integer id) {
        Optional<Crop> crop = cropService.findById(id);
        if (crop.isPresent()) {
            cropService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
