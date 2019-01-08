package com.mjamsek.clockwork;

import com.mjamsek.clockwork.entities.TestEntity;
import com.mjamsek.clockwork.repositories.TestRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.initDb();
        
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/sample.fxml"));
        primaryStage.setTitle("ClockWork");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    private void initDb() {
        for(TestEntity ent : TestRepository.findAll()) {
            System.out.println(ent.getId() + " :: " + ent.getName());
        }
    }
    
}
