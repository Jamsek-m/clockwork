package com.mjamsek.clockwork.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
    
    private static final String PERSISTENCE_UNIT = "persistence";
    
    private static EntityManager managerInstance = null;
    
    public static EntityManager getEntityManager() {
        if (managerInstance == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            managerInstance = factory.createEntityManager();
        }
        return managerInstance;
    }
    
}
