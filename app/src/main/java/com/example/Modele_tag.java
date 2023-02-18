package com.example;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele_tag {
    public static int counttag() {
      
        try {
        
          ResultSet r=  GetStetment.statement.executeQuery("select count(*) from tag");
          
            while (r.next()) {
              
              return r.getInt("count(*)");
            }
            return 0;
                
          } catch (SQLException e) {
           
            return 0;
            
          }
             
          }
}
