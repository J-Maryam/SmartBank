package com.smartbank.services.ServiceImpl;

import com.smartbank.models.RequestStatus;
import com.smartbank.repositories.RequestStatusRepository;
import com.smartbank.services.RequestStatusService;
import jakarta.inject.Inject;

public class RequestStatusServiceImpl implements RequestStatusService {

    @Inject
    private RequestStatusRepository requestStatusRepository;

    @Override
    public void save(RequestStatus requestStatus) {
        requestStatusRepository.save(requestStatus);
    }
}