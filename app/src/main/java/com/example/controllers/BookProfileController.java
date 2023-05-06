package com.example.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Vector;

import com.example.App;
import com.example.Commentaire;
import com.example.Livre;
import com.example.Model_favoris;
import com.example.Modele_auteur;
import com.example.Modele_cmnt;
import com.example.Modele_livre; 
import com.example.Session;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
   @FXML ImageView image ;
   @FXML TextField comnt;
   @FXML ImageView heartimageview1 ;
   @FXML ImageView heartimageredview1;
   public int id_livre;
   @FXML public void addcmnt() throws SQLException, IOException{
Modele_cmnt.addcmnt(1, id_livre, Session.id_utiliasteur, comnt.getText());
App.setRoot(reserver.getScene(), "BookProfile");
   }
   
  
    @FXML
    void initialize ()  throws SQLException{
        Vector <Integer> id_livre_favoris = Model_favoris.allfavoris(Session.id_utiliasteur);
        if(id_livre_favoris.indexOf(ListOfBooksStudentController.id)==-1){
            heartimageredview1.setVisible(false);

        }else{
            heartimageview1.setVisible(false);
        }
        heartimageview1.setOnMouseClicked(e ->{
            heartimageview1.setVisible(false);
            Model_favoris.setFavoris(ListOfBooksStudentController.id ,Session.id_utiliasteur);
            heartimageredview1.setVisible(true);
        });
        heartimageredview1.setOnMouseClicked(e ->{
            heartimageview1.setVisible(true);
            Model_favoris.deleteFavoris(ListOfBooksStudentController.id, Session.id_utiliasteur);
            heartimageredview1.setVisible(false);
            
        });
        image.toBack();
       lst.setStyle("-fx-background-color:#FFFFFF");
       Livre L=Modele_livre.getBook(ListOfBooksStudentController.id);       
        title.setText(L.getTitre());
        id_livre=L.getId_livre();
        description.setText(L.getDescription());
        nom_auteur.setText(Modele_auteur.getWriterName(L.getId_auteur()));
        nom_auteur.toFront();
        nb_pages.setText(L.getNombre_pages()+" "+"pages");
        Image image = new Image(getClass().getResource("/com/example/books_cover/"+L.getCouverture()).toExternalForm());
        couverture.setImage(image);
        couverture.setStyle("-fx-effect: dropshadow(three-pass-box,rgba(0, 0, 0, 0.84), 7, 0, 0, 0);");
        couverture.toFront();
       if(L.getExemplaire()==0){
        reserver.setDisable(true);
        
       }
       
       Vector<Commentaire> listeofcmnts =Modele_cmnt.getcmnts(L.getId_livre());
       //hhdhdhdhdhdh
       if (listeofcmnts.size()<=0){
        lst.setVisible(false);
       }
       if(listeofcmnts!=null){
       if(listeofcmnts.size()>0){
        
       VBox commentBox = new VBox();
commentBox.setSpacing(10);
Label espc = new Label("Commentaires :");
commentBox.getChildren().add(espc);

// Itérer sur la liste des commentaires pour créer un HBox pour chaque commentaire
for (Commentaire commentaire : listeofcmnts) {
   Label commentairelabel=new Label(Modele_cmnt.selectaut(commentaire.getId_commentaire()));

   // VBox v=new VBox();
   Pane p=new Pane();
    p.getChildren().add(commentairelabel);

    // Créer un Label pour afficher le texte du commentaire
    
   
    System.out.println(commentaire.getContenu());
    // crere un pane pour un commentaire
    AnchorPane carteofcomment = new AnchorPane();
    
    carteofcomment.setPrefHeight(70);
    carteofcomment.setPrefWidth(360);
    Insets margins = new Insets(0.01, 0, 0, 7);
    carteofcomment.setStyle("-fx-background-color:#FFFFFF;-fx-background-radius: 10px;-fx-effect: dropshadow(three-pass-box, rgba(117, 117, 117, 0.8), 5, 0, 0, 0);");
    commentBox.setMargin(carteofcomment, margins);
   
    
    

    LocalDate currentDate = LocalDate.now();
    long daysBetween = ChronoUnit.DAYS.between(commentaire.getCommentDate(), currentDate);
    
    if(daysBetween==0){
         datecomment = new Label("aujourd'hui     ");
    }else{
        texteLabel1 = new Label(daysBetween+"j     ");}
        p.getChildren().add(texteLabel1);
        texteLabel1.setLayoutX(300);
        texteLabel1.setLayoutY(70);
System.out.println(Modele_cmnt.selectaut(commentaire.getId_commentaire()));

    // Créer un HBox pour contenir les deux Labels

carteofcomment.getChildren().addAll(p);


    // Ajouter le HBox du commentaire à la VBox de tous les commentaires
    
    commentBox.getChildren().add(carteofcomment);
    commentBox.setStyle("-fx-background-color:#FFFFFF;");
    commentBox.setPrefWidth(365);
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
        
    }
    



}


