package com.punjab.water.management.water_management.service;

import com.punjab.water.management.water_management.model.Tehsil;
import com.punjab.water.management.water_management.repository.TehsilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TehsilService {

    @Autowired
    private TehsilRepository tehsilRepository;

    public List<Tehsil> findAll() {
        return tehsilRepository.findAll();
    }

    public Optional<Tehsil> findById(Integer id) {
        return tehsilRepository.findById(id);
    }

    public Tehsil save(Tehsil tehsil) {
        return tehsilRepository.save(tehsil);
    }

    public void deleteById(Integer id) {
        tehsilRepository.deleteById(id);
    }

}
