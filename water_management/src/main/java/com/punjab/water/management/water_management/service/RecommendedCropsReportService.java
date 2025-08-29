package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.RecommendedCropsReport;
import com.punjab.water.management.water_management.repository.RecommendedCropsReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendedCropsReportService {

    @Autowired
    private RecommendedCropsReportRepository recommendedCropsReportRepository;

    public List<RecommendedCropsReport> findAll() {
        return recommendedCropsReportRepository.findAll();
    }

    public Optional<RecommendedCropsReport> findById(Integer id) {
        return recommendedCropsReportRepository.findById(id);
    }

    public RecommendedCropsReport save(RecommendedCropsReport recommendedCropsReport) {
        return recommendedCropsReportRepository.save(recommendedCropsReport);
    }

    public void deleteById(Integer id) {
        recommendedCropsReportRepository.deleteById(id);
    }

}
