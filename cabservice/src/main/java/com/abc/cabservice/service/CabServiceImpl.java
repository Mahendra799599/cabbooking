package com.abc.cabservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.cabservice.entity.Cab;
import com.abc.cabservice.repository.CabRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepository cabRepository;

    @Override
    public List<Cab> getAllCabs() {
        return cabRepository.findAll();
    }

    @Override
    public Cab getCabById(int id) {
        Optional<Cab> optionalCab = cabRepository.findById(id);
        return optionalCab.orElse(null);
    }

    @Override
    public Cab addCab(Cab cab) {
        return cabRepository.save(cab);
    }

    @Override
    public Cab updateCab(int id, Cab cab) {
     
            return cabRepository.save(cab);
       
    }

    @Override
    public void deleteCab(int id) {
    	cabRepository.deleteById(id);
    }
}
