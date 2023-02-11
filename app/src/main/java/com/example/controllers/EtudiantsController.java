package com.example.controllers;

import java.sql.SQLException;

import com.example.Etudiant;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import java.sql.*;

public class EtudiantsController {
    @FXML
    public  TableView<Etudiant> tableetu;
    @FXML
    TableColumn<Etudiant,String> cne;
    @FXML
    TableColumn<Etudiant,String> nom;
    @FXML
    TableColumn<Etudiant,String> prenom;
    @FXML
    TableColumn<Etudiant,String> email;
    int i=0 ;
    @FXML
    TableColumn<Etudiant,String> fil;
    @FXML
    private TableColumn<Etudiant, String> editCol;
    Etudiant Etudiant = null ;
    public void loadData() throws SQLException{
        ObservableList<Etudiant> e=Modele_etudiant.load();
        tableetu.setItems(e);
        
        
    }
    @FXML
    protected void initialize () throws SQLException{
     cne.setCellValueFactory(new PropertyValueFactory<>("cne"));
       nom.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
       prenom.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
       email.setCellValueFactory(new PropertyValueFactory<>("email_user"));
       fil.setCellValueFactory(new PropertyValueFactory<>("filiere"));

Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFoctory = (TableColumn<Etudiant, String> param) -> {
    // make cell containing buttons
    final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            //that cell created only on non-empty rows
            if (empty) {
                setGraphic(null);
               

            } else {
System.out.println(i);
                Button deleteIcon = new Button();
                deleteIcon.setId(""+(i-1));
                i++;
              
               

                deleteIcon.setStyle(
                        " -fx-cursor: hand ;"
                        + "-glyph-size:28px;"
                        + "-fx-fill:#ff1744;"
                );
              
                deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                    Character b= deleteIcon.getId().charAt(0);
                   
                    int a=Character.getNumericValue(b);
                    Etudiant er= tableetu.getItems().get(a);
                    System.out.println(er.getCne());
                    
                    
                    
                   


                });

                HBox managebtn = new HBox( deleteIcon);
                managebtn.setStyle("-fx-alignment:center");
                HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
               

                setGraphic(managebtn);

                setText(null);

            }
        }

    };

    return cell;
};
 editCol.setCellFactory(cellFoctory);

 this.loadData();
 
 
}

}
    

