package com.smartbank.repositories;

import com.smartbank.models.Status;

public interface StatusRepository {
    void save(Status status);
    Status findByStatus(String status);
//    Status findById(int id);
}
