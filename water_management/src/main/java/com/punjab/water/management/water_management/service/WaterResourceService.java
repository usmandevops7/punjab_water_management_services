package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.WaterResource;
import com.punjab.water.management.water_management.repository.WaterResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WaterResourceService {

    @Autowired
    private WaterResourceRepository waterResourceRepository;

    public List<WaterResource> findAll() {
        return waterResourceRepository.findAll();
    }

    public Optional<WaterResource> findById(Integer id) {
        return waterResourceRepository.findById(id);
    }

    public WaterResource save(WaterResource waterResource) {
        return waterResourceRepository.save(waterResource);
    }

    public void deleteById(Integer id) {
        waterResourceRepository.deleteById(id);
    }

}
