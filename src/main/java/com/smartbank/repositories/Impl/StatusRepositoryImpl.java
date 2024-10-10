package com.smartbank.repositories.Impl;

import com.smartbank.models.Status;
import com.smartbank.repositories.StatusRepository;
import com.smartbank.utiles.EntityManagerProvider;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

@RequestScoped
public class StatusRepositoryImpl implements StatusRepository {

    @Override
    public void save(Status status) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(status);
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
    public Status findByStatus(String status) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        TypedQuery<Status> query = em.createQuery("select s from Status s where s.status = :status", Status.class);
        query.setParameter("status", status);

        try {
            return query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }
}
