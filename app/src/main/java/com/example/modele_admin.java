package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class Modele_admin {
    public static User checkadmin(String email, String mdp) {
   ResultSet rs;
  try {
    rs = conn.getStatement().executeQuery("select * from admin where EMAIL_ADMIN='"+email+"' and mdp_admin='"+mdp+"' ");
    User adm = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
    return adm;
         
  } catch (SQLException e) {
   return null;
  }


  
    }
    
}
