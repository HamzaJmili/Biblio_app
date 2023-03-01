package com.example.controllers;





import java.io.IOException;



import com.example.Etudiant;
import com.example.Modele_etudiant;
import com.example.Session;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EtudiantProfilController {
    @FXML
    Label filiere ;
    @FXML
    Label email ;
    @FXML
    Label telephone ;
    @FXML
    Label totalLivresEmprt ;
    @FXML
    Label TitreLivreEmpt;
    @FXML
    Button closeButton ;
    @FXML 
    Button closeButton1;
    @FXML
    Label nomprenometudiant ;
    @FXML
    Label cne ;
   
    @FXML
   void initialize() { 
    if(closeButton.getText().compareTo("X")==0){
       final Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);
       cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       totalLivresEmprt.setText("Livre(s)");}
       else{
        Etudiant etu=Modele_etudiant.getetuparemail(Session.email_utiliasteur);
        cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       totalLivresEmprt.setText("Livre(s)");}

       }
       // TitreLivreEmpt.setText("");
    
     
    

    @FXML
    void closeButtonClicked(ActionEvent event) throws IOException {
        System.out.println(closeButton.getScene().getWindow());
        ((Stage) closeButton.getScene().getWindow()).close();
        
       
    }

 static Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);


}