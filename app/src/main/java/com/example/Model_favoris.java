package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model_favoris{
    public static boolean setFavoris (int id_livre, String id_etudiant){
        try {
            ResultSet r = GetStetment.statement.executeQuery("insert into favoris values(5,'"+id_etudiant+"','"+id_livre+"')");
            System.out.println("created");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("non created");
            return false;
         
        }
    }
    public static boolean deleteFavoris(int id_livre, String id_etudiant){
        try {
            ResultSet r = GetStetment.statement.executeQuery("DELETE FROM favoris WHERE id_livre='"+id_livre+"' AND id_etudiant='"+id_etudiant+"'");
            return true;
        } catch (SQLException e) {
                return false;
          
        }
    }
}