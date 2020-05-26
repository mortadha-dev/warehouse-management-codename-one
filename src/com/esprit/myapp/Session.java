/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp;


import com.esprit.Entities.Conge;
import com.esprit.Entities.Employe;
import com.esprit.Entities.User;

/**
 *
 * @author Emna
 */
public class Session {
    public static boolean cnx=false;
    private static Employe employe;
    private static Conge conge;
//    private static Fablab fablab;
    private static User user;

    public static boolean isCnx() {
        return cnx;
    }

    public static Employe getEmploye() {
        return employe;
    }

    public static void setEmploye(Employe employe) {
        Session.employe = employe;
    }

    public static void setCnx(boolean cnx) {
        Session.cnx = cnx;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Session.user = user;
    }

    public static Conge getConge() {
        return conge;
    }

    public static void setConge(Conge conge) {
        Session.conge = conge;
    }
    
    
    
}
