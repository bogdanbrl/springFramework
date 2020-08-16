package com.bogdanbrl.todolist;

import java.io.IOException;
import com.bogdanbrl.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main_window.fxml"));
        primaryStage.setTitle("Todo list");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void stop() throws Exception{
    	try {
    		TodoData.getTodoData().saveItemsOnFile();
    	}catch (IOException event) {
    		System.out.println(event.getMessage());
		}
    }
    
    @Override
    public void init() throws Exception{
    	try {
    		TodoData.getTodoData().loadItemsFromFile();
    	}catch (IOException event) {
    		System.out.println(event.getMessage());
		}
    }
}

