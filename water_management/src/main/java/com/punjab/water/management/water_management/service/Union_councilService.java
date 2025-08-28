package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Union_council;
import com.punjab.water.management.water_management.repository.Union_councilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Union_councilService {

    @Autowired
    private Union_councilRepository union_councilRepository;

    public List<Union_council> findAll() {
        return union_councilRepository.findAll();
    }

    public Optional<Union_council> findById(String id) {
        return union_councilRepository.findById(id);
    }

    public Union_council save(Union_council union_council) {
        return union_councilRepository.save(union_council);
    }

    public void deleteById(String id) {
        union_councilRepository.deleteById(id);
    }

}
