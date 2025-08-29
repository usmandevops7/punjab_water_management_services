package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Tehsil;
import com.punjab.water.management.water_management.service.TehsilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tehsil")
public class TehsilController {

    @Autowired
    private TehsilService tehsilService;

    @GetMapping
    public ResponseEntity<List<Tehsil>> getAllTehsils() {
        List<Tehsil> tehsils = tehsilService.findAll();
        return ResponseEntity.ok(tehsils);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tehsil> getTehsilById(@PathVariable Integer id) {
        Optional<Tehsil> tehsil = tehsilService.findById(id);
        return tehsil.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tehsil> createTehsil(@RequestBody Tehsil tehsil) {
        Tehsil savedTehsil = tehsilService.save(tehsil);
        return ResponseEntity.ok(savedTehsil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tehsil> updateTehsil(@PathVariable Integer id, @RequestBody Tehsil tehsil) {
        Optional<Tehsil> existingTehsil = tehsilService.findById(id);
        if (existingTehsil.isPresent()) {
            // Set the ID from path variable to ensure we update the correct record
            tehsil.setTehsil_id(id);
            Tehsil updatedTehsil = tehsilService.save(tehsil);
            return ResponseEntity.ok(updatedTehsil);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTehsil(@PathVariable Integer id) {
        Optional<Tehsil> tehsil = tehsilService.findById(id);
        if (tehsil.isPresent()) {
            tehsilService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
