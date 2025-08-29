package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Farmer;
import com.punjab.water.management.water_management.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        List<Farmer> farmers = farmerService.findAll();
        return ResponseEntity.ok(farmers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Integer id) {
        Optional<Farmer> farmer = farmerService.findById(id);
        return farmer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer) {
        Farmer savedFarmer = farmerService.save(farmer);
        return ResponseEntity.ok(savedFarmer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable Integer id, @RequestBody Farmer farmer) {
        Optional<Farmer> existingFarmer = farmerService.findById(id);
        if (existingFarmer.isPresent()) {
            farmer.setFarmer_id(id);
            Farmer updatedFarmer = farmerService.save(farmer);
            return ResponseEntity.ok(updatedFarmer);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Integer id) {
        Optional<Farmer> farmer = farmerService.findById(id);
        if (farmer.isPresent()) {
            farmerService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
