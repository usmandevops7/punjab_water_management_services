package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Division;
import com.punjab.water.management.water_management.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    public Optional<Division> findById(Integer id) {
        return divisionRepository.findById(id);
    }

    public Division save(Division division) {
        return divisionRepository.save(division);
    }

    public void deleteById(Integer id) {
        divisionRepository.deleteById(id);
    }

}
