package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class Modele_admin {
  public static User checkadmin(String email,String mot_de_pass) {
    
    try {
      
      ResultSet rs=  GetStetment.statement.executeQuery("select * from admin where email_admin='"+email+"'");
      
        while (rs.next()) {
          if(PasswordCrypter.checkPassword(mot_de_pass, rs.getString("MDP_ADMIN"))==true){
          User adm = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
          return adm;}
        }
        return null;
        
      } catch (SQLException e) {
       
        return null;
        
      }
 
    
}

}
