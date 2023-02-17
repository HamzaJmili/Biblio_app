package com.example;import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class Modele_livre {
    public static int countlivre() {
      
        try {
          Statement s=conn.getStatement();
          ResultSet r=s.executeQuery("select count(*) from livre");
          
            while (r.next()) {
              
              return r.getInt("count(*)");
            }
            return 0;
                
          } catch (SQLException e) {
           
            return 0;
            
          }}
    public static Vector<Livre> getLivres() throws SQLException{
            Statement s = conn.getStatement(); 
            ResultSet r = s.executeQuery("select * from livre");
           
            Vector<Livre> listeoflivres = new Vector<>();
            
            while (r.next()) {
             
              Livre livre = new Livre(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5),r.getInt(6));
              listeoflivres.add(livre);
            }
            return listeoflivres;
          }
    public static boolean deletelivre(String idlivre) throws SQLException{
      Statement s = conn.getStatement();
      s.executeUpdate("delete from livre  where id_livre = '"+idlivre+"'");
      return true;
      
    }

}
