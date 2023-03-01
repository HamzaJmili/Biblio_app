package com.example.controllers;

import java.io.IOException;
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

import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class LivreController {
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
       
        
        hBox .setPrefHeight(170);
       
        for (int j = 0; j < 4 && nb_of_livre!=liste_of_livres.size() ; j++) {
            
            
            AnchorPane carteoflivre = new AnchorPane();
            carteoflivre.setPrefWidth(260);
            Insets margins = new Insets(10, 5, 25, 5);
            Pane imagelayout = new Pane();
            imagelayout.setPrefSize(76.888, 111.1);
            imagelayout.setStyle("-fx-background-color:#222222;");
            imagelayout.setLayoutX(8);
            imagelayout.setLayoutY(10);


            
            
            try {
                Image image = new Image(getClass().getResource("/com/example/books_cover/"+liste_of_livres.elementAt(nb_of_livre).getCouverture()).toExternalForm());
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(109.1);
                imageView.setFitWidth(74.888);
                imageView.setLayoutX(1.5);
                imageView.setLayoutY(1);
                
                
                imagelayout.getChildren().add(imageView);
            
            } catch (Exception e) {
               System.out.println("ilias");
            }
           

           Label book_name = new Label(liste_of_livres.get(nb_of_livre).getTitre());

    //                 //location of label in pane
                book_name.setLayoutX(102);
                book_name.setLayoutY(17);
        
    //                 //add style for label
                book_name.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                book_name.getStyleClass().add("textofcarte");

                
                        // add label for name of writer
                        Label writer = new Label(Modele_auteur.getWriterName(liste_of_livres.get(nb_of_livre).getId_auteur()));
                        //location of label in pane
                writer.setLayoutX(107);
                writer.setLayoutY(42);

                                        //add style for label
                writer.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                writer.getStyleClass().add("writer_name");
                
                
                        // add label for Page
                        Label page = new Label("Pages : "+liste_of_livres.get(nb_of_livre).getNombre_pages());
                        //location of label in pane
                page.setLayoutX(107);
                page.setLayoutY(63);



                                        //add style for Page
                page.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                page.getStyleClass().add("page_label");

                  //add button
                  Button button_trash = new Button("Supprimer");
                  //the position if button in pane
                  button_trash.setLayoutX(87);
                  button_trash.setLayoutY(100);
  
                  // set the hight of button
                  button_trash.setPrefSize(92, 33);
                //add image trash to button
                Image trashimage  = new Image(getClass().getResource("/com/example/icons/bin.png").toExternalForm());
                ImageView trashimageview = new ImageView(trashimage);
                trashimageview.setFitHeight(13);
                trashimageview.setFitWidth(13);
                button_trash.setGraphic(trashimageview);
                        //add style for button
                        button_trash.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        button_trash.getStyleClass().add("trash");
                        button_trash.toBack();

                        // add id button trash is the id of the livre
                        button_trash.setId(liste_of_livres.get(nb_of_livre).getId_livre()+"");

                        //add button voir
                  Button button_voir = new Button("Voir");
                  //the position if button in pane
                  button_voir.setLayoutX(179);
                  button_voir.setLayoutY(100);
  
                  // set the hight of button
                  button_voir.setPrefSize(80, 30);
                //add image trash to button
                Image trashimage1  = new Image(getClass().getResource("/com/example/icons/green_eye.png").toExternalForm());
                ImageView trashimageview1 = new ImageView(trashimage1);
                trashimageview1.setFitHeight(17);
                trashimageview1.setFitWidth(17);
                button_voir.setGraphic(trashimageview1);

                        //add style for button
                        button_voir.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                        button_voir.getStyleClass().add("voir");
                        button_voir.toBack();
                
            
            
                   //set style to pane
                   carteoflivre.getStylesheets().add(App.class.getResource("views/style.css").toExternalForm());
                   carteoflivre.getStyleClass().add("carte_livre");

                   // add action to trash button 

                    button_trash.setOnMouseClicked((MouseEvent event)->{
                        try {
                            
                            Alert a = new Alert(AlertType.CONFIRMATION);
                            // set the propriety for alert
                            a.setTitle("");
                            a.setContentText("ce livre va etre supprimer definitivement");
                            a.setHeaderText("vous etes sure ?");
                            
                            
                            a.showAndWait().ifPresent(response -> {
                                if (
                                    response == ButtonType.OK) {
                                    // Action to perform when user clicks OK
                                    System.out.println("User clicked OK");
                                    try {
                                        Modele_livre.deletelivre(button_trash.getId());
                                        App.setRoot(button_trash.getScene(), "Livre");
                                    } catch (Exception e) {
                                        
                                    }
                                }
                            });
                            
                            
                        } catch (Exception e) {
                            System.out.println("ilias");
                           
                        }
                    });
                    
                  
                   
                   // add compnents to livre carte
                   carteoflivre.getChildren().add(imagelayout);
                   carteoflivre.getChildren().add(book_name);
                   carteoflivre.getChildren().add(writer);
                   carteoflivre.getChildren().add(page);
                   carteoflivre.getChildren().add(button_trash);
                   carteoflivre.getChildren().add(button_voir);


          
                
            hBox.getChildren().add(carteoflivre);
            
            HBox.setMargin(carteoflivre, margins);
            nb_of_livre++;
        }

        boxOfStudent.getChildren().add(hBox);
        
    }
          
     }
     @FXML
     void addbook () throws IOException{

        Stage stage = new Stage();
        stage.setScene(new Scene(App.loadFXML("addLivre")));
        stage.show();
     }
}

