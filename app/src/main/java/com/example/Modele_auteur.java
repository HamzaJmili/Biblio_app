package com.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Modele_auteur {
    public static int countauteur() {
      
        try {
          Statement s=conn.getStatement();
          ResultSet r=s.executeQuery("select count(*) from auteur");
          
            while (r.next()) {
              
              return r.getInt("count(*)");
            }
            return 0;
                
          } catch (SQLException e) {
           
            return 0;
            
          }
             
          }
}
