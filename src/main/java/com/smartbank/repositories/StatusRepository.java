package com.smartbank.repositories;

import com.smartbank.models.Status;

import java.util.List;

public interface StatusRepository {
    void save(Status status);
    Status findByStatus(String status);
//    Status findById(int id);
    List<Status> findAll();
}
