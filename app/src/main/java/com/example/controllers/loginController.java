package com.example.controllers;
import java.io.IOException;
import java.sql.SQLException;

import com.example.App;
import com.example.Etudiant;
import com.example.Modele_admin;
import com.example.Modele_etudiant;
import com.example.User;
import com.example.Admin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

import javafx.scene.Group;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController  {
    private static boolean visible = false ;
    protected static boolean isadmin=false;
   
        public static boolean isIsadmin() {
        return isadmin;
    }

        @FXML
        private Button closeButton;
        @FXML
        private PasswordField password_password_field;
        @FXML
        private TextField password_text_field ;
        @FXML
        private Button eye_button_passwordfield ;
        @FXML
        private Button admin ;
        @FXML
        private Button etudiant ;
        @FXML 
        private TextField email ;
        @FXML 
        private Label incorrect_mdps;
        

       
    @FXML
    protected void initialize (){
        password_text_field.setVisible(false);
        etudiant.setStyle("-fx-border-style: hidden solid solid hidden;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
        incorrect_mdps.setVisible(false);
    }
        
    
        @FXML
        void closeButtonClicked(ActionEvent event) throws IOException {
            
            ((Stage) closeButton.getScene().getWindow()).close();
            
           
        }
        @FXML
        void switchtoadmin(ActionEvent event) throws IOException {
            
            admin.setStyle("-fx-border-style: hidden hidden solid solid ;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
            etudiant.setStyle(null);
            isadmin=true;

           
        }
        @FXML
        void switchtoetudiant(ActionEvent event) throws IOException {
            
            etudiant.setStyle("-fx-border-style: hidden solid solid hidden;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
            admin.setStyle(null);
            isadmin=false;
           
        }

        
        @FXML
        void eye_button(ActionEvent event )throws IOException{
            if (visible==false){
                
                password_text_field.setText(password_password_field.getText());
                password_password_field.setText("");
                password_password_field.setVisible(false);
                password_text_field.setVisible(true);
                visible=true;
                
                return ;
            }
            if(visible==true){
                password_password_field.setText(password_text_field.getText());
                password_text_field.setText("");
                password_text_field.setVisible(false);
                password_password_field.setVisible(true);
                visible=false;
                return;
               
            }
           
        }

   
       User  verifierEtulisateur() throws SQLException{
        User utilisateur = null ; 
        if (isadmin==true){
             
            if (!password_password_field.getText().isEmpty())
            utilisateur =Modele_admin.checkadmin(email.getText(),password_password_field.getText());
           
             if (!password_text_field.getText().isEmpty())
             utilisateur=Modele_admin.checkadmin(email.getText(),password_text_field.getText());
        }else {
            if (!password_password_field.getText().isEmpty())
            utilisateur =Modele_etudiant.checkEtudiant(email.getText(),password_password_field.getText());
           
             if (!password_text_field.getText().isEmpty())
             utilisateur=Modele_etudiant.checkEtudiant(email.getText(),password_text_field.getText());
        }
     
        return utilisateur ;

   }
   @FXML
   void seconnecter (ActionEvent event) throws SQLException {
    if (verifierEtulisateur()==null){
        incorrect_mdps.setVisible(true);
    }
   }
  
    
}

