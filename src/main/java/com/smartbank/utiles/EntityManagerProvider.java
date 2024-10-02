package com.smartbank.utiles;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("smartbank");
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}