package com.mjamsek.clockwork.entities;

import javax.persistence.*;

@Entity
@Table(name = "testna")
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM TestEntity t")
})
public class TestEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
