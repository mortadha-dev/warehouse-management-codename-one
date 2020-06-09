/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

/**
 *
 * @author Mahdi
 */
public class Livreur {
     private int id;
     private String nomliv;
     private String adresseliv;
     private int numtel;

//    @Override
//    public String toString() {
//        return "Livreur{" + "id=" + id + ", nomliv=" + nomliv + ", adresseliv=" + adresseliv + ", numtel=" + numtel + '}';
//    }

    @Override
    public String toString() {
        return "Livreur{" + "nomliv=" + nomliv + '}';
    }
     
     

    public void setId(int id) {
        this.id = id;
    }

    public void setNomliv(String nomliv) {
        this.nomliv = nomliv;
    }

    public void setAdresseliv(String adresseliv) {
        this.adresseliv = adresseliv;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getId() {
        return id;
    }

    public String getNomliv() {
        return nomliv;
    }

    public String getAdresseliv() {
        return adresseliv;
    }

    public int getNumtel() {
        return numtel;
    }

    public Livreur(int id, String nomliv, String adresseliv, int numtel) {
        this.id = id;
        this.nomliv = nomliv;
        this.adresseliv = adresseliv;
        this.numtel = numtel;
    }

    public Livreur() {
    }
    
}
