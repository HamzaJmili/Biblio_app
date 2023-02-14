package com.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Modele_auteur {
    public static int countauteur() {
      
        try {
          Statement s=conn.getStatement();
          ResultSet r=s.executeQuery("select count(*) from auteur");
          
            while (r.next()) {
              
              return r.getInt("count(*)");
            }
            return 0;
                
          } catch (SQLException e) {
           
            return 0;
            
          }
             
          }
          public static  ObservableList<Auteur> load() throws SQLException{
            ObservableList<Auteur> e=FXCollections.observableArrayList();
            
            Statement s=conn.getStatement();
            ResultSet r=s.executeQuery("select * from auteur");
            while (r.next()) {
              Auteur aut=new Auteur(r.getInt("ID_AUTEUR"), r.getString("NOM_AUTEUR"), r.getString("PRENOM_AUTEUR"), r.getString("BIO_AUTEUR"));
              System.out.println(aut.getBio_auteur()+"   jjjjhhhhjjjjj");
              e.add(aut);
            }
            return e;
          }
      
          public static String getWriterName(int id ) throws SQLException{
            Statement s=conn.getStatement();
            ResultSet r =s.executeQuery("select NOM_AUTEUR, PRENOM_AUTEUR from auteur where ID_AUTEUR='"+id+"'");
            String st=null;
          while( r.next()) {
            st= r.getString(1)+"  "+r.getString(2);
          }
            return st ;
            
          } 
}
