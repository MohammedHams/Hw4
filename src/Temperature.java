/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MohammedHams
 */
public class Temperature extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lbl1=new Label("Enter Celsuis temperature");
        Label lbldgree=new Label();
        TextField txttemp=new TextField();
        RadioButton rdF=new RadioButton("Fahrenheit");
        RadioButton rdK=new RadioButton("Kelvin");
        ToggleGroup radiogroup=new ToggleGroup();
        rdF.setToggleGroup(radiogroup);
        rdK.setToggleGroup(radiogroup);
        HBox hbox=new HBox(10,rdF,rdK);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox=new VBox(10,lbl1,txttemp,hbox,lbldgree);
        vbox.setAlignment(Pos.CENTER);
           rdF.setSelected(true);
        txttemp.setOnAction((ActionEvent event) -> {
            double dgree;
            if(!txttemp.getText().equals(""))
            {
                if(rdF.isSelected())
                {
                    dgree=Double.parseDouble(txttemp.getText())*9/5+32;
                    lbldgree.setText("New Temp"+dgree);
                    
                }
                else if(rdK.isSelected())
                {
                    dgree=Double.parseDouble(txttemp.getText())+273.15;
                    lbldgree.setText("New Temp"+dgree);
                }
            }
        });
        
        Scene s=new Scene(vbox,300,200);
        primaryStage.setScene(s);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.show();
    }
    
}
