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
import com.example.Modele_tag;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
   
   @FXML ImageView image ;
   @FXML TextField comnt;
   @FXML ImageView heartimageview1 ;
   @FXML ImageView heartimageredview1;
   @FXML VBox commentBox;
   public int id_livre;
   @FXML public void addcmnt() throws SQLException, IOException{
    if(comnt.getText().length()!=0){
        String escapedcommentaire = comnt.getText().replace("'", "''");
        if (escapedcommentaire.length()>=1499){
           escapedcommentaire = escapedcommentaire.substring(0,1448);
        }
        
        
        Modele_cmnt.addcmnt(1, id_livre, Session.id_utiliasteur,escapedcommentaire);
       
        App.setRoot(reserver.getScene(), "BookProfile");
    }

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
      
       if(listeofcmnts!=null){
       if(listeofcmnts.size()>0){
        
       
commentBox.setSpacing(10);


// Itérer sur la liste des commentaires pour créer un HBox pour chaque commentaire
for (Commentaire commentaire : listeofcmnts) {
   Label commentairelabel=new Label(Modele_cmnt.selectaut(commentaire.getId_commentaire()));

   // VBox v=new VBox();
  
  

    // Créer un Label pour afficher le texte du commentaire
    
   
    System.out.println(commentaire.getContenu());
    // crere un pane pour un commentaire
    AnchorPane carteofcomment = new AnchorPane();
    
    carteofcomment.setPrefHeight(70);
    carteofcomment.setPrefWidth(360);
    Insets margins = new Insets(0.01, 0, 0, 7);
    carteofcomment.setStyle("-fx-border-width: 0.5px 0.5px 0.5px 0.5px;-fx-border-color: #D7D7D7; -fx-border-style: solid;-fx-border-radius: 10px;");
    commentBox.setMargin(carteofcomment, margins);
   
    // add name of commentaire auteur
    
    String auteur = Modele_cmnt.selectaut(commentaire.getId_commentaire());
    Label commentaire_auteur = new Label(auteur);
    if(Session.id_utiliasteur.equals(commentaire.getCne())){
       commentaire_auteur.setText("Moi"+"     ");
    }
    
    
    
    commentaire_auteur.setLayoutX(20);
    commentaire_auteur.setLayoutY(10);
    commentaire_auteur.setFont(Font.font("System", FontWeight.BOLD, 12));
    carteofcomment.getChildren().add(commentaire_auteur);

    // add content of commentaire 
  Text commentaire_content = new Text(commentaire.getContenu()+"\n");
    commentaire_content.setLayoutX(23);
    commentaire_content.setLayoutY(45);
    commentaire_content.setWrappingWidth(550.40008544921864);
    
    carteofcomment.getChildren().add(commentaire_content);
    
    Label datecomment;
    Label texteLabel1 = new Label("jdk");
    LocalDate currentDate = LocalDate.now();
    long daysBetween = ChronoUnit.DAYS.between(commentaire.getCommentDate(), currentDate);
    Insets margin_comment = new Insets(0.01, 0, 0, 7);
  
    
    
    if(daysBetween==0){
        texteLabel1 = new Label("  aujourd'hui     ");
    }else{
        texteLabel1 = new Label("   "+daysBetween+" j     ");}
        
        
        texteLabel1.setLayoutY(12);
        texteLabel1.setLayoutX(commentaire_auteur.getText().length()*7+10);
        texteLabel1.setFont(Font.font("System", FontWeight.NORMAL, 10));
        carteofcomment.getChildren().add(texteLabel1);



System.out.println(Modele_cmnt.selectaut(commentaire.getId_commentaire()));

    // Créer un HBox pour contenir les deux Labels




    // Ajouter le HBox du commentaire à la VBox de tous les commentaires
    
    commentBox.getChildren().add(carteofcomment);
    commentBox.setPrefHeight(commentBox.getPrefHeight()+77);
    
    
    
}
commentBox.setPrefWidth(600);

// Ajouter la VBox de tous les commentaires au ScrollPane
}}

 // selecter les tags d'un commentaire 
        tagsofbook(L.getId_livre());
       


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
    public static void tagsofbook (int id) throws SQLException{
        String tags = Modele_tag.stringoftags(id);
    }
    



}


