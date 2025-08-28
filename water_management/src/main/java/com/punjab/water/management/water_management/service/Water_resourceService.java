package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Water_resource;
import com.punjab.water.management.water_management.repository.Water_resourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Water_resourceService {

    @Autowired
    private Water_resourceRepository water_resourceRepository;

    public List<Water_resource> findAll() {
        return water_resourceRepository.findAll();
    }

    public Optional<Water_resource> findById(Integer id) {
        return water_resourceRepository.findById(id);
    }

    public Water_resource save(Water_resource water_resource) {
        return water_resourceRepository.save(water_resource);
    }

    public void deleteById(Integer id) {
        water_resourceRepository.deleteById(id);
    }

}
