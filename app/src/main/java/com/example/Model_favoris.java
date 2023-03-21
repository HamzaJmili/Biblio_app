package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
            System.out.println("deleted");
            return true;
        } catch (SQLException e) {
                return false;
          
        }
    }
    public static Vector<Integer> allfavoris(String cne){
        try {
            ResultSet r = GetStetment.statement.executeQuery("select id_livre from favoris where id_etudiant = '"+cne+"'");
            Vector<Integer> listeoflivre = new Vector<Integer>();
            while (r.next()){
                System.out.println(r.getInt(1));
                listeoflivre.add(r.getInt(1))    ;
                    }
                    return listeoflivre;
            
        } catch (SQLException e) {
            System.out.println("non sselected");
            return null;
        }
    }
    public static Vector<Livre> getLivres_favoris(String cne_etudiant) throws SQLException{
      System.out.println("ffkfkkfkf");
            
        ResultSet r = GetStetment.statement.executeQuery("select * from livre where id_livre in (select id_livre from favoris where ID_ETUDIANT ='"+cne_etudiant+"')");
        Vector<Livre> listeoflivres = new Vector<>();
        while (r.next()) {
          Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5),r.getInt(6));
          listeoflivres.add(livre);
        }
        return listeoflivres;
      }
}