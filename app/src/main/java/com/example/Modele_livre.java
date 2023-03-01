package com.example;import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Modele_livre {
  public static int addLivre (int id_livre , String titre , String description , String couverture , int id_auteur , int nombre_de_page) throws SQLException{
    
    GetStetment.statement.executeQuery("insert into livre values ("+id_livre+",'"+titre+"','"+description+"','"+couverture+"',"+id_auteur+","+nombre_de_page+")");
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
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5),r.getInt(6));
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
     L = new Livre(s.getInt(1), s.getString(2), s.getString(3), s.getString(4), s.getInt(5),s.getInt(6));
    return L;
    }

}
