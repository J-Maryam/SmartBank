package com.smartbank.services.ServiceImpl;

import com.smartbank.models.Status;
import com.smartbank.repositories.StatusRepository;
import com.smartbank.services.StatusService;

public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    @Override
    public void save(Status status) {

    }
}
