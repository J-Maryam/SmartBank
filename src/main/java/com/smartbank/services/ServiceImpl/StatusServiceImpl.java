package com.smartbank.services.ServiceImpl;

import com.smartbank.models.Status;
import com.smartbank.repositories.StatusRepository;
import com.smartbank.services.StatusService;
import jakarta.inject.Inject;

public class StatusServiceImpl implements StatusService {

    @Inject
    private StatusRepository statusRepository;

    @Override
    public void save(Status status) {

    }
}
