package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Modele_etudiant {
    public static User checkEtudiant(String email,String mot_de_pass) {
      
      try {
     
        ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant where EMAIL_ETUDIANT='"+email+"' and MDP_ETUDIANT='"+mot_de_pass+"'");
        
          while (r.next()) {
            User e=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
            return e;
          }
          return null;
              
        } catch (SQLException e) {
         
          return null;
          
        }
           
        }
        public static int countetu() {
      
          try {
           
            ResultSet r=  GetStetment.statement.executeQuery("select count(*) from etudiant");
            
              while (r.next()) {
                
                return r.getInt("count(*)");
              }
              return 0;
                  
            } catch (SQLException e) {
             
              return 0;
              
            }
               
            }
            public static  ObservableList<Etudiant> load() throws SQLException{
              ObservableList<Etudiant> e=FXCollections.observableArrayList();
             
              ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant");
              while (r.next()) {
                Etudiant etu=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
                e.add(etu);
              }
              return e;
            }
            public static  Etudiant getProfileEtudiant( String cneEtudiant)  {
              Etudiant etu=null;
              try {
               
                ResultSet r=  GetStetment.statement.executeQuery("select * from etudiant  where cne='"+cneEtudiant+"'");
               
                while(r.next()){
                  etu=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"),r.getString("filiere"),r.getString("telephone"));
                  
                }
            } 
            catch (Exception e) {
              // TODO: handle exception
            } 
             
              
           return etu;
           
          }
        
    }

