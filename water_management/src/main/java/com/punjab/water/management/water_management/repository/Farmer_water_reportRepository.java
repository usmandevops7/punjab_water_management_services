package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.Farmer_water_report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Farmer_water_reportRepository extends JpaRepository<Farmer_water_report, String> {
}
