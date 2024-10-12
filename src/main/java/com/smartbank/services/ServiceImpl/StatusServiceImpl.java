package com.smartbank.services.ServiceImpl;

import com.smartbank.models.Status;
import com.smartbank.repositories.StatusRepository;
import com.smartbank.services.StatusService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class StatusServiceImpl implements StatusService {

    @Inject
    StatusRepository statusRepository;

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @PostConstruct
    public void initStatus() {
        insertStatusIfNotExist("En attente");
        insertStatusIfNotExist("Accepté");
        insertStatusIfNotExist("Refusé");
    }

    public Status findByStatus(String status) {
        return statusRepository.findByStatus(status);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public void insertStatusIfNotExist(String status) {
        Status existingStatus = findByStatus(status);
        if (existingStatus == null) {
            Status newStatus = new Status();
            newStatus.setStatus(status);
            save(newStatus);
        }
    }
}
