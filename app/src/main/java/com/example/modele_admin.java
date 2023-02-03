package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class Modele_admin {
  public static User checkadmin(String email,String mot_de_pass) {
    
    try {
      Statement s=conn.getStatement();      
      ResultSet rs= conn.getStatement().executeQuery("select * from admin where email_admin='"+email+"' and mdp_admin='"+mot_de_pass+"' ");
      
        while (rs.next()) {
          User adm = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
          return adm;
        }
        return null;
            
      } catch (SQLException e) {
       
        return null;
        
      }
 
    
}
}