package com.smartbank.repositories;

import com.smartbank.models.Request;

import java.util.List;

public interface RequestRepository {
    void save (Request request);
    List<Request> findAll ();
    Request findById (Long id);
}