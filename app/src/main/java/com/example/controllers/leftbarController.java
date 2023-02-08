package com.example.controllers;

import com.example.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class leftbarController {
    @FXML
    Label nom_utilisateur;
    @FXML
    protected void initialize (){
       
       nom_utilisateur.setText(Session.nom_utiliasteur+" "+Session.prenom_utiliasteur);
    }
}
