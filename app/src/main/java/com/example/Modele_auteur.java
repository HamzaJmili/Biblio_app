package com.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Modele_auteur {
    public static int countauteur() {
      
        try {
          
          ResultSet r=GetStetment.statement.executeQuery("select count(*) from auteur");
          
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
          public static void insert_into_auteur(String nom,String prenom,String bioo) throws SQLException{
            Connection con=conn.Connection();
            String sql = "insert into auteur(nom_auteur,prenom_auteur,bio_auteur) values(?,?,?)";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
          stmt.setString(1, nom);
          stmt.setString(2, prenom);
          stmt.setString(3, bioo);
          
                    stmt.executeQuery();   
          
          }}
          public static void DELETE_FROM_auteur(int Id_auteur) throws SQLException{
            Connection con=conn.Connection();
            String sql = "DELETE FROM auteur WHERE ID_AUTEUR = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setInt(1,Id_auteur );
                    stmt.executeQuery();
          }
}
