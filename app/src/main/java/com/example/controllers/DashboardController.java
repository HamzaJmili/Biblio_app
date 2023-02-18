package com.example.controllers;

import java.sql.SQLException;

import com.example.Modele_auteur;
import com.example.Modele_etudiant;
import com.example.Modele_livre;
import com.example.Modele_tag;
import com.example.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
 

public class DashboardController {
    @FXML
    Label nb_etu;
    @FXML
    Label nb_livre;
    @FXML
    Label nb_auteur;
    @FXML 
    Label nb_tag;
    @FXML 
    Label label;
    @FXML
    protected void initialize () throws SQLException{
        
        label.getStyleClass().add("outline");
       leftbarController.button_selected='D';
       nb_etu.setText(""+Modele_etudiant.countetu());
       nb_livre.setText(""+Modele_livre.countlivre());
       nb_auteur.setText(""+Modele_auteur.countauteur());
       nb_tag.setText(""+Modele_tag.counttag());
       
    }
}
