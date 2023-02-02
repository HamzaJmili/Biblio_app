package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class vv {
   
    public static void main(String[] args) throws SQLException {
        Statement s=conn.getStatement();
        ResultSet r=s.executeQuery("select * from employees");
        while(r.next()){
            System.out.println(r.getString(3));
        }
        
    }
    
}
