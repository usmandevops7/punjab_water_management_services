package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.WaterResourceType;
import com.punjab.water.management.water_management.repository.WaterResourceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WaterResourceTypeService {

    @Autowired
    private WaterResourceTypeRepository waterResourceTypeRepository;

    public List<WaterResourceType> findAll() {
        return waterResourceTypeRepository.findAll();
    }

    public Optional<WaterResourceType> findById(Integer id) {
        return waterResourceTypeRepository.findById(id);
    }

    public WaterResourceType save(WaterResourceType waterResourceType) {
        return waterResourceTypeRepository.save(waterResourceType);
    }

    public void deleteById(Integer id) {
        waterResourceTypeRepository.deleteById(id);
    }

}
