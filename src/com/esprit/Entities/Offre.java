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
public class Offre {
    int id ;
    int CodeOff;
    String NomProduit;
    int AnciePrix;
    int NouveauPrix;
    String delaivalidite;
    int reduction ;
    
    public Offre(){
        
    }

    public Offre(int CodeOff , String NomProduit, int AnciePrix, int NouveauPrix, String delaivalidite ,int reduction) {
        this.CodeOff= CodeOff;
        this.NomProduit = NomProduit;
        this.AnciePrix = AnciePrix;
        this.NouveauPrix = NouveauPrix;
        this.delaivalidite = delaivalidite;
        this.reduction=reduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProduit() {
        return NomProduit;
    }

    public void setNomProduit(String NomProduit) {
        this.NomProduit = NomProduit;
    }

    public int getAnciePrix() {
        return AnciePrix;
    }

    public void setAnciePrix(int AnciePrix) {
        this.AnciePrix = AnciePrix;
    }

    public int getNouveauPrix() {
        return NouveauPrix;
    }

    public void setNouveauPrix(int NouveauPrix) {
        this.NouveauPrix = NouveauPrix;
    }

    public String getDelaivalidite() {
        return delaivalidite;
    }

    public void setDelaivalidite(String delaivalidite) {
        this.delaivalidite = delaivalidite;
    }

    public int getCodeOff() {
        return CodeOff;
    }

    public void setCodeOff(int CodeOff) {
        this.CodeOff = CodeOff;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
