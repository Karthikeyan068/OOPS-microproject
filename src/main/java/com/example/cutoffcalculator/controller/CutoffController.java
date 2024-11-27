package com.example.cutoffcalculator.controller;

import com.example.cutoffcalculator.model.CutoffRequest;
import com.example.cutoffcalculator.service.CutoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cutoff")
public class CutoffController {

    @Autowired
    private CutoffService cutoffService;

    @PostMapping("/calculate")
    public CutoffRequest calculateCutoff(@RequestBody CutoffRequest request) {
        return cutoffService.calculateAndSaveCutoff(
                request.getMaths(),
                request.getPhysics(),
                request.getChemistry()
        );
    }

    @GetMapping("/records")
    public List<CutoffRequest> getAllCutoffRecords() {
        return cutoffService.getAllCutoffRecords();
    }
}
