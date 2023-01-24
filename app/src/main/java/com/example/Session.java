package com.example;

public class Session {
    private int id_utiliasteur ;
    private String nom_utiliasteur ;
    private String prenom_utiliasteur ;
    private String email_utiliasteur ;
    
    public Session(int id_utiliasteur, String nom_utiliasteur, String prenom_utiliasteur, String email_utiliasteur) {
        this.id_utiliasteur = id_utiliasteur;
        this.nom_utiliasteur = nom_utiliasteur;
        this.prenom_utiliasteur = prenom_utiliasteur;
        this.email_utiliasteur = email_utiliasteur;
    }
    public int getId_utiliasteur() {
        return id_utiliasteur;
    }
    public void setId_utiliasteur(int id_utiliasteur) {
        this.id_utiliasteur = id_utiliasteur;
    }
    public String getNom_utiliasteur() {
        return nom_utiliasteur;
    }
    public void setNom_utiliasteur(String nom_utiliasteur) {
        this.nom_utiliasteur = nom_utiliasteur;
    }
    public String getPrenom_utiliasteur() {
        return prenom_utiliasteur;
    }
    public void setPrenom_utiliasteur(String prenom_utiliasteur) {
        this.prenom_utiliasteur = prenom_utiliasteur;
    }
    public String getEmail_utiliasteur() {
        return email_utiliasteur;
    }
    public void setEmail_utiliasteur(String email_utiliasteur) {
        this.email_utiliasteur = email_utiliasteur;
    }

}
