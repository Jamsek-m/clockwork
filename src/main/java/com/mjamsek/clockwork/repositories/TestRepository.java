package com.mjamsek.clockwork.repositories;

import com.mjamsek.clockwork.db.DatabaseManager;
import com.mjamsek.clockwork.entities.TestEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TestRepository {
    
    private static EntityManager em = DatabaseManager.getEntityManager();
    
    public static List<TestEntity> findAll() {
        TypedQuery<TestEntity> query = em.createNamedQuery("Test.findAll", TestEntity.class);
        return query.getResultList();
    }
    
}
