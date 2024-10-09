package com.smartbank.services.ServiceImpl;

import com.smartbank.models.RequestStatus;
import com.smartbank.repositories.RequestStatusRepository;
import com.smartbank.services.RequestStatusService;

public class RequestStatusServiceImpl implements RequestStatusService {
    private final RequestStatusRepository requestStatusRepository;

    public RequestStatusServiceImpl(RequestStatusRepository requestStatusRepository) {
        this.requestStatusRepository = requestStatusRepository;
    }
    @Override
    public void save(RequestStatus requestStatus) {
        requestStatusRepository.save(requestStatus);
    }
}
