package com.example.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.App;
import com.example.conn;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
     TextField bio;
     @FXML
     public void valider() throws IOException, SQLException{
        Connection con=conn.getConnection();
        String sql = "insert into auteur(nom_auteur,prenom_auteur,bio_auteur) values(?,?,?)";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
     stmt.setString(1, nom.getText());
     stmt.setString(2, prenom.getText());
     stmt.setString(3, bio.getText());
    
                stmt.executeQuery();   
                ((Stage) annuler.getScene().getWindow()).close(); 
               
        
    }
 
     }
    }


