package com.example.controllers;





import java.io.IOException;



import com.example.Etudiant;
import com.example.Modele_etudiant;

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
    Label nomprenometudiant ;
    @FXML
    Label cne ;
   
    @FXML
   void initialize() { 
       System.out.println("'''''''''''''''''''''''ttttttttttttttttttttttttt/n/n");
       final Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);
       cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       totalLivresEmprt.setText("0");
       // TitreLivreEmpt.setText("");
    }
     
    

    @FXML
    void closeButtonClicked(ActionEvent event) throws IOException {
        
        ((Stage) closeButton.getScene().getWindow()).close();
        
       
    }

 static Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);


}