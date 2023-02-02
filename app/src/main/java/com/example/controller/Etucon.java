package com.example.controller;

import com.example.Modetud;
import com.example.etudiant;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Etucon{
    @FXML
    TextField email;
    @FXML
    PasswordField pass;
    
    public static void valideetu(String email,String mot_de_pass) throws Exception{
        String email
etudiant e=Modetud.checkuser(email.toString(),pass.toString())
    }

}