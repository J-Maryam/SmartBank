package com.smartbank.services;

import com.smartbank.models.Status;

public interface StatusService {
    void save(Status status);
    Status findByStatus(String status);
}
