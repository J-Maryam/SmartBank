package com.smartbank.repositories;

import com.smartbank.models.Status;

import java.util.List;
import java.util.Optional;

public interface StatusRepository {
    void save(Status status);
    Status findByStatus(String status);
    Optional<Status> findById(Long id);
    List<Status> findAll();
}
