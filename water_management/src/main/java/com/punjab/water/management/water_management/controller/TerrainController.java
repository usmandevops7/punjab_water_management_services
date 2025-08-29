package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Terrain;
import com.punjab.water.management.water_management.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/terrain")
public class TerrainController {

    @Autowired
    private TerrainService terrainService;

    @GetMapping
    public ResponseEntity<List<Terrain>> getAllTerrains() {
        List<Terrain> terrains = terrainService.findAll();
        return ResponseEntity.ok(terrains);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable Integer id) {
        Optional<Terrain> terrain = terrainService.findById(id);
        return terrain.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Terrain> createTerrain(@RequestBody Terrain terrain) {
        Terrain savedTerrain = terrainService.save(terrain);
        return ResponseEntity.ok(savedTerrain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Terrain> updateTerrain(@PathVariable Integer id, @RequestBody Terrain terrain) {
        Optional<Terrain> existingTerrain = terrainService.findById(id);
        if (existingTerrain.isPresent()) {
            terrain.setTerrain_id(id);
            Terrain updatedTerrain = terrainService.save(terrain);
            return ResponseEntity.ok(updatedTerrain);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Integer id) {
        Optional<Terrain> terrain = terrainService.findById(id);
        if (terrain.isPresent()) {
            terrainService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
