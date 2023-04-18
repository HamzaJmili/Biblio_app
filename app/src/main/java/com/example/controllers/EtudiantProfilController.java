package com.example.controllers;





import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.example.Etudiant;
import com.example.Livre;
import com.example.Modele_etudiant;
import com.example.Modele_reserve;
import com.example.Session;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public  TableView<Map<String, Object>> listeLivres;
    @FXML
    TableColumn<Map<String, Object>,String> titreLivre;
    @FXML
    TableColumn<Map<String, Object>,String> date_debut;
    @FXML
    TableColumn<Map<String, Object>,String> date_fin;

    public void loadData2() throws SQLException {
        List<Map<String, Object>> reservedBooksList = Modele_reserve.getReservedBooks(EtudiantsController.s);
        ObservableList<Map<String, Object>> reservedBooks = FXCollections.observableArrayList(reservedBooksList);
        
        listeLivres.setItems(reservedBooks);
    }
    @FXML
   void initialize() throws SQLException { 
    if(closeButton.getText().compareTo("X")==0){
       final Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);
       cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       totalLivresEmprt.setText("  5 Livre(s)");}
       else{
        Etudiant etu=Modele_etudiant.getetuparemail(Session.email_utiliasteur);
        cne.setText(etu.getCne());
       filiere.setText(etu.getFiliere().toUpperCase());
       email.setText(etu.getEmail_user());
       telephone.setText(etu.getTelephone());
       nomprenometudiant.setText((etu.getNom_user()+" "+etu.getPrenom_user()).toUpperCase());
       totalLivresEmprt.setText(" 5 Livre(s)");}
      
       titreLivre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("titre").toString()));
date_debut.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("startDate").toString()));
date_fin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("endDate").toString()));

       this.loadData2();       
       
       }
       // TitreLivreEmpt.setText("");
    
      
    

    @FXML
    void closeButtonClicked(ActionEvent event) throws IOException {
        System.out.println(closeButton.getScene().getWindow());
        ((Stage) closeButton.getScene().getWindow()).close();
        
       
    }

 static Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);


}