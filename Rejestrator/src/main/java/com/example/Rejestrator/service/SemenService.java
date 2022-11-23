package com.example.Rejestrator.service;

import com.example.Rejestrator.logic.Functions;
import com.example.Rejestrator.repository.SemenRepository;
import com.example.Rejestrator.model.Semen;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SemenService {
    private final SemenRepository semenRepository;

    public SemenService(SemenRepository semenRepository) {
        this.semenRepository = semenRepository;
    }
    @Transactional
    public void add(Semen semen){
       semenRepository.save(semen);
    }


}
