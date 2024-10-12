package com.smartbank.repositories.Impl;

import com.smartbank.models.Status;
import com.smartbank.repositories.StatusRepository;
import com.smartbank.utiles.EntityManagerProvider;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;


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

    @Override
    public Optional<Status> findById(Long id) {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        Status status = null;

        try{
            status = em.find(Status.class, id);
            return Optional.ofNullable(status);
        }catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Status> findAll() {
        EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
        List<Status> statusList = null;

        try {
            statusList = em.createQuery("select s from Status s", Status.class).getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return statusList;
    }
}
