package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Terrain;
import com.punjab.water.management.water_management.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TerrainService {

    @Autowired
    private TerrainRepository terrainRepository;

    public List<Terrain> findAll() {
        return terrainRepository.findAll();
    }

    public Optional<Terrain> findById(Integer id) {
        return terrainRepository.findById(id);
    }

    public Terrain save(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

    public void deleteById(Integer id) {
        terrainRepository.deleteById(id);
    }

}
