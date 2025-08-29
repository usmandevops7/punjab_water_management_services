package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.UnionCouncil;
import com.punjab.water.management.water_management.service.UnionCouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/union-council")
public class UnionCouncilController {

    @Autowired
    private UnionCouncilService unionCouncilService;

    @GetMapping
    public ResponseEntity<List<UnionCouncil>> getAllUnionCouncils() {
        List<UnionCouncil> unionCouncils = unionCouncilService.findAll();
        return ResponseEntity.ok(unionCouncils);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnionCouncil> getUnionCouncilById(@PathVariable Integer id) {
        Optional<UnionCouncil> unionCouncil = unionCouncilService.findById(id);
        return unionCouncil.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UnionCouncil> createUnionCouncil(@RequestBody UnionCouncil unionCouncil) {
        UnionCouncil savedUnionCouncil = unionCouncilService.save(unionCouncil);
        return ResponseEntity.ok(savedUnionCouncil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnionCouncil> updateUnionCouncil(@PathVariable Integer id, @RequestBody UnionCouncil unionCouncil) {
        Optional<UnionCouncil> existingUnionCouncil = unionCouncilService.findById(id);
        if (existingUnionCouncil.isPresent()) {
            unionCouncil.setUc_id(id);
            UnionCouncil updatedUnionCouncil = unionCouncilService.save(unionCouncil);
            return ResponseEntity.ok(updatedUnionCouncil);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnionCouncil(@PathVariable Integer id) {
        Optional<UnionCouncil> unionCouncil = unionCouncilService.findById(id);
        if (unionCouncil.isPresent()) {
            unionCouncilService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
