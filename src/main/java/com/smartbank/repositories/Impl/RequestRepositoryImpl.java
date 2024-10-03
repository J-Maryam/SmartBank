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
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Request> findAll() {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        List<Request> requests = null;

        try {
            requests = em.createQuery("select r from Request r", Request.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return requests;
    }

    @Override
    public Request findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        Request request = null;
        try {
            request = em.find(Request.class, id);
        }finally {
            em.close();
        }
        return request;
    }
}
