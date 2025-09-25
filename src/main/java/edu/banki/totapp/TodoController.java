package edu.banki.totapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TodoController implements Initializable {
    @FXML
    private ListView<String> todoListView;
    @FXML
    private TextField inputField;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private HBox inputRow;
    @FXML
    private VBox bottomPanel;

    private ObservableList<String> todoItems = FXCollections.observableArrayList();

    public VBox createLayout() throws IOException {

       // todoListView = new ListView<>(todoItems);
       // todoListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
       // inputField = new TextField();
       // inputField.setPromptText("Írj be egy új teendőt");
       // inputField.setOnAction(e -> addTodo());
//
       // addButton = new Button("Hozzáadás");
       // addButton.setOnAction(e -> addTodo());
//
       // deleteButton = new Button("Kijelölt elem törlése");
       // deleteButton.setOnAction(e -> deleteSelectedTodos());
       // inputRow = new HBox(10);
//
       // inputRow.getChildren().addAll(inputField, addButton);
       // bottomPanel = new VBox(10, todoListView, inputRow, deleteButton);
       // bottomPanel.setPadding(new Insets(10));

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/edu/banki/totapp/todo-view.fxml"));
        bottomPanel = fxmlloader.load();

        return bottomPanel;
    }

    private void addTodo() {
        String todoText = inputField.getText().trim();
        if (!todoText.isEmpty()) {
            todoItems.add(todoText);
            inputField.clear();
            inputField.requestFocus();
        }
    }

    private void deleteSelectedTodos() {
        ObservableList<String> selectedItems = todoListView.getSelectionModel().getSelectedItems();
        if (!selectedItems.isEmpty()) {
            ObservableList<String> itemsToDelete = FXCollections.observableArrayList(selectedItems);
            todoItems.removeAll(itemsToDelete);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        todoListView.setItems(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        addButton.setOnAction(actionEvent -> {
            addTodo();
        });
        deleteButton.setOnAction(actionEvent -> {
            deleteSelectedTodos();
        });
    }
}