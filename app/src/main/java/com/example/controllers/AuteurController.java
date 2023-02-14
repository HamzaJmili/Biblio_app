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
       Image image = new Image("file:C:/Users/ilias/Desktop/projet/Biblio_app/app/src/main/resources/com/example/icons/aut.png");
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(45);
    imageView.setFitHeight(45);
    
    
     addaut.setGraphic(imageView);
   
    
      
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
                    setGraphic(null);
                    id.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-border-radius: 10;-fx-font-weight: bold;" );
                    nom.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-font-weight: bold;" );
                    prenom.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-font-weight: bold;" );
                   bio.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-font-weight: bold;" );
                   
                    supCol.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
                   
    
                } else {
    
    Button deleteIcon = new Button();
    
                  
    
    
    
                    deleteIcon.setId(""+(i-1));
                    i++;
                    id.setStyle(" -fx-text-fill: white;");
                    
    if((i%2)!=0)    {       
         
    id.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-border-radius: 10;-fx-font-weight: bold;" );
    nom.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-font-weight: bold;" );
    prenom.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-font-weight: bold;" );
   bio.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-font-weight: bold;" );
   
    supCol.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
    deleteIcon.setStyle("-fx-background-color:transparent ");
    Image image = new Image("file:C:/Users/ilias/Desktop/projet/Biblio_app/app/src/main/resources/com/example/icons/delete-noir.png");
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(19);
    imageView.setFitHeight(19);
    
     deleteIcon.setGraphic(imageView);
    
    
    
    }
    
    else{
        
        id.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-border-radius: 10;-fx-font-weight: bold;" ); 
        nom.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-font-weight: bold;" );
    prenom.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-font-weight: bold;" );
    bio .setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-font-weight: bold;" );
    supCol.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-font-weight: bold;" );
    
    deleteIcon.setStyle("-fx-background-color:transparent ");
    Image image = new Image("file:C:/Users/ilias/Desktop/projet/Biblio_app/app/src/main/resources/com/example/icons/delete-asfar.png");
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(19);
    imageView.setFitHeight(19);
    
     deleteIcon.setGraphic(imageView); 
    }
   
    deleteIcon.setOnMouseClicked((MouseEvent event) -> {
        Character b= deleteIcon.getId().charAt(0);
       
        int a=Character.getNumericValue(b);
        Auteur er= tableetu.getItems().get(a);
      Connection con=conn.getConnection();
      String sql = "DELETE FROM auteur WHERE ID_AUTEUR = ?";
      
      try (PreparedStatement stmt = con.prepareStatement(sql)) {
    stmt.setInt(1,er.getId_auteur() );
              stmt.executeQuery();
             
              leftbarController.button_selected='U';
              App.setRoot(addaut.getScene(), "listeauteur");
              
             
              
            
} catch (SQLException e) {
    System.out.println("errrrr");
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
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
     
     
    }}



    

