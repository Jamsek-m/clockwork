package com.mjamsek.clockwork.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entries")
@NamedQueries({
    @NamedQuery(name = "Entry.findAll", query = "SELECT e FROM Entry e"),
    @NamedQuery(name = "Entry.largerThanDate", query = "SELECT e FROM Entry e WHERE e.entryDate > :compareDate")
})
public class Entry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "entry_date")
    @Temporal(TemporalType.DATE)
    private Date entryDate;
    
    @Column(name = "worked_hours")
    private int workedHours;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Date getEntryDate() {
        return entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    
    public int getWorkedHours() {
        return workedHours;
    }
    
    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }
    
    @Override
    public String toString() {
        return String.format("Entry = {id: %d, entryDate: %s, workedHours: %d}", this.id, this.entryDate.toString(), this.workedHours);
    }
}
