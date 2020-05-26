/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

/**
 *
 * @author admin
 */
public class Produit {
    
    int id ; 
    String description;
    String libelle; 
    int quantite;
    int quantitemin;
    int supprimer;

    public Produit(int id, String description, String libelle, int quantite, int quantitemin, int supprimer) {
        this.id = id;
        this.description = description;
        this.libelle = libelle;
        this.quantite = quantite;
        this.quantitemin = quantitemin;
        this.supprimer = supprimer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantitemin() {
        return quantitemin;
    }

    public void setQuantitemin(int quantitemin) {
        this.quantitemin = quantitemin;
    }

    public int getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(int supprimer) {
        this.supprimer = supprimer;
    }
    
    
    
}
