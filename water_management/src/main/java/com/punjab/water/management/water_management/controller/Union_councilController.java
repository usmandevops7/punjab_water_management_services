package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Union_council;
import com.punjab.water.management.water_management.service.Union_councilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/union-council")
public class Union_councilController {

    @Autowired
    private Union_councilService union_councilService;

    @GetMapping
    public ResponseEntity<List<Union_council>> getAllUnion_councils() {
        List<Union_council> union_councils = union_councilService.findAll();
        return ResponseEntity.ok(union_councils);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Union_council> getUnion_councilById(@PathVariable String id) {
        Optional<Union_council> union_council = union_councilService.findById(id);
        return union_council.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Union_council> createUnion_council(@RequestBody Union_council union_council) {
        Union_council savedUnion_council = union_councilService.save(union_council);
        return ResponseEntity.ok(savedUnion_council);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Union_council> updateUnion_council(@PathVariable String id, @RequestBody Union_council union_council) {
        Optional<Union_council> existingUnion_council = union_councilService.findById(id);
        if (existingUnion_council.isPresent()) {
            // The ID from path variable will be used for the update
            Union_council updatedUnion_council = union_councilService.save(union_council);
            return ResponseEntity.ok(updatedUnion_council);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnion_council(@PathVariable String id) {
        Optional<Union_council> union_council = union_councilService.findById(id);
        if (union_council.isPresent()) {
            union_councilService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
