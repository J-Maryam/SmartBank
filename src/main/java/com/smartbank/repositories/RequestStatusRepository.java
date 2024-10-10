package com.smartbank.repositories;

import com.smartbank.models.RequestStatus;

public interface RequestStatusRepository {
    void save(RequestStatus requestStatus);
}