package com.example.cutoffcalculator.service;

import com.example.cutoffcalculator.model.CutoffRequest;
import com.example.cutoffcalculator.repository.CutoffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutoffService {

    @Autowired
    private CutoffRepository cutoffRepository;

    public CutoffRequest calculateAndSaveCutoff(double maths, double physics, double chemistry) {
        double cutoff = maths + (physics / 2) + (chemistry / 2);

        CutoffRequest cutoffRequest = new CutoffRequest();
        cutoffRequest.setMaths(maths);
        cutoffRequest.setPhysics(physics);
        cutoffRequest.setChemistry(chemistry);
        cutoffRequest.setCutoff(cutoff);

        return cutoffRepository.save(cutoffRequest);
    }

    public List<CutoffRequest> getAllCutoffRecords() {
        return cutoffRepository.findAll();
    }
}
