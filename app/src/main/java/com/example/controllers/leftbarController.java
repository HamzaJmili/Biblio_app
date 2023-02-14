package com.example.controllers;

import java.io.IOException;

import com.example.App;
import com.example.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class leftbarController {
    @FXML
    Label nom_utilisateur;
    @FXML
    Button dashboard;
    @FXML
    Button admin;
    public static String button_selected ;
    @FXML
    Button etudiants;

    @FXML
    protected void initialize (){
         char first_char = Session.prenom_utiliasteur.charAt(0) ;
       nom_utilisateur.setText(new String(new char[]{first_char}).toUpperCase());
       make_effect_to_selected_button();
      
    }

    void make_effect_to_selected_button(){
        if (leftbarController.button_selected.equals("dashboard")){
             dashboard.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
         }
         else  if (leftbarController.button_selected.equals("admin")){
             admin.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
         }
         else  if (leftbarController.button_selected.equals("etudiants")){
             etudiants.setStyle("-fx-background-color:#E38B29;-fx-text-fill: #222222;");
         }
    }

    @FXML
    void gotodashboard() throws IOException{
         leftbarController.button_selected="dashboard";
         App.setRoot(dashboard.getScene(),"dashboard");
       
    }
    /**
     * @throws IOException
     */
    @FXML
    void gotoadmin() throws IOException{
         dashboard.setStyle(null);
         leftbarController.button_selected="admin";
         App.setRoot(dashboard.getScene(),"admins");

        
    }
    @FXML
    void gotoListeEtudiants() throws IOException{
         dashboard.setStyle(null);
         leftbarController.button_selected="etudiants";
         App.setRoot(dashboard.getScene(),"ListeEtudiants");
}
@FXML 
void gotoAuteurs() throws IOException{
    dashboard.setStyle(null);
    leftbarController.button_selected="auteurs";
    App.setRoot(dashboard.getScene(),"listeauteur");
}
}
