package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.WaterResource;
import com.punjab.water.management.water_management.service.WaterResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/water-resource")
public class WaterResourceController {

    @Autowired
    private WaterResourceService waterResourceService;

    @GetMapping
    public ResponseEntity<List<WaterResource>> getAllWaterResources() {
        List<WaterResource> waterResources = waterResourceService.findAll();
        return ResponseEntity.ok(waterResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterResource> getWaterResourceById(@PathVariable Integer id) {
        Optional<WaterResource> waterResource = waterResourceService.findById(id);
        return waterResource.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WaterResource> createWaterResource(@RequestBody WaterResource waterResource) {
        WaterResource savedWaterResource = waterResourceService.save(waterResource);
        return ResponseEntity.ok(savedWaterResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterResource> updateWaterResource(@PathVariable Integer id, @RequestBody WaterResource waterResource) {
        Optional<WaterResource> existingWaterResource = waterResourceService.findById(id);
        if (existingWaterResource.isPresent()) {
            // The ID from path variable will be used for the update
            WaterResource updatedWaterResource = waterResourceService.save(waterResource);
            return ResponseEntity.ok(updatedWaterResource);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaterResource(@PathVariable Integer id) {
        Optional<WaterResource> waterResource = waterResourceService.findById(id);
        if (waterResource.isPresent()) {
            waterResourceService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
