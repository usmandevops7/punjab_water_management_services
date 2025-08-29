package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Season;
import com.punjab.water.management.water_management.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> findAll() {
        return seasonRepository.findAll();
    }

    public Optional<Season> findById(Integer id) {
        return seasonRepository.findById(id);
    }

    public Season save(Season season) {
        return seasonRepository.save(season);
    }

    public void deleteById(Integer id) {
        seasonRepository.deleteById(id);
    }

}
