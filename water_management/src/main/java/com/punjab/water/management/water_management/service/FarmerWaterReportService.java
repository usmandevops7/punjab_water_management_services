package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.FarmerWaterReport;
import com.punjab.water.management.water_management.repository.FarmerWaterReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerWaterReportService {

    @Autowired
    private FarmerWaterReportRepository farmerWaterReportRepository;

    public List<FarmerWaterReport> findAll() {
        return farmerWaterReportRepository.findAll();
    }

    public Optional<FarmerWaterReport> findById(String id) {
        return farmerWaterReportRepository.findById(id);
    }

    public FarmerWaterReport save(FarmerWaterReport farmerWaterReport) {
        return farmerWaterReportRepository.save(farmerWaterReport);
    }

    public void deleteById(String id) {
        farmerWaterReportRepository.deleteById(id);
    }

}
