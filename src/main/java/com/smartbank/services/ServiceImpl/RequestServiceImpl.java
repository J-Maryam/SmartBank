package com.smartbank.services.ServiceImpl;

import com.smartbank.models.Request;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.RequestService;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class RequestServiceImpl implements RequestService {
    @Inject
    private RequestRepository requestRepository;

    @Override
    public void save(Request request) {
        requestRepository.save(request);
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request findById(Long id) {
        Optional<Request> optionalRequest = requestRepository.findById(id);
        return optionalRequest.orElse(null);
    }
}
