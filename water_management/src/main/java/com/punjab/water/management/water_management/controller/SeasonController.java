package com.punjab.water.management.water_management.controller;

import com.punjab.water.management.water_management.model.Season;
import com.punjab.water.management.water_management.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/season")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public ResponseEntity<List<Season>> getAllSeasons() {
        List<Season> seasons = seasonService.findAll();
        return ResponseEntity.ok(seasons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Integer id) {
        Optional<Season> season = seasonService.findById(id);
        return season.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Season> createSeason(@RequestBody Season season) {
        Season savedSeason = seasonService.save(season);
        return ResponseEntity.ok(savedSeason);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Season> updateSeason(@PathVariable Integer id, @RequestBody Season season) {
        Optional<Season> existingSeason = seasonService.findById(id);
        if (existingSeason.isPresent()) {
            season.setSeason_id(id);
            Season updatedSeason = seasonService.save(season);
            return ResponseEntity.ok(updatedSeason);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Integer id) {
        Optional<Season> season = seasonService.findById(id);
        if (season.isPresent()) {
            seasonService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
