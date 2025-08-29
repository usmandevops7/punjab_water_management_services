package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.UnionCouncil;
import com.punjab.water.management.water_management.repository.UnionCouncilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UnionCouncilService {

    @Autowired
    private UnionCouncilRepository unionCouncilRepository;

    public List<UnionCouncil> findAll() {
        return unionCouncilRepository.findAll();
    }

    public Optional<UnionCouncil> findById(Integer id) {
        return unionCouncilRepository.findById(id);
    }

    public UnionCouncil save(UnionCouncil unionCouncil) {
        return unionCouncilRepository.save(unionCouncil);
    }

    public void deleteById(Integer id) {
        unionCouncilRepository.deleteById(id);
    }

}
