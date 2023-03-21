package com.example;

import java.sql.SQLException;
import java.time.LocalDate;
import com.example.controllers.ListOfBooksStudentController;

public class Modele_reserve {
    
        public static int addLivre (LocalDate fin) throws SQLException{
            LocalDate currentDate = LocalDate.now();
          GetStetment.statement.executeQuery("insert into reserve values (1,'"+Session.id_utiliasteur+"','"+ListOfBooksStudentController.id+"',TO_DATE('"+currentDate+"', 'YYYY-MM-DD'),TO_DATE('"+fin+"', 'YYYY-MM-DD'))");
          
          return 1;
          
        }
        
}
