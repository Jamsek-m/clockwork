package com.mjamsek.clockwork.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {
    
    @FXML
    private ToggleGroup toggleGrp;
    
    public Label lbl1;
    
    public void handleSelection() {
        RadioButton radio = (RadioButton) toggleGrp.getSelectedToggle();
        System.out.println(radio.getText());
    }
    
    
    
}
