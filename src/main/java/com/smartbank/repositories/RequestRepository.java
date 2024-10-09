package com.smartbank.repositories;

import com.smartbank.models.Request;

import java.util.List;
import java.util.Optional;

public interface RequestRepository {
    void save (Request request);
    List<Request> findAll ();
    Optional<Request> findById (Long id);
}