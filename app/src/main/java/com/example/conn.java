package com.example;

import java.sql.*;

public class conn {
    public static Statement getStatement() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "admin");
            Statement s=c.createStatement();
            return s;
            
        } catch (Exception e) {
          System.out.println("error");
        }
        return null;
    }
   
}
