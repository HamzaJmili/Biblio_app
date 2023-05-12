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
import javafx.scene.Cursor;
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
import javafx.scene.paint.Color;
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
    @FXML HBox youlike;
   
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
       
        if(Session.id_utiliasteur.compareTo(commentaire.getCne())==0){
        // create botton delete 
        Label delete = new Label("Supprimer");
        delete.setLayoutY(10);
        delete.setLayoutX(520);
        delete.setCursor(Cursor.HAND);
        delete.setStyle("-fx-text-fill:#780B0B;");
        delete.setOnMouseClicked(e->{
            try {
                Modele_cmnt.deletecmnt(commentaire.getId_commentaire());
                App.setRoot(reserver.getScene(), "BookProfile");
            } catch (SQLException e1) {
               System.out.println(e1.getSQLState());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
        });
        carteofcomment.getChildren().add(delete);
    }





    // Créer un HBox pour contenir les deux Labels




    // Ajouter le HBox du commentaire à la VBox de tous les commentaires
    
    commentBox.getChildren().add(carteofcomment);
    commentBox.setPrefHeight(commentBox.getPrefHeight()+77);
    
    
    
}
commentBox.setPrefWidth(600);

// Ajouter la VBox de tous les commentaires au ScrollPane
}}

 // selecter les tags d'un commentaire 
       
       addSugssetionBook(tagsofbook(L.getId_livre()),youlike,L.getId_livre());
       


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
    public static String tagsofbook (int id) throws SQLException{
        String tags = Modele_tag.stringoftags(id);
        return tags;
    }
    public static void addSugssetionBook(String tagofbook ,HBox youlike,int id_livre  ) throws SQLException{
        Vector<Livre> livres = Modele_livre.getLivres();
      
        
        int notes = tagofbook.split(",").length ,nb_livre=0 ;
        Vector <Integer> livre_afficher = new Vector<>();
        
        while(notes>0){
            System.out.println(nb_livre+" size: "+livre_afficher.size());

            
         
        for(int i = 0 ; i<livres.size()  && livre_afficher.size() < 4;i++){
            int noteofthisbook = 0; 
           
            if(id_livre!=livres.get(i).getId_livre() ){
                
           Vector<String> tags = Modele_tag.vectoroftags(livres.get(i).getId_livre());
           
           for(int j =0;j< tags.size();j++){
          
            if(tagofbook.indexOf(tags.get(j))!=-1){
                
                noteofthisbook++;
              
              
            }
            if(noteofthisbook==notes  && livre_afficher.indexOf(livres.get(i).getId_livre())==-1 ){
               
                ++nb_livre;
                livre_afficher.add(livres.get(i).getId_livre());
                System.out.println(livres.get(i).getTitre());
               
                Label book_name = new Label(livres.get(i).getTitre());
    
                //                 //location of label in pane
                            book_name.setLayoutX(20);
                            book_name.setLayoutY(175);
                    
                //                 //add style for label
                            book_name.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                            book_name.getStyleClass().add("textofcarte");
                            book_name.setPrefWidth(120);
            
                AnchorPane carteoflivre = new AnchorPane();
                carteoflivre.setPrefWidth(100); //170 143
                Insets margins = new Insets(5,5,5,5);
                Pane imagelayout = new Pane();
                imagelayout.setPrefSize(110, 160);
                imagelayout.setStyle("-fx-background-color:#222222;");
                imagelayout.setLayoutX(25);
                imagelayout.setLayoutY(10);
                imagelayout.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                imagelayout.getStyleClass().add("imagelayout_etudiant");
                
    
    
                carteoflivre.setId(""+livres.get(i).getId_livre());
                
                try {
                    Image image = new Image(App.class.getResource("/com/example/books_cover/"+livres.get(i).getCouverture()).toExternalForm());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(160);
                    imageView.setFitWidth(110);
                    imageView.setLayoutX(0);
                    imageView.setLayoutY(0);
                    imagelayout.setOnMouseEntered(e -> {
                        imageView.setFitHeight(165);
                        imageView.setFitWidth(115);
                        imagelayout.setLayoutX(23);
                        imagelayout.setLayoutY(8);
                        imagelayout.setCursor(Cursor.HAND);
                        
                    });
                    imagelayout.setOnMouseExited(e ->{
                    imageView.setFitHeight(160);
                    imageView.setFitWidth(110);
                    imagelayout.setLayoutX(25);
                    imagelayout.setLayoutY(9);
                    imagelayout.setCursor(Cursor.DEFAULT);
                    });
                   
                    
                   
                    
    
                    imagelayout.getChildren().add(imageView);
                
                } catch (Exception e) {
                  
                }
               
    
            
                    
                            
                    
    
                                        
                    
                
                       //set style to pane
                       carteoflivre.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                       carteoflivre.getStyleClass().add("carte_livre");
    
                    
                    
                       // add compnents to livre carte
                       carteoflivre.getChildren().add(imagelayout);
                       carteoflivre.getChildren().add(book_name);
                       youlike.getChildren().add(carteoflivre);
                       
    

            }
           }

            
            }
            
    
        
    }
    --notes;
System.out.println("apres while"+nb_livre+" size: "+livre_afficher.size());} 
}
    }
    






