package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.WaterResourceType;
import com.punjab.water.management.water_management.service.WaterResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/water-resource-type")
public class WaterResourceTypeController {

    @Autowired
    private WaterResourceTypeService waterResourceTypeService;

    @GetMapping
    public ResponseEntity<List<WaterResourceType>> getAllWaterResourceTypes() {
        List<WaterResourceType> waterResourceTypes = waterResourceTypeService.findAll();
        return ResponseEntity.ok(waterResourceTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterResourceType> getWaterResourceTypeById(@PathVariable Integer id) {
        Optional<WaterResourceType> waterResourceType = waterResourceTypeService.findById(id);
        return waterResourceType.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WaterResourceType> createWaterResourceType(@RequestBody WaterResourceType waterResourceType) {
        WaterResourceType savedWaterResourceType = waterResourceTypeService.save(waterResourceType);
        return ResponseEntity.ok(savedWaterResourceType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterResourceType> updateWaterResourceType(@PathVariable Integer id, @RequestBody WaterResourceType waterResourceType) {
        Optional<WaterResourceType> existingWaterResourceType = waterResourceTypeService.findById(id);
        if (existingWaterResourceType.isPresent()) {
            // The ID from path variable will be used for the update
            WaterResourceType updatedWaterResourceType = waterResourceTypeService.save(waterResourceType);
            return ResponseEntity.ok(updatedWaterResourceType);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaterResourceType(@PathVariable Integer id) {
        Optional<WaterResourceType> waterResourceType = waterResourceTypeService.findById(id);
        if (waterResourceType.isPresent()) {
            waterResourceTypeService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
