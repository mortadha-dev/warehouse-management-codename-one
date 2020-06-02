/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import com.entities.Livreur;
//import java.time.LocalDate;
//import java.util.Date;

/**
 *
 * @author Mahdi
 */
public class Livraison {

    public int id;
    public String ville;
    public String pays;
    public String adresse;
    public String etat;
    public Livreur livreure;
    public String heurliv;
    public String commande;
    public String client;
//    public Date dateliv;

//    @Override
//    public String toString() {
//        return "Livraison{" + "id=" + id + ", ville=" + ville + ", pays=" + pays + ", adresse=" + adresse + ", etat=" + etat + ", livreure=" + livreure + ", heurliv=" + heurliv + ", commande=" + commande + ", client=" + client + '}';
//}
    @Override
    public String toString() {
        return "Livraison{" + "id=" + id + ", ville=" + ville + ", pays=" + pays + ", adresse=" + adresse + ", etat=" + etat + ", heurliv=" + heurliv + '}';
    }

//    }
    public void setId(int id) {
        this.id = id;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setLivreure(Livreur livreure) {
        this.livreure = livreure;
    }

    public void setHeurliv(String heurliv) {
        this.heurliv = heurliv;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public void setClient(String client) {
        this.client = client;
    }

//    public void setDateliv(Date dateliv) {
//        this.dateliv = dateliv;
//    }

    public int getId() {
        return id;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEtat() {
        return etat;
    }

    public Livreur getLivreure() {
        return livreure;
    }

    public String getHeurliv() {
        return heurliv;
    }

    public String getCommande() {
        return commande;
    }

    public String getClient() {
        return client;
    }

//    public Date getDateliv() {
//        return dateliv;
//    }

    public Livraison() {
    }

    public Livraison(int id, String ville, String pays, String adresse, String etat, Livreur livreure, String heurliv, String commande, String client) {
        this.id = id;
        this.ville = ville;
        this.pays = pays;
        this.adresse = adresse;
        this.etat = etat;
        this.livreure = livreure;
        this.heurliv = heurliv;
        this.commande = commande;
        this.client = client;
//        this.dateliv = dateliv;
    }

}
