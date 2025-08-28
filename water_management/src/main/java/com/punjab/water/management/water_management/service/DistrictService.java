package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.District;
import com.punjab.water.management.water_management.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<District> findAll() {
        return districtRepository.findAll();
    }

    public Optional<District> findById(String id) {
        return districtRepository.findById(id);
    }

    public District save(District district) {
        return districtRepository.save(district);
    }

    public void deleteById(String id) {
        districtRepository.deleteById(id);
    }

}
