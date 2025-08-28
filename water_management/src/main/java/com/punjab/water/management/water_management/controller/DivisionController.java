package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Division;
import com.punjab.water.management.water_management.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/division")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping
    public ResponseEntity<List<Division>> getAllDivisions() {
        List<Division> divisions = divisionService.findAll();
        return ResponseEntity.ok(divisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable Integer id) {
        Optional<Division> division = divisionService.findById(id);
        return division.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Division> createDivision(@RequestBody Division division) {
        Division savedDivision = divisionService.save(division);
        return ResponseEntity.ok(savedDivision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable Integer id, @RequestBody Division division) {
        Optional<Division> existingDivision = divisionService.findById(id);
        if (existingDivision.isPresent()) {
            // The ID from path variable will be used for the update
            Division updatedDivision = divisionService.save(division);
            return ResponseEntity.ok(updatedDivision);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable Integer id) {
        Optional<Division> division = divisionService.findById(id);
        if (division.isPresent()) {
            divisionService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
