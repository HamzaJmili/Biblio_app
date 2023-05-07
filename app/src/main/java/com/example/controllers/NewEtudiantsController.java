package com.example.controllers;

import java.sql.SQLException;
import java.util.Vector;

import com.example.App;
import com.example.Etudiant;
import com.example.Modele_etudiant;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;


public class NewEtudiantsController {
  
    @FXML
    VBox Vbox ;

    @FXML TextField find_field;
    public static String cni =null;
    Etudiant Etudiant = null ;
    public static String s =null ;
  
        
        
    
    @FXML
    protected void initialize () throws SQLException{
    
         
loadList(Modele_etudiant.getEdutiants());

















// Button viewIcon = new Button();

              



                // viewIcon.setId();
            
    }

   public void loadList( Vector<Etudiant> etudiants ) {
    for(int i=0 ; i < etudiants.size() ; i++) {
        Pane pane = new Pane() ;
        Label cne = new Label() ;
        Label nom = new Label() ;
        Label prenom = new Label() ;
        Label filiere = new Label() ;
        Label email = new Label() ;
        Label telephone = new Label() ;
         // Button viewIcon = new Button();
        cne.setText(etudiants.get(i).getCne());
        nom.setText(etudiants.get(i).getNom_user());
        prenom.setText(etudiants.get(i).getPrenom_user());
        email.setText(etudiants.get(i).getEmail_user());
        telephone.setText(etudiants.get(i).getTelephone());
        filiere.setText(etudiants.get(i).getFiliere());



        cne.setLayoutX(30);
        cne.setLayoutY(10);
        nom.setLayoutX(200);
        nom.setLayoutY(10);
        prenom.setLayoutX(300);
        prenom.setLayoutY(10);
        filiere.setLayoutX(400);
        filiere.setLayoutY(10);
        telephone.setLayoutX(450);
        telephone.setLayoutY(10);
        email.setLayoutX(670);
        email.setLayoutY(10);
        // viewIcon.setLayoutX(i);
        
        cne.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
        cne.getStyleClass().add("textofcarte_admin");
        nom.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
        nom.getStyleClass().add("textofcarte_admin");
        prenom.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
        prenom.getStyleClass().add("textofcarte_admin");
        email.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
        email.getStyleClass().add("textofcarte_admin");
        telephone.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
        telephone.getStyleClass().add("textofcarte_admin");
        filiere.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
        filiere.getStyleClass().add("textofcarte_admin");




       
                // viewIcon.setId();
        pane.getChildren().add(cne);
        pane.getChildren().add(nom);
        pane.getChildren().add(prenom);
        pane.getChildren().add(filiere);
        pane.getChildren().add(email);
        pane.getChildren().add(telephone);
        // pane.getChildren().add(viewIcon);    

        pane.setPrefHeight(45);
        pane.setPrefWidth(140) ;
        pane.setStyle("-fx-background-color:white;") ;
        Insets margins = new Insets(5,10,10,10);
        Vbox.setPrefHeight(Vbox.getPrefHeight()+100);
       pane.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
       pane.getStyleClass().add("carte_livre_admin");
        Vbox.getChildren().add(pane);
        Vbox.setMargin(pane, margins);
    }
    

   } 









@FXML 
public void find(){
s=find_field.getText();
Etudiant etu=Modele_etudiant.getProfileEtudiant(EtudiantsController.s);
if(etu==null){
Alert a=new Alert(AlertType.ERROR);
a.setContentText("il n'a pas un etudiant avec ce cne");

a.show();
}else{
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
 stage.initStyle(StageStyle.UNDECORATED);
  stage.show();
}}

}
    

