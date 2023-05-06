package com.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;


import com.example.controllers.ListOfBooksStudentController;

public class Modele_reserve {
  public static int id_current_book ;


        public static int addLivre (LocalDate fin) throws SQLException{
            LocalDate currentDate = LocalDate.now();
          GetStetment.statement.executeQuery("insert into reserve values (1,'"+Session.id_utiliasteur+"','"+ListOfBooksStudentController.id+"',TO_DATE('"+currentDate+"', 'YYYY-MM-DD'),TO_DATE('"+fin+"', 'YYYY-MM-DD'),'yes')");
          
          return 1;
          
        }



        public static List<Map<String, Object>> getReservedBooks(String cne ) throws SQLException {

            
          List<Map<String, Object>> reservedBooks = new ArrayList<>();
          // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          try (
               ResultSet r1 = GetStetment.statement.executeQuery("SELECT id_livre, date_Debut, date_fin FROM reserve WHERE cne = '"+cne+"'")) {
      
              while (r1.next()) {
                  int  id = r1.getInt("id_livre");
                
                  // String id=Modele_livre.getBook(r.getInt("id_livre")).getTitre();               
                 String startDate = r1.getString("date_Debut");
                  String endDate = r1.getString("date_fin");
                  
                  // LocalDateTime dateFin = LocalDateTime.parse(endDate , formatter); // Convert "date_fin" string to LocalDateTime object
                  // LocalDateTime now = LocalDateTime.now();
                  // id_current_book= now.isBefore(dateFin) ? id : 0  ;
                  // System.out.println(id_current_book);
                  Map<String, Object> reservedBook = new HashMap<>();
                  reservedBook.put("titre",id);
                  reservedBook.put("startDate", startDate);
                  reservedBook.put("endDate", endDate);
                  reservedBooks.add(reservedBook);
                  
              }
             
            
          }

          return reservedBooks;
      }
     // methode pour retourner le titre emprunter pour le momment par l'etudiant 
    public static String getTitle(String cne ) throws SQLException {
        int id=0 ;
        System.out.println("gettitle cne entree "+cne);
        String s= "Aucun livre emprunté pour le moment ";
    try ( ResultSet r= GetStetment.statement.executeQuery("SELECT id_livre FROM reserve_now_view WHERE cne = '"+cne+"'")) 
    
       {
    while(r.next()) {
      System.out.println("test que boucle marche ");
      System.out.println("get title id recuperer dans la base"+id);
   id=r.getInt(1) ;
    }
    }
    
return   id==0 ? s : Modele_livre.getBook(id).getTitre() ;
  }
    
  
  public static void ConfirmerLivreRendu(String cne ) throws SQLException {
    ResultSet r = GetStetment.statement.executeQuery("update reserve set reserve_now='no' where cne='"+cne+"' ");
 

}
}