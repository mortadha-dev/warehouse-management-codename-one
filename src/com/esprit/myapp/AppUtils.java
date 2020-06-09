package com.esprit.myapp;


import com.esprit.Entities.Reclamation;
import com.esprit.Entities.RendezVous;
import com.esprit.Entities.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mars
 */
public class AppUtils {
    private static Reclamation reclamation;
    private static RendezVous rendezVous;
    private static User user;

    public static Reclamation getReclamation() {
        return reclamation;
    }

    public static void setReclamation(Reclamation reclamation) {
        AppUtils.reclamation = reclamation;
    }

    public static RendezVous getRendezVous() {
        return rendezVous;
    }

    public static void setRendezVous(RendezVous rendezVous) {
        AppUtils.rendezVous = rendezVous;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        AppUtils.user = user;
    }  
}
