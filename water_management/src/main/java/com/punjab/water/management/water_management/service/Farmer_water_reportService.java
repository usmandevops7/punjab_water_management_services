package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Farmer_water_report;
import com.punjab.water.management.water_management.repository.Farmer_water_reportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Farmer_water_reportService {

    @Autowired
    private Farmer_water_reportRepository farmer_water_reportRepository;

    public List<Farmer_water_report> findAll() {
        return farmer_water_reportRepository.findAll();
    }

    public Optional<Farmer_water_report> findById(String id) {
        return farmer_water_reportRepository.findById(id);
    }

    public Farmer_water_report save(Farmer_water_report farmer_water_report) {
        return farmer_water_reportRepository.save(farmer_water_report);
    }

    public void deleteById(String id) {
        farmer_water_reportRepository.deleteById(id);
    }

}
