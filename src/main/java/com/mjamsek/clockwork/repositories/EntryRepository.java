package com.mjamsek.clockwork.repositories;

import com.mjamsek.clockwork.db.DatabaseManager;
import com.mjamsek.clockwork.db.EntityNotFoundException;
import com.mjamsek.clockwork.entities.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class EntryRepository {
    
    private static EntityManager em = DatabaseManager.getEntityManager();
    
    public static List<Entry> getAllEntries() {
        TypedQuery<Entry> query = em.createNamedQuery("Entry.findAll", Entry.class);
        return query.getResultList();
    }
    
    public static Entry getEntry(long entryId) {
        Entry entry = em.find(Entry.class, entryId);
        if (entry == null) {
            throw new EntityNotFoundException(Entry.class, entryId);
        }
        return entry;
    }
    
    public static List<Entry> getEntriesNewerThan(Date compareDate) {
        TypedQuery<Entry> query = em.createNamedQuery("Entry.largerThanDate", Entry.class);
        query.setParameter("compareDate", compareDate);
        return query.getResultList();
    }
    
    public static void saveEntry(Entry entry) {
        em.getTransaction().begin();
        em.persist(entry);
        em.getTransaction().commit();
    }
    
    public static void editEntry(Entry entry) {
        em.getTransaction().begin();
        em.merge(entry);
        em.getTransaction().commit();
    }
    
    public static void deleteEntry(long entryId) {
        Entry entry = em.find(Entry.class, entryId);
        if (entry == null) {
            throw new EntityNotFoundException(Entry.class, entryId);
        }
        em.getTransaction().begin();
        em.remove(entry);
        em.getTransaction().commit();
    }
}
