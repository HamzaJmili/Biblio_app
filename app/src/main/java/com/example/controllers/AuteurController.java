package com.example.controllers;

import java.sql.SQLException;

import com.example.Auteur;
import com.example.Etudiant;
import com.example.Modele_auteur;
import com.example.Modele_etudiant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import java.sql.*;

public class AuteurController {
    @FXML
    public  TableView<Auteur> tableetu;
    @FXML
    TableColumn<Auteur,Integer> id;
    @FXML
    TableColumn<Auteur,String> nom;
    @FXML
    TableColumn<Auteur,String> prenom;
    @FXML
    TableColumn<Auteur,String> bio;
   
    int i=0 ;
   
    Etudiant Etudiant = null ;
    public void loadData() throws SQLException{
        ObservableList<Auteur> e=Modele_auteur.load();
        
        tableetu.setItems(e);
        
        
    }
    @FXML
    protected void initialize () throws SQLException{
     id.setCellValueFactory(new PropertyValueFactory<>("id_auteur"));
       nom.setCellValueFactory(new PropertyValueFactory<>("nom_auteur"));
       prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_auteur"));
       bio.setCellValueFactory(new PropertyValueFactory<>("bio_auteur"));
      


 
 this.loadData();
 
 
}

}
    

