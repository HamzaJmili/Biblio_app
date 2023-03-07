package com.example.controllers;

import java.sql.SQLException;
import java.util.Vector;

import com.example.App;
import com.example.Auteur;
import com.example.Livre;
import com.example.Modele_auteur;
import com.example.Modele_livre;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
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

public class ListOfBooksStudentController {
    public static int id ;
    public static int numcarte=4 ;
    int nb_of_livre =0 ;

    @FXML
    Pane carte_etudiant;
   
    @FXML 
    VBox boxOfStudent ;
    @FXML
    void initialize () throws SQLException{
       
        boxOfStudent.setPrefHeight(0);
       
        
        add_etudiant();
       
    }
     void add_etudiant() throws SQLException{
     
    
    Vector<Livre> liste_of_livres = Modele_livre.getLivres();
   
    
    
    while(nb_of_livre!=liste_of_livres.size()){ 
        
        boxOfStudent.setPrefHeight(boxOfStudent.getPrefHeight()+170);
        HBox hBox = new HBox();
       
        
        hBox .setPrefHeight(300); //440
       
        for (int j = 0; j <  5 && nb_of_livre!=liste_of_livres.size() ; j++) {
            
            
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
               
                

                imagelayout.getChildren().add(imageView);
            
            } catch (Exception e) {
               System.out.println("ilias");
            }
           

           Label book_name = new Label(liste_of_livres.get(nb_of_livre).getTitre());

    //                 //location of label in pane
                book_name.setLayoutX(8);
                book_name.setLayoutY(210);
        
    //                 //add style for label
                book_name.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                book_name.getStyleClass().add("textofcarte");
                book_name.setPrefWidth(120);

                
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
        
                        //add button voir
               Button button_voir = new Button("Voir");
                  //the position if button in pane
                  button_voir.setLayoutX(27);
                  button_voir.setLayoutY(250);
                
  
                  // set the hight of button
                  button_voir.setPrefSize(80, 30);
                //add image trash to button
                Image eyeicon1  = new Image(getClass().getResource("/com/example/icons/green_eye.png").toExternalForm());
                ImageView eyeiconview1 = new ImageView(eyeicon1);
                eyeiconview1.setFitHeight(17);
                eyeiconview1.setFitWidth(17);
                button_voir.setGraphic(eyeiconview1);

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

                   // add action to trash button 

        
                    
                  
                   
                   // add compnents to livre carte
                   carteoflivre.getChildren().add(imagelayout);
                   carteoflivre.getChildren().add(book_name);
                   carteoflivre.getChildren().add(writer);
                //    carteoflivre.getChildren().add(button_voir);
                carteoflivre.setOnMouseEntered(e -> {
                    carteoflivre.setCursor(Cursor.HAND);
                    
                });
                    carteoflivre.setOnMouseExited(e ->{
                        carteoflivre.setCursor(Cursor.DEFAULT);
                });
                carteoflivre.setOnMouseClicked(e -> {
                    System.out.println("clicked");
                });
               
                  id=liste_of_livres.get(nb_of_livre).getId_livre();


          
                
            hBox.getChildren().add(carteoflivre);
            
            HBox.setMargin(carteoflivre, margins);
            nb_of_livre++;
        }

        boxOfStudent.getChildren().add(hBox);
        
    }
    
    
    
             
     }
}


