/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author admin
 */
public class Commande {
    
    private int id ;
    private String libellecommade,descriptioncomande;
    private int quantitecommande;
    String prixUnitaire;
    int prixTotal ;
    String etat , nomfournisseur;

    public Commande() {
    }
    
    public Commande( int id ,String libellecommade, String descriptioncomande, int quantitecommande, String prixUnitaire, int prixTotal) {
        this.id = id;
        this.libellecommade = libellecommade;
        this.descriptioncomande = descriptioncomande;
        this.quantitecommande = quantitecommande;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = prixTotal;
    }
     public Commande(int prixTotal) {
         this.prixTotal=prixTotal;
    }
       public Commande(String libellecommade) {
         this.libellecommade=libellecommade;
    }
    

    
    
    
    
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibellecommade() {
        return libellecommade;
    }

    public void setLibellecommade(String libellecommade) {
        this.libellecommade = libellecommade;
    }

    public String getDescriptioncomande() {
        return descriptioncomande;
    }

    public void setDescriptioncomande(String descriptioncomande) {
        this.descriptioncomande = descriptioncomande;
    }

    public int getQuantitecommande() {
        return quantitecommande;
    }

    public void setQuantitecommande(int quantitecommande) {
        this.quantitecommande = quantitecommande;
    }

    public String getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNomfournisseur() {
        return nomfournisseur;
    }

    public void setNomfournisseur(String nomfournisseur) {
        this.nomfournisseur = nomfournisseur;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", libellecommade=" + libellecommade + ", descriptioncomande=" + descriptioncomande + ", quantitecommande=" + quantitecommande + ", prixUnitaire=" + prixUnitaire + ", prixTotal=" + prixTotal + ", etat=" + etat + ", nomfournisseur=" + nomfournisseur + '}';
    }
    
    
    
    
    
}
