package com.example;import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Modele_livre {
  public static int addLivre (int id_livre , String titre , String description , String couverture , int id_auteur , int nombre_de_page, int exemplaire) throws SQLException{
    
    GetStetment.statement.executeQuery("insert into livre values ("+id_livre+",'"+titre+"','"+description+"','"+couverture+"',"+id_auteur+","+nombre_de_page+","+exemplaire+")");
    ResultSet s = GetStetment.statement.executeQuery("select ID_LIVRE from livre where couverture ='"+couverture+"'");
    s.next();
    System.out.println(s.getInt(1));
    return s.getInt(1);
    
  }
 
    public static int countlivre() throws SQLException {
      
        try {
          
          ResultSet r=GetStetment.statement.executeQuery("select count(*) from livre");

            while (r.next()) {  
                return r.getInt("count(*)");
            }
            return 0;   
          } catch (Exception e) {
            
            return 0;
            
          }}
    public static Vector<Livre> getLivres() throws SQLException{
      
            
            ResultSet r = GetStetment.statement.executeQuery("select * from livre");
            Vector<Livre> listeoflivres = new Vector<>();
            while (r.next()) {
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5),r.getInt(6),r.getInt(7));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
          public static Vector<Livre> chercheLivres(String text ) throws SQLException{
      
            
            ResultSet r = GetStetment.statement.executeQuery("SELECT  ID_LIVRE,titre,DESCRIPTION,couverture,nombre_pages,exemplaire, UTL_MATCH.EDIT_DISTANCE(titre, '"+text+"') AS similarity_score FROM livre WHERE UTL_MATCH.EDIT_DISTANCE(titre, '"+text+"') <= 4 ORDER BY similarity_score");
            Vector<Livre> listeoflivres = new Vector<>();
            while (r.next()) {
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5),r.getInt(6),r.getInt(7));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
          public static Vector<Livre> getLivresEmpruntee (String cne) throws SQLException{
            ResultSet r  = GetStetment.statement.executeQuery("select * from livre where id_livre in (select id_livre from reserve where CNE ='"+cne+"')");
            Vector<Livre> listeoflivres = new Vector<>();
            while (r.next()) {
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5),r.getInt(6),r.getInt(7));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
          
          
    public static boolean deletelivre(String idlivre) throws SQLException{
      GetStetment.statement.executeUpdate("delete from livre  where id_livre = '"+idlivre+"'");
      return true;
    }
    public static int selectMaxId() throws SQLException{
      ResultSet s = GetStetment.statement.executeQuery("select MAX(id_livre) from livre");
      s.next();
    System.out.println(s.getInt(1));
    return s.getInt(1);
    }

   public static Livre getBook( int Id_livre ) throws SQLException{
    Livre L= null;
    ResultSet s=GetStetment.statement.executeQuery("select * from livre where id_livre='"+Id_livre+"'");
    while(s.next())
     L = new Livre(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5),s.getInt(6),s.getInt(7));
    return L;
    }
    public static int getlikes(int id_livre) throws SQLException{
      ResultSet s = GetStetment.statement.executeQuery("select count(*) from favoris where id_livre = "+id_livre);
      s.next();
    System.out.println(s.getInt(1));
    return s.getInt(1);

    }

} 