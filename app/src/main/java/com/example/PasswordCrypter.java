package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PasswordCrypter {
    
    public static String cryptPassword(String password) {
        String cryptedPassword = null;
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            cryptedPassword = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            // handle the exception
        }
        
        return cryptedPassword;
    }
    public static boolean checkPassword(String plainTextPassword, String cryptedPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(plainTextPassword.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPassword = stringBuilder.toString();
            return hashedPassword.equals(cryptedPassword);
        } catch (NoSuchAlgorithmException e) {
            // handle the exception
            return false;
        }
    }
   
}