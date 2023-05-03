package com.example;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;




public  class Modele_cmnt {
    public static Vector<Commentaire> getcmnts (int  id_livre) throws SQLException{
        ResultSet r  = GetStetment.statement.executeQuery("select * from commentaire where  ID_LIVRE="+id_livre+"");
        Vector<Commentaire> listeofcmnts = new Vector<>();
        while (r.next()) {
            Commentaire com=new Commentaire(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4));
         
          listeofcmnts.add( com);
        }
    
        return listeofcmnts;
    
      }
      public static void addLivre (int id_commentaire , int  id_livre , String cne , String contenu ) throws SQLException{
    
        GetStetment.statement.executeQuery("insert into commentaire values ("+id_commentaire+",'"+id_livre+"','"+cne+"','"+contenu+"");

      
        
      }

  }
