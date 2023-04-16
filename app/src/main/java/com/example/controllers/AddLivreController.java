package com.example.controllers;
import javafx.stage.Stage;
import java.io.File;
import java.sql.SQLException;
import java.util.Vector;

import com.example.Auteur;
import com.example.Model_livreAvoirTag;
import com.example.Modele_auteur;
import com.example.Modele_livre;
import com.example.Modele_tag;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class AddLivreController {
    public static int id_couverture ;
    @FXML
    Button annuler;
    @FXML
    TextField titre;
    @FXML
    Label incorrect_champs ;
    @FXML
    TextField pages ;
    @FXML
    TextArea description ;
    @FXML
    TextField exemplaire ;
    @FXML
    TextArea tags ;
    @FXML
    Button upload ;
    File selectedfile =null;
    @FXML
    ComboBox<String> comboBox ;
    @FXML
    Label selected_cover;
    @FXML 
    void initialize() throws SQLException{
        id_couverture=Modele_livre.selectMaxId();
        
        Vector<Auteur> listofauteur = Modele_auteur.getAuteur() ;
        for (Auteur object : listofauteur) {
          
            comboBox.getItems().add(object.getId_auteur()+"-"+" "+ object.getNom_auteur()+" "+object.getPrenom_auteur());
            incorrect_champs.setVisible(false);
        }
        
    }
    @FXML
    void upload (){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("selectez le couverture de livre");
         selectedfile = fileChooser.showOpenDialog(upload.getScene().getWindow());
         // set the name of the image in the inferface 
         selected_cover.setText(selectedfile.getName()+" ✔");
        
         
         }
       
       
    
    @FXML
    void add() throws NumberFormatException, SQLException{
        
        if (!titre.getText().isEmpty() && !description.getText().isEmpty() && !pages.getText().isEmpty() && selectedfile!=null && comboBox.getSelectionModel().selectedItemProperty()!=null){
         
        
        // get the extention of the image
        int dotindex = selectedfile.getName().lastIndexOf(".");
         String extention = selectedfile.getName().substring(dotindex+1);
         
         // get the path where the app is install
         String s = System.getProperty("user.dir");
         String path = s.toString()+"/app/src/main/resources/com/example/books_cover/"+id_couverture+"."+extention;
         File f = new File(path);
         //rename the image and replace it
        selectedfile.renameTo(f); 
          // add the books in the books database  
          Vector<Integer> liste_des_id= Modele_tag.addtags(tags.getText().toUpperCase());
          
        int id_livre =Modele_livre.addLivre(1, titre.getText(), description.getText(), f.getName(), Integer.parseInt(comboBox.getSelectionModel().selectedItemProperty().getValue().split("-")[0]),Integer.parseInt(pages.getText()),Integer.parseInt(exemplaire.getText()) );
        for (Integer id_tag : liste_des_id) {
               if(Model_livreAvoirTag.insertIntoAvoir(id_livre, id_tag));
        }
        (AddLivreController.id_couverture)++;
    }
        else{
            incorrect_champs.setVisible(true);
            
            
        }
    }
    @FXML
    public void annuler(){
        ((Stage) annuler.getScene().getWindow()).close();
     }
}