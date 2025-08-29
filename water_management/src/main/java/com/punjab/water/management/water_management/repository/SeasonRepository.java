package com.punjab.water.management.water_management.repository;

import com.punjab.water.management.water_management.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
}
