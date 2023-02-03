package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele_etudiant {
    public static User checkEtudiant(String email,String mot_de_pass) {
      System.out.println("222");
      try {
        Statement s=conn.getStatement();
        ResultSet r=s.executeQuery("select * from etudiant where EMAIL_ETUDIANT='"+email+"' and MDP_ETUDIANT='"+mot_de_pass+"'");
        
          while (r.next()) {
            User e=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"));
            return e;
          }
          return null;
              
        } catch (SQLException e) {
          System.out.println("mmmmmmm");
          return null;
          
        }
           
        }
        
    }

