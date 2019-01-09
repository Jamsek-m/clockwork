package com.mjamsek.clockwork.controllers;

import com.mjamsek.clockwork.entities.Entry;
import com.mjamsek.clockwork.repositories.EntryRepository;
import com.mjamsek.clockwork.services.EntryService;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class IndexController implements Initializable {
    
    public DatePicker date;
    
    public TextField workedHours;
    
    public Label successMessage;
    
    public Label workedHoursMessage;
    
    public void saveWorkedHours() {
        this.successMessage.setVisible(false);
        Entry entry = new Entry();
        
        if (this.date.getValue() != null && !this.workedHours.getText().isEmpty()) {
            Date date = Date.from(this.date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            entry.setEntryDate(date);
            int workedHours = Integer.parseInt(this.workedHours.getText());
            entry.setWorkedHours(workedHours);
    
            EntryRepository.saveEntry(entry);
            System.out.println(entry.toString());
            
            List<Entry> entries = EntryRepository.getAllEntries();
            for(Entry e : entries) {
                System.out.println(e.toString());
            }
            this.successMessage.setVisible(true);
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Entry> entriesFromThisWeek = EntryService.getAllEntriesFromThisWeek();
        long hoursThisWeek = entriesFromThisWeek.stream().map(Entry::getWorkedHours).reduce((acc, next) -> acc + next).orElse(0);
        this.workedHoursMessage.setText(String.valueOf(hoursThisWeek) + "h");
    }
}
