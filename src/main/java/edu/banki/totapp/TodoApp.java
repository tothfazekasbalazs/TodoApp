package edu.banki.totapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoApp extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Todo List");

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/edu/banki/totapp/todo-view.fxml"));

        Scene scene = new Scene(fxmlloader.load(), 400, 300);
        stage.setScene(scene);
        stage.show();

        //inputField.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}