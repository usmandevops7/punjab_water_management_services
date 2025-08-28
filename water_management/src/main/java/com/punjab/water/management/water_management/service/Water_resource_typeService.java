package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Water_resource_type;
import com.punjab.water.management.water_management.repository.Water_resource_typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Water_resource_typeService {

    @Autowired
    private Water_resource_typeRepository water_resource_typeRepository;

    public List<Water_resource_type> findAll() {
        return water_resource_typeRepository.findAll();
    }

    public Optional<Water_resource_type> findById(Integer id) {
        return water_resource_typeRepository.findById(id);
    }

    public Water_resource_type save(Water_resource_type water_resource_type) {
        return water_resource_typeRepository.save(water_resource_type);
    }

    public void deleteById(Integer id) {
        water_resource_typeRepository.deleteById(id);
    }

}
