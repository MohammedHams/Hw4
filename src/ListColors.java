/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author MohammedHams
 */
public class ListColors extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         ObservableList<String> items = FXCollections.observableArrayList("Black", "Blue","Cyan","Dark Gray","Gray","Green");
        ObservableList<String> items2 = FXCollections.observableArrayList("Black", "Blue","Cyan","Dark Gray","Gray","Green");
         ListView lst1=new ListView(items);
        Button btnCopy=new Button("Copy>>>");
        ListView lst2=new ListView();
       
                ArrayList<String> li = new ArrayList();
   
                    for (int i = 0; i < li.size(); i++) {
                        items.add(i, li.get(i));
                        
                    }
        lst1.setMaxSize(200,200);
        lst2.setMaxSize(200,200);
        HBox hbox=new HBox(10,lst1,btnCopy,lst2);
        hbox.setPadding(new Insets(5));
        hbox.setAlignment(Pos.CENTER);
        
       lst1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       
       
        Scene scene = new Scene(hbox,500,250);
        btnCopy.setOnAction((ActionEvent event) -> {
            lst2.getItems().setAll(lst1.getSelectionModel().getSelectedItems());
         });
        scene.getStylesheets().add("Style.css");
        primaryStage.setTitle("Multiple Selection Lists");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
