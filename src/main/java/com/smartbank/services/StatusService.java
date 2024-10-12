package com.smartbank.services;

import com.smartbank.models.Status;

import java.util.List;

public interface StatusService {
    void save(Status status);
    Status findByStatus(String status);
    List<Status> findAll();
}
