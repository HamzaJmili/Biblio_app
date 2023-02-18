package com.example.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.App;
import com.example.Modele_auteur;
import com.example.conn;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class AddauteurController {
    @FXML
    Button  annuler;
     @FXML
     public void annuler(){
        ((Stage) annuler.getScene().getWindow()).close();
     }
     @FXML
     TextField nom;
     @FXML
     TextField prenom;
     @FXML
     TextArea bioo;
     @FXML
     protected void initialize () throws SQLException{
        bioo.setStyle("-fx-control-inner-background: #222222;");}
     @FXML
     public void valider() throws IOException, SQLException{
        Modele_auteur.insert_into_auteur(nom.getText(), prenom.getText(),  bioo.getText());
                ((Stage) annuler.getScene().getWindow()).close(); 
               
        
    }
 
     }
    


