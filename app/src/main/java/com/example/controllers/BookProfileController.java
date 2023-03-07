package com.example.controllers;

import java.sql.SQLException;

import com.example.Livre;
import com.example.Modele_auteur;
import com.example.Modele_livre;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class BookProfileController {
    @FXML ImageView couverture ;
    @FXML Label  title ;
    @FXML Text description ;
    @FXML Label nom_auteur ;
    @FXML Label  nb_pages;
   
    @FXML
    void initialize ()  throws SQLException{
       Livre L=Modele_livre.getBook(ListOfBooksStudentController.id);       
        title.setText(L.getTitre());
        description.setText(L.getDescription());
        nom_auteur.setText(Modele_auteur.getWriterName(L.getId_auteur()));
        nb_pages.setText(""+L.getNombre_pages());
        Image image = new Image(getClass().getResource("/com/example/books_cover/2.jpg").toExternalForm());
        couverture.setImage(image);
       
        // Image image = new Image("file:/path/to/"+L.getCouverture());
        // couverture.setImage(image);


    }
}

