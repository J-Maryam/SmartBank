package com.smartbank.repositories;

import com.smartbank.models.RequestStatus;

import java.util.List;

public interface RequestStatusRepository {
    void save(RequestStatus requestStatus);
    List<RequestStatus> findAllByRequestId(Long requestId);
}