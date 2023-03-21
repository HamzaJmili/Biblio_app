package com.example.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import com.example.App;
import com.example.Livre;
import com.example.Model_favoris;
import com.example.Modele_auteur;
import com.example.Modele_livre;
import com.example.Session;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class ListOfBooksStudentController {
    public static int id ;
    public static int numcarte=4 ;
    int nb_of_livre =0 ;
    // @FXML
    // ImageView BackIcon ;
    @FXML
    Pane carte_etudiant;
    @FXML 
    VBox boxOfStudent ;
    // @FXML ImageView back ;
   
 
    
    @FXML
    void initialize () throws SQLException{
       
   
        
        add_etudiant();
       
    }

   
    
     void add_etudiant() throws SQLException{
     
    
    Vector<Livre> liste_of_livres = Modele_livre.getLivres();
    Vector <Integer> id_livre_favoris = Model_favoris.allfavoris(Session.id_utiliasteur);
   
    
    
    while(nb_of_livre!=liste_of_livres.size()){ 
        
        boxOfStudent.setPrefHeight(boxOfStudent.getPrefHeight()+170);
        HBox hBox = new HBox();
       
        
        hBox .setPrefHeight(300); //440
       
        for (int j = 0; j <  5 && nb_of_livre!=liste_of_livres.size() ; j++) {
            ImageView heartimageview;
            ImageView heartimageredview;
            Label book_name = new Label(liste_of_livres.get(nb_of_livre).getTitre());

            //                 //location of label in pane
                        book_name.setLayoutX(8);
                        book_name.setLayoutY(210);
                
            //                 //add style for label
                        book_name.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        book_name.getStyleClass().add("textofcarte");
                        book_name.setPrefWidth(120);
        
            AnchorPane carteoflivre = new AnchorPane();
            carteoflivre.setPrefWidth(165); //170 143
            Insets margins = new Insets(5,14,14,35);
            Pane imagelayout = new Pane();
            imagelayout.setPrefSize(135, 195);
            imagelayout.setStyle("-fx-background-color:#222222;");
            imagelayout.setLayoutX(25);
            imagelayout.setLayoutY(10);
            imagelayout.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
            imagelayout.getStyleClass().add("imagelayout_etudiant");
            


            carteoflivre.setId(""+liste_of_livres.get(nb_of_livre).getId_livre());
            
            try {
                Image image = new Image(getClass().getResource("/com/example/books_cover/"+liste_of_livres.elementAt(nb_of_livre).getCouverture()).toExternalForm());
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(195);
                imageView.setFitWidth(135);
                imageView.setLayoutX(0);
                imageView.setLayoutY(0);
                imagelayout.setOnMouseEntered(e -> {
                    imageView.setFitHeight(201);
                    imageView.setFitWidth(139.5);
                    imagelayout.setLayoutX(23);
                    imagelayout.setLayoutY(8);
                    imagelayout.setCursor(Cursor.HAND);
                    
                });
                imagelayout.setOnMouseExited(e ->{
                imageView.setFitHeight(195);
                imageView.setFitWidth(135);
                imagelayout.setLayoutX(25);
                imagelayout.setLayoutY(9);
                imagelayout.setCursor(Cursor.DEFAULT);
                });
                imagelayout.setOnMouseClicked(e -> {
                    id=Integer.parseInt(carteoflivre.getId());
                    try {
                        App.setRoot(carteoflivre.getScene(),"BookProfile");
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("clicked");
                });
                
               
                

                imagelayout.getChildren().add(imageView);
            
            } catch (Exception e) {
               System.out.println("ilias");
            }
           

        
                
                        // add label for name of writer
                        Label writer = new Label(Modele_auteur.getWriterName(liste_of_livres.get(nb_of_livre).getId_auteur()));
                        //location of label in pane
                writer.setLayoutX(10);
                writer.setLayoutY(229);
                

                                        //add style for label
                writer.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                writer.getStyleClass().add("writer_name");
                
                
                
                        // add label for Page
                //         Label page = new Label("Pages : "+liste_of_livres.get(nb_of_livre).getNombre_pages());
                //         //location of label in pane
                // page.setLayoutX(8);
                // page.setLayoutY(255);



                //                         //add style for Page
                // page.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                // page.getStyleClass().add("page_label");

           
  
                  // set the hight of button
        
              
                        // add style for button
                        // button_voir.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        // button_voir.getStyleClass().add("voir");
                        // button_voir.toBack();
                        // button_voir.setOnMouseClicked((MouseEvent event)->{
                        //   try { App.setRoot(button_voir.getScene(), "BookProfile");
                        // }  
                        // catch( Exception e) {
                        //  System.out.println(e.getMessage());
                        //  e.printStackTrace();
                        // }
                        // } );
                
            
            
                   //set style to pane
                   carteoflivre.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                   carteoflivre.getStyleClass().add("carte_livre");

                //    add heart button
                   Image heartimage  = new Image(getClass().getResource("/com/example/icons/love.png").toExternalForm());
                     heartimageview = new ImageView(heartimage);
                    heartimageview.setFitHeight(18);
                    heartimageview.setFitWidth(18);
                    heartimageview.setLayoutY(216);
                    heartimageview.setLayoutX(146);
                    

                    Image heartimagered  = new Image(getClass().getResource("/com/example/icons/lover.png").toExternalForm());
                     heartimageredview = new ImageView(heartimagered );
                    heartimageredview.setFitHeight(18);
                    heartimageredview.setFitWidth(18);
                    heartimageredview.setLayoutY(216);
                    heartimageredview.setLayoutX(146);
                    Integer id_livre = new Integer(liste_of_livres.elementAt(nb_of_livre).getId_livre());
                    if(id_livre_favoris.indexOf(id_livre)==-1){
                        heartimageredview.setVisible(false);

                    }else{
                        heartimageview.setVisible(false);
                    }
                   

                    heartimageview.setOnMouseClicked(e ->{
                        heartimageview.setVisible(false);
                        
                        Model_favoris.setFavoris(Integer.parseInt(carteoflivre.getId()) ,Session.id_utiliasteur);
                        heartimageredview.setVisible(true);
                    });
                    heartimageredview.setOnMouseClicked(e ->{
                        heartimageview.setVisible(true);
                        Model_favoris.deleteFavoris(Integer.parseInt(carteoflivre.getId()), Session.id_utiliasteur);
                        heartimageredview.setVisible(false);
                        
                    });

                    

        
                    
                  
                   
                   // add compnents to livre carte
                   carteoflivre.getChildren().add(imagelayout);
                   carteoflivre.getChildren().add(book_name);
                   carteoflivre.getChildren().add(writer);
                   carteoflivre.getChildren().add(heartimageredview);
                   carteoflivre.getChildren().add(heartimageview);

                    hBox.getChildren().add(carteoflivre);
                    
                    HBox.setMargin(carteoflivre, margins);
                    nb_of_livre++;
                }

                boxOfStudent.getChildren().add(hBox);
                
            }

    
    
    
             
     }
}


