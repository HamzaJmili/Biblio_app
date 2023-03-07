package com.example.controllers;

import java.sql.SQLException;

import com.example.Admin;
import com.example.App;
import com.example.Auteur;
import com.example.Etudiant;
import com.example.Modele_auteur;
import com.example.Modele_etudiant;
import com.example.conn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
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
    @FXML
    private TableColumn<Etudiant, String> supCol;
    @FXML
    Button addaut;
    @FXML
    Button refresh;
   
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
       Image image  = new Image(getClass().getResource("/com/example/icons/aut.png").toExternalForm());

    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(45);
    imageView.setFitHeight(45);
    
    
     addaut.setGraphic(imageView);
     Image image2  = new Image(getClass().getResource("/com/example/icons/refresh-page-option.png").toExternalForm());

    ImageView imageView2 = new ImageView(image2);
    imageView2.setFitWidth(33);
    imageView2.setFitHeight(33);
    refresh.setGraphic(imageView2);
   
    
      
       Callback<TableColumn<Etudiant, String>, TableCell<Etudiant, String>> cellFoctory = (TableColumn<Etudiant, String> param) -> {
        // make cell containing buttons
        final TableCell<Etudiant, String> cell = new TableCell<Etudiant, String>() {
            /* (non-Javadoc)
             * @see javafx.scene.control.Cell#updateItem(java.lang.Object, boolean)
             */
            /* (non-Javadoc)
             * @see javafx.scene.control.Cell#updateItem(java.lang.Object, boolean)
             */
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                
                //that cell created only on non-empty rows
                if (empty) {
                 
    
                } else {
    
    Button deleteIcon = new Button();
    
                  
    
    
    
                    deleteIcon.setId(""+(i-1));
                    i++;
                    id.setStyle(" -fx-text-fill: white;");
                           
  

    deleteIcon.setStyle("-fx-background-color:transparent ");
    Image image  = new Image(getClass().getResource("/com/example/icons/delete-asfar.png").toExternalForm());
    
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(19);
    imageView.setFitHeight(19);
    
     deleteIcon.setGraphic(imageView);
    
    
    
    
    
   
   
    deleteIcon.setOnMouseClicked((MouseEvent event) -> {
        Character b= deleteIcon.getId().charAt(0);
       
        int a=Character.getNumericValue(b);
        Auteur er= tableetu.getItems().get(a);
        
        try {
            System.out.println(1234);
            Modele_auteur.DELETE_FROM_auteur(er.getId_auteur());
        } catch (SQLException e) {
            System.out.println("error in database ");
            e.printStackTrace();
        }
    
        leftbarController.button_selected='U';
        try {
            App.setRoot(addaut.getScene(), "listeauteur");
            System.out.println(12345);
        } catch (IOException e) {
            System.out.println("error in change interface");
            e.printStackTrace();
        }
        
        
       


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
     supCol.setCellFactory(cellFoctory);
    
     this.loadData();
     
     
    }
   
    @FXML
    public void addaut(){

        Stage stage =new Stage();
        Scene scene4=null ;
        try {
            scene4 = new Scene(App.loadFXML("addauteur"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
       
          stage.setScene(scene4);
          stage.setResizable(false);
         stage.initStyle(StageStyle.UNDECORATED);
         stage.initModality(Modality.APPLICATION_MODAL);
          stage.show();
        
    }
    @FXML
    public void refresh() throws SQLException{
        ObservableList<Auteur> e=Modele_auteur.load();
        
        tableetu.setItems(e);
    }
    
}



    

