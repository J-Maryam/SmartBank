package com.smartbank.services.Impl;

import com.smartbank.models.RequestStatus;
import com.smartbank.repositories.RequestStatusRepository;
import com.smartbank.services.RequestStatusService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class RequestStatusServiceImpl implements RequestStatusService {

    @Inject
    private RequestStatusRepository requestStatusRepository;

    @Override
    public void save(RequestStatus requestStatus) {
        requestStatusRepository.save(requestStatus);
    }

    @Override
    public List<RequestStatus> findAllByRequestId(Long requestId) {
        return requestStatusRepository.findAllByRequestId(requestId);
    }
}