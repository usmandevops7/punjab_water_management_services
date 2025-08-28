package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Water_resource;
import com.punjab.water.management.water_management.service.Water_resourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/water-resource")
public class Water_resourceController {

    @Autowired
    private Water_resourceService water_resourceService;

    @GetMapping
    public ResponseEntity<List<Water_resource>> getAllWater_resources() {
        List<Water_resource> water_resources = water_resourceService.findAll();
        return ResponseEntity.ok(water_resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Water_resource> getWater_resourceById(@PathVariable Integer id) {
        Optional<Water_resource> water_resource = water_resourceService.findById(id);
        return water_resource.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Water_resource> createWater_resource(@RequestBody Water_resource water_resource) {
        Water_resource savedWater_resource = water_resourceService.save(water_resource);
        return ResponseEntity.ok(savedWater_resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Water_resource> updateWater_resource(@PathVariable Integer id, @RequestBody Water_resource water_resource) {
        Optional<Water_resource> existingWater_resource = water_resourceService.findById(id);
        if (existingWater_resource.isPresent()) {
            // The ID from path variable will be used for the update
            Water_resource updatedWater_resource = water_resourceService.save(water_resource);
            return ResponseEntity.ok(updatedWater_resource);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWater_resource(@PathVariable Integer id) {
        Optional<Water_resource> water_resource = water_resourceService.findById(id);
        if (water_resource.isPresent()) {
            water_resourceService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
