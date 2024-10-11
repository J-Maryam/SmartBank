package com.smartbank.services;

import com.smartbank.models.RequestStatus;

import java.util.List;

public interface RequestStatusService {
    void save (RequestStatus requestStatus);
    List<RequestStatus> findAllByRequestId(Long requestId);
}
