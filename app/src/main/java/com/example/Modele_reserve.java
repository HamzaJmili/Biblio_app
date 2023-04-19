package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;


import com.example.controllers.ListOfBooksStudentController;

public class Modele_reserve {

    public  static int nb_livres_emp = 0  ;

        public static int addLivre (LocalDate fin) throws SQLException{
            LocalDate currentDate = LocalDate.now();
          GetStetment.statement.executeQuery("insert into reserve values (1,'"+Session.id_utiliasteur+"','"+ListOfBooksStudentController.id+"',TO_DATE('"+currentDate+"', 'YYYY-MM-DD'),TO_DATE('"+fin+"', 'YYYY-MM-DD'),'yes')");
          
          return 1;
          
        }
        public static List<Map<String, Object>> getReservedBooks(String cne ) throws SQLException {
          List<Map<String, Object>> reservedBooks = new ArrayList<>();
      
          try (
               ResultSet r = GetStetment.statement.executeQuery("SELECT id_livre, date_Debut, date_fin FROM reserve WHERE cne = '"+cne+"'")) {
      
              while (r.next()) {
                  int  id = r.getInt("id_livre");
                 
                  // String id=Modele_livre.getBook(r.getInt("id_livre")).getTitre();               
                 String startDate = r.getString("date_Debut");
                  String endDate = r.getString("date_fin");
                  
                  Map<String, Object> reservedBook = new HashMap<>();
                  reservedBook.put("titre",id);
                  reservedBook.put("startDate", startDate);
                  reservedBook.put("endDate", endDate);
                  reservedBooks.add(reservedBook);
                 

              }
              Modele_reserve.nb_livres_emp = reservedBooks.size();
          }

          return reservedBooks;
      }
      
        
}
