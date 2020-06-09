/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entities;

/**
 *
 * @author Mars
 */
public class Reclamation {
    int id;
    int idclient_id;
    String date;
    String description;
    int etat;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdclient_id() {
        return idclient_id;
    }

    public void setIdclient_id(int idclient_id) {
        this.idclient_id = idclient_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Reclamation(int id, int idclient_id, String date, String description, int etat, String type) {
        this.id = id;
        this.idclient_id = idclient_id;
        this.date = date;
        this.description = description;
        this.etat = etat;
        this.type = type;
    }

    public Reclamation() {
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", idclient_id=" + idclient_id + ", date=" + date + ", description=" + description + ", etat=" + etat + ", type=" + type + '}';
    }

}
