package com.smartbank.repositories.Impl;

import com.smartbank.models.Request;
import com.smartbank.repositories.RequestRepository;
import com.smartbank.services.StatusService;
import com.smartbank.utiles.EntityManagerProvider;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestScoped
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

    @Override
    public List<Request> findByDateAndStatus(LocalDate date, Long statusId) {
        List<Request> requests;
        String jpql = "select r from Request r join r.requestStatuses rs where rs.status.id = :statusId and rs.StatusDate = :date";
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

        try{
            TypedQuery<Request> query = em.createQuery(jpql, Request.class);
            query.setParameter("statusId", statusId);
            query.setParameter("date", date);
            requests = query.getResultList();
        }finally {
            em.close();
        }
        return requests;
    }
}
