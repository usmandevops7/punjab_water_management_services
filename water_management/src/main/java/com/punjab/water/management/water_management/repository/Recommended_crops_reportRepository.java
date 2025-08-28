package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.Recommended_crops_report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Recommended_crops_reportRepository extends JpaRepository<Recommended_crops_report, String> {
}
