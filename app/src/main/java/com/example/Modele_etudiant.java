package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele_etudiant {
    public static Etudiant checkuser(String email,String mot_de_pass) throws SQLException{
        Statement s=conn.getStatement();
        ResultSet r=s.executeQuery("select * from etudiant where EMAIL_ETUDIANT='"+email+"'and MDP_ETUDIANT='"+mot_de_pass+"'");
        if(r.wasNull()) {
          return null;
            }
            Etudiant e=new Etudiant(r.getString("CNE"), r.getString("NOM_ETUDIANT"),r.getString("PRENOM_ETUDIANT"),r.getString("EMAIL_ETUDIANT"), r.getString("MDP_ETUDIANT"));
            return e;
        }
        
    }

