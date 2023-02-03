package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class Modele_admin {
    public static User checkadmin(String email, String mdp) throws SQLException{
   ResultSet rs= conn.getStatement().executeQuery("select * from admin where email='"+email+"' and mdp_admin='"+mdp+"' ");
 if(rs.wasNull()) 
 return null ;
     User adm = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
   return adm;
        
    }
    
}
