package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Farmer;
import com.punjab.water.management.water_management.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public List<Farmer> findAll() {
        return farmerRepository.findAll();
    }

    public Optional<Farmer> findById(String id) {
        return farmerRepository.findById(id);
    }

    public Farmer save(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public void deleteById(String id) {
        farmerRepository.deleteById(id);
    }

}
