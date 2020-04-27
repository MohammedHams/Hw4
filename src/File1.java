/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaPR3_HW2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author MohammedHams
 */
public class File1 extends Application{
    
   private TextArea textAreaFileContent;
    private final ObservableList<String> items = FXCollections.observableArrayList("black", "blue","cyan","gray","green");
   private final ObservableList<String> Fonts = FXCollections.observableArrayList("Times New Roman","Arial","sans-serif");
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
       MenuBar bar=new MenuBar();
        Menu menuFile=new Menu("_File");
        MenuItem item1=new MenuItem("_Open");
        MenuItem item2=new MenuItem("_Close");
        MenuItem item3=new MenuItem("E_xit");
        menuFile.getItems().addAll(item1,item2,item3);
        Menu menuFile2=new Menu("_Edit");
        MenuItem item4=new MenuItem("Co_lor");
        MenuItem item5=new MenuItem("_Font");
       
        menuFile2.getItems().addAll(item4,item5);
        bar.getMenus().addAll(menuFile,menuFile2);
        
      textAreaFileContent=new TextArea("");
        
        HBox hbox=new HBox(bar);
        VBox vbox=new VBox(10,hbox,textAreaFileContent);
        
        EventHandler1 eventhandler=new EventHandler1();
        item1.setOnAction(eventhandler);
        item2.setOnAction(eventhandler);
        item3.setOnAction(eventhandler);
        item4.setOnAction(eventhandler);
        item5.setOnAction(eventhandler);
        Scene scene=new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
        private class EventHandler1 implements EventHandler<ActionEvent>
    {
            private String color;
        @Override
        public void handle(ActionEvent event) {
            String menu=((MenuItem)event.getSource()).getText();
            switch(menu)
            {
                case "_Open":
                    FileChooser fo=new FileChooser();
                    fo.setInitialDirectory(new File("."));
                    File file=fo.showOpenDialog(null);
                    textAreaFileContent.setText("");
                    textAreaFileContent.setWrapText(true);
            {
                try {
                    Scanner s=new Scanner(file);
                    while(s.hasNext())
                    {
                        textAreaFileContent.appendText((s.nextLine()));
                        
                    }
                        
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(File1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
                case "_Close":
                   textAreaFileContent.setText("");
                   textAreaFileContent.setEditable(false);
                break;
                
                case "E_xit":
                    System.exit(0);
                break;
                case "Co_lor":
                    

                    ChoiceDialog cd=new ChoiceDialog(items.get(0),items);
                    cd.setTitle("Color Selection");
                    cd.setHeaderText("Select the color from list");
                    cd.setContentText("Available Color");
                    cd.showAndWait().get();
                    color=String.valueOf(cd.getSelectedItem());
                    textAreaFileContent.setStyle("-fx-text-fill:"+color+";");
                    
                break;
               
                case "_Font":
                    ChoiceDialog cd2=new ChoiceDialog(Fonts.get(0),Fonts);
                    cd2.setTitle("Color Selection");
                    cd2.setHeaderText("Select the color from list");
                    cd2.setContentText("Available Color");
                    cd2.showAndWait().get();
                    String Font=String.valueOf(cd2.getSelectedItem());
                    textAreaFileContent.setStyle("-fx-text-fill:"+color+";");
                    textAreaFileContent.setStyle("-fx-font-family:"+Font+";");
                break;
                
                 
            }
        }
        
       
    }
    
}
