package com.example.controllers;





import com.example.Etudiant;
import com.example.Modele_etudiant;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

 static Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);
    
 
 
  

}