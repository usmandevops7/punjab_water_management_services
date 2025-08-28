package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Crop;
import com.punjab.water.management.water_management.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public List<Crop> findAll() {
        return cropRepository.findAll();
    }

    public Optional<Crop> findById(String id) {
        return cropRepository.findById(id);
    }

    public Crop save(Crop crop) {
        return cropRepository.save(crop);
    }

    public void deleteById(String id) {
        cropRepository.deleteById(id);
    }

}
