package com.smartbank.repositories.Impl;

import com.smartbank.models.Request;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.utiles.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class RequestRepositoryImpl implements RequestRepository {
    @Override
    public void save(Request request) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(request);
            transaction.commit();
        }catch(Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
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
