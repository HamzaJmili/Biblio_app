package com.example.controllers;

import java.sql.SQLException;

import com.example.App;
import com.example.Etudiant;
import com.example.Modele_etudiant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
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
    TableColumn<Etudiant,String> tel;
    @FXML
    private TableColumn<Etudiant, String> profile;
    Etudiant Etudiant = null ;
    public static String s =null ;
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
       tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));

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

Button deleteIcon = new Button();

              



                deleteIcon.setId(""+(i-1));
                i++;
                cne.setStyle(" -fx-text-fill: white;");
if((i%2)!=0)    {       
    
cne.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;-fx-border-radius: 10" );
nom.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
prenom.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
email .setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
fil.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
tel.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
profile.setStyle("-fx-background-color:#222222;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #222222;" );
deleteIcon.setStyle("-fx-background-color:transparent ");
Image image = new Image("file:C:/Users/ilias/Desktop/project1/Biblio_app/app/src/main/resources/com/example/icons/eye1.png");
ImageView imageView = new ImageView(image);
imageView.setFitWidth(30);
imageView.setFitHeight(30);

 deleteIcon.setGraphic(imageView);



}

else{
    
    cne.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-border-radius: 10" ); 
    nom.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;" );
prenom.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;" );
email .setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;" );
fil.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;" );
tel.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;" );
profile.setStyle("-fx-background-color:#E38B29;-fx-text-fill: white;-fx-alignment: center;-fx-border-color: #E38B29;-fx-border-radius: 10" ); 
deleteIcon.setStyle("-fx-background-color:transparent ");
Image image = new Image("file:C:/Users/ilias/Desktop/project1/Biblio_app/app/src/main/resources/com/example/icons/oeil (1).png");
ImageView imageView = new ImageView(image);
imageView.setFitWidth(30);
imageView.setFitHeight(30);

 deleteIcon.setGraphic(imageView); 
}
          
              
                deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                    Character b= deleteIcon.getId().charAt(0);
                   
                    int a=Character.getNumericValue(b);
                    Etudiant er= tableetu.getItems().get(a);
                    s=er.getCne();
                    Stage stage =new Stage();
                    Scene scene4=null ;
                    try {
                        scene4 = new Scene(App.loadFXML("EtudiantProfil"));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                     
                   
                      stage.setScene(scene4);
                      stage.setResizable(false);

                      stage.show();
                    
                    
                   


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
 profile.setCellFactory(cellFoctory);

 this.loadData();
 
 
}

}
    

