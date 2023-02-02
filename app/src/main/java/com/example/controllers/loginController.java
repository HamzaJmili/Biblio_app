package com.example.controllers;
import java.io.IOException;


import com.example.App;
import com.example.Admin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

import javafx.scene.Group;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController  {
    private static boolean visible = false ;
    protected static boolean isadmin=false;
   
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
    protected void initialize (){
        password_text_field.setVisible(false);
        etudiant.setStyle("-fx-border-style: hidden solid solid hidden;-fx-border-color : #FF5F00 ;-fx-border-radius: 3;-fx-background-color:#292929 ;-fx-border-width :1.5px ;");
         
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
                password_password_field.setVisible(false);
                password_text_field.setVisible(true);
                visible=true;
                
                return ;
            }
            if(visible==true){
                password_password_field.setText(password_text_field.getText());
                password_text_field.setVisible(false);
                password_password_field.setVisible(true);
                visible=false;
                return;
               
            }
           
        }

//    @FXML
//        boolean  seconnecter(){
  
//       // Admin a= com.example.modele_admin.checkadmin();
      
//         return false ;

//    }
    
}
