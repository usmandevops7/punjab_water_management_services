package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.WaterResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterResourceTypeRepository extends JpaRepository<WaterResourceType, Integer> {
}
