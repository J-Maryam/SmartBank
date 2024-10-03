package com.smartbank.services.ServiceImpl;

import com.smartbank.models.Request;
import com.smartbank.services.RequestService;

import java.util.List;

public class RequestServiceImpl implements RequestService {
    @Override
    public void save(Request request) {

    }

    @Override
    public List<Request> findAll() {
        return List.of();
    }

    @Override
    public Request findById(Long id) {
        return null;
    }
}
