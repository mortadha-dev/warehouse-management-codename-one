/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

import java.util.Date;


/**
 *
 * @author HP
 */
public class Conge {
    private int idconge,idE,etat;
    private String raison,datedebut,datefin;
//    private  Date datedebut,datefin;

    public String getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
        this.datedebut = datedebut;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

//    public String getDate_d_String() {
//        return date_d_String;
//    }
//
//    public void setDate_d_String(String date_d_String) {
//        this.date_d_String = date_d_String;
//    }
//
//    public String getDate_f_String() {
//        return date_f_String;
//    }
//
//    public void setDate_f_String(String date_f_String) {
//        this.date_f_String = date_f_String;
//    }

    public int getIdconge() {
        return idconge;
    }

    public void setIdconge(int idconge) {
        this.idconge = idconge;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

//    public Date getDatedebut() {
//        return datedebut;
//    }
//
//    public void setDatedebut(Date datedebut) {
//        this.datedebut = datedebut;
//    }
//
//    public Date getDatefin() {
//        return datefin;
//    }
//
//    public void setDatefin(Date datefin) {
//        this.datefin = datefin;
//    }

    public Conge(int idconge, int idE, int etat, String raison, Date datedebut, Date datefin) {
        this.idconge = idconge;
        this.idE = idE;
        this.etat = etat;
        this.raison = raison;
//        this.datedebut = datedebut;
//        this.datefin = datefin;
    }

    public Conge() {
    }

    

    

    @Override
    public String toString() {
        return "Conge{" + "idconge=" + idconge + ", idE=" + idE + ", etat=" + etat + ", raison=" + raison + ", datedebut=" + datedebut + ", datefin=" + datefin + '}';
    }
    
}

