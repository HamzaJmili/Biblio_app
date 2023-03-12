package com.example.controllers;

import java.sql.SQLException;
import java.time.LocalDate;

import com.example.Livre;
import com.example.Modele_livre;
import com.example.Modele_reserve;
import com.example.Session;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ReserverController {
    @FXML
    DatePicker date_fin;
    @FXML
    Button annuler;
    @FXML
    Label title;
    @FXML
    void initialize ()  throws SQLException{
        Livre livre =Modele_livre.getBook(ListOfBooksStudentController.id);
        title.setText(title.getText()+" "+livre.getTitre());
    }
     @FXML
    public void annuler(){
        ((Stage) annuler.getScene().getWindow()).close();
    }
    @FXML
    public void submit() throws SQLException{
       System.out.println(Session.id_utiliasteur+"  "+Session.nom_utiliasteur);
    }
}
