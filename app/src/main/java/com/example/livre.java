package com.example;

public class livre {
 private int id_livre;
 private String titre ;
 private String description ;
 private String couverture ;
 

public livre(int id_livre, String titre, String description, String couverture) {
    this.id_livre = id_livre;
    this.titre = titre;
    this.description = description;
    this.couverture = couverture;
}

public int getId_livre() {
    return id_livre;
}

public void setId_livre(int id_livre) {
    this.id_livre = id_livre;
}

public String getTitre() {
    return titre;
}

public void setTitre(String titre) {
    this.titre = titre;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getCouverture() {
    return couverture;
}

public void setCouverture(String couverture) {
    this.couverture = couverture;
}
 

    
}
