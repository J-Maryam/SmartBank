package com.smartbank.services;

import com.smartbank.models.Request;

import java.util.List;

public interface RequestService {
    void save (Request request);
    List<Request> findAll ();
    Request findById (Long id);
}
