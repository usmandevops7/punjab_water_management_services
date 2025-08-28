package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Recommended_crops_report;
import com.punjab.water.management.water_management.repository.Recommended_crops_reportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Recommended_crops_reportService {

    @Autowired
    private Recommended_crops_reportRepository recommended_crops_reportRepository;

    public List<Recommended_crops_report> findAll() {
        return recommended_crops_reportRepository.findAll();
    }

    public Optional<Recommended_crops_report> findById(String id) {
        return recommended_crops_reportRepository.findById(id);
    }

    public Recommended_crops_report save(Recommended_crops_report recommended_crops_report) {
        return recommended_crops_reportRepository.save(recommended_crops_report);
    }

    public void deleteById(String id) {
        recommended_crops_reportRepository.deleteById(id);
    }

}
