package com.mjamsek.clockwork.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
    
    private static final String PERSISTENCE_UNIT = "persistence";
    
    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        return factory.createEntityManager();
    }
    
}
