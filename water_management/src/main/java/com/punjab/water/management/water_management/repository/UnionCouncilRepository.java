package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.UnionCouncil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnionCouncilRepository extends JpaRepository<UnionCouncil, Integer> {
}
