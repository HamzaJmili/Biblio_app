package com.example.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import com.example.App;
import com.example.Auteur;
import com.example.Livre;
import com.example.Modele_auteur;
import com.example.Modele_livre;
import com.example.Session;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class leftbarEtudiantController {
    @FXML
    Button Parametres;
    @FXML
    Button Acceuil;
    @FXML
    void gotoparam() throws IOException{
       
     
         App.setRoot(Parametres.getScene(),"param");
}

@FXML
void gotolivre() throws IOException{
    
    App.setRoot(Parametres.getScene(),"ListOfBooksStudent");
}

@FXML
public void gotocmpt() throws IOException{
    Stage stage2 =new Stage();
    Scene scene2 = new Scene(App.loadFXML("inform"));
      stage2.setScene(scene2);
      stage2.setResizable(false);
      stage2.initModality(Modality.APPLICATION_MODAL);
      stage2.show();
  }
@FXML
void decon() throws IOException{
    Session.email_utiliasteur=null;
    Session.id_utiliasteur=null;
    Session.nom_utiliasteur=null;
    Session.prenom_utiliasteur=null;
    ((Stage)  Parametres.getScene().getWindow()).close();
    Stage stage2 =new Stage();
    Scene scene2 = new Scene(App.loadFXML("login_inter"));
      stage2.setScene(scene2);
      stage2.setResizable(false);
      stage2.initStyle(StageStyle.UNDECORATED);
      stage2.show();
   
}
@FXML
void gotoaide() throws IOException{
       
     
    App.setRoot(Parametres.getScene(),"aide");
}
@FXML
void gotoAcceuil() throws IOException{
       
     
    App.setRoot(Acceuil.getScene(),"ListOfBooksStudent");
}

}


