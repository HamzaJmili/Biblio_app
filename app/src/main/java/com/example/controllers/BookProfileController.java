package com.example.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

import com.example.App;
import com.example.Commentaire;
import com.example.Livre;
import com.example.Modele_auteur;
import com.example.Modele_cmnt;
import com.example.Modele_livre;
import com.example.Session;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BookProfileController {
    @FXML ImageView couverture ;
    @FXML Label  title ;
    @FXML Text description ;
    @FXML Label nom_auteur ;
    @FXML Label  nb_pages;
    @FXML  Button  BackIcon;
    @FXML  Button  reserver;
   @FXML    ScrollPane lst;
   @FXML TextField comnt;
   public int id_livre;
   @FXML public void addcmnt() throws SQLException, IOException{
Modele_cmnt.addLivre(1, id_livre, Session.id_utiliasteur, comnt.getText());
App.setRoot(reserver.getScene(), "BookProfile");
   }
    @FXML
    void initialize ()  throws SQLException{
       Livre L=Modele_livre.getBook(ListOfBooksStudentController.id);       
        title.setText(L.getTitre());
        id_livre=L.getId_livre();
        description.setText(L.getDescription());
        nom_auteur.setText(Modele_auteur.getWriterName(L.getId_auteur()));
        nb_pages.setText(""+L.getNombre_pages());
        Image image = new Image(getClass().getResource("/com/example/books_cover/"+L.getCouverture()).toExternalForm());
        couverture.setImage(image);
       if(L.getExemplaire()==0){
        reserver.setDisable(true);
       }
       
       Vector<Commentaire> listeofcmnts =Modele_cmnt.getcmnts(L.getId_livre());
       //hhdhdhdhdhdh
       if(listeofcmnts!=null){
       if(listeofcmnts.size()>0){
       VBox commentBox = new VBox();
commentBox.setSpacing(10);

// Itérer sur la liste des commentaires pour créer un HBox pour chaque commentaire
for (Commentaire commentaire : listeofcmnts) {
   
    LocalDate currentDate = LocalDate.now();
    long daysBetween = ChronoUnit.DAYS.between(commentaire.getCommentDate(), currentDate);
    Label texteLabel;
    if(daysBetween==0){
         texteLabel = new Label("aujourd'hui     "+commentaire.getContenu());
    }else{
texteLabel = new Label(daysBetween+"j     "+commentaire.getContenu());}

    // Créer un HBox pour contenir les deux Labels
    HBox commentaireBox = new HBox();
    commentaireBox.getChildren().addAll(texteLabel);

    // Ajouter le HBox du commentaire à la VBox de tous les commentaires
    commentBox.getChildren().add(commentaireBox);
}

// Ajouter la VBox de tous les commentaires au ScrollPane
lst.setContent(commentBox);}}

// Ajouter le ScrollPane à votre scène de profil de livre où vous le souhaitez
       


    }

    //method to back to previous page ( List of books for student)
    @FXML 
    void BacktoPreviousScene(){
       
       try {
        App.setRoot(BackIcon.getScene(),"ListOfBooksStudent");

       } catch (Exception e) {
        // TODO: handle exception
       } 
    }


    @FXML
    public void reserver(){
        Stage stage =new Stage();
        Scene scene4=null ;
        try {
            scene4 = new Scene(App.loadFXML("reserver"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
       
          stage.setScene(scene4);
          stage.setResizable(false);
         stage.initStyle(StageStyle.UNDECORATED);
         stage.initModality(Modality.APPLICATION_MODAL);
          stage.show();
        
    }}


