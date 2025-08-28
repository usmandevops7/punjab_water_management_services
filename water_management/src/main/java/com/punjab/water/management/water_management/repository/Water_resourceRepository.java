package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.Water_resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Water_resourceRepository extends JpaRepository<Water_resource, Integer> {
}
