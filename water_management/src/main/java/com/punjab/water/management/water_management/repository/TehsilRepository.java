package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.Tehsil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TehsilRepository extends JpaRepository<Tehsil, String> {
}
