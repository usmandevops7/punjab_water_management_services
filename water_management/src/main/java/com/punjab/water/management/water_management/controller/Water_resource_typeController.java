package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Water_resource_type;
import com.punjab.water.management.water_management.service.Water_resource_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/water-resource-type")
public class Water_resource_typeController {

    @Autowired
    private Water_resource_typeService water_resource_typeService;

    @GetMapping
    public ResponseEntity<List<Water_resource_type>> getAllWater_resource_types() {
        List<Water_resource_type> water_resource_types = water_resource_typeService.findAll();
        return ResponseEntity.ok(water_resource_types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Water_resource_type> getWater_resource_typeById(@PathVariable Integer id) {
        Optional<Water_resource_type> water_resource_type = water_resource_typeService.findById(id);
        return water_resource_type.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Water_resource_type> createWater_resource_type(@RequestBody Water_resource_type water_resource_type) {
        Water_resource_type savedWater_resource_type = water_resource_typeService.save(water_resource_type);
        return ResponseEntity.ok(savedWater_resource_type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Water_resource_type> updateWater_resource_type(@PathVariable Integer id, @RequestBody Water_resource_type water_resource_type) {
        Optional<Water_resource_type> existingWater_resource_type = water_resource_typeService.findById(id);
        if (existingWater_resource_type.isPresent()) {
            // The ID from path variable will be used for the update
            Water_resource_type updatedWater_resource_type = water_resource_typeService.save(water_resource_type);
            return ResponseEntity.ok(updatedWater_resource_type);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWater_resource_type(@PathVariable Integer id) {
        Optional<Water_resource_type> water_resource_type = water_resource_typeService.findById(id);
        if (water_resource_type.isPresent()) {
            water_resource_typeService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
