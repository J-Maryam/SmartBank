package com.smartbank.repositories.Impl;

import com.smartbank.models.RequestStatus;
import com.smartbank.repositories.RequestStatusRepository;
import com.smartbank.utiles.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class RequestStatusRepositoryImpl implements RequestStatusRepository {
    @Override
    public void save(RequestStatus requestStatus) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(requestStatus);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public List<RequestStatus> findAllByRequestId(Long requestId) {
        String query = "Select rs from RequestStatus rs where rs.request.id = :request_id";
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        return em.createQuery(query, RequestStatus.class)
                .setParameter("request_id", requestId)
                .getResultList();
    }
}
