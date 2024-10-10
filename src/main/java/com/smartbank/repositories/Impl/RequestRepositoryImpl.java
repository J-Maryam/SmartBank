package com.smartbank.repositories.Impl;

import com.smartbank.models.Request;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.StatusService;
import com.smartbank.utiles.EntityManagerProvider;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

@RequestScoped
public class RequestRepositoryImpl implements RequestRepository {

    @Inject
    private StatusService statusService;

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
    public Optional<Request> findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        Request request = null;
        try {
            request = em.find(Request.class, id);
            return Optional.of(request);
        }catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }finally {
            em.close();
        }
    }
}
