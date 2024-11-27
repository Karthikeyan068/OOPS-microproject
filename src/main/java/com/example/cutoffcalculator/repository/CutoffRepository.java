package com.example.cutoffcalculator.repository;

import com.example.cutoffcalculator.model.CutoffRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutoffRepository extends MongoRepository<CutoffRequest, String> {
}
