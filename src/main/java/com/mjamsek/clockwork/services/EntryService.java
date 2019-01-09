package com.mjamsek.clockwork.services;

import com.mjamsek.clockwork.entities.Entry;
import com.mjamsek.clockwork.repositories.EntryRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EntryService {
    
    public static List<Entry> getAllEntriesFromThisWeek() {
        Date startOfWeek = getStartOfWeek();
        return EntryRepository.getEntriesNewerThan(startOfWeek);
    }
    
    public static List<Entry> getAllEntriesFromThisMonth() {
        return new ArrayList<>();
    }
    
    private static Date getStartOfWeek() {
        // Sunday - 1
        Date today = new Date();
    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
    
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    
        int subtractDays = -1 * (dayOfWeek - 1);
    
        calendar.add(Calendar.DAY_OF_MONTH, subtractDays);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
    
}
