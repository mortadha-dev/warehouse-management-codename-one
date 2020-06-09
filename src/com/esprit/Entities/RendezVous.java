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
public class RendezVous {
    int id;
    int idcl_id;
    String desrition;
    String date;
    String dateenvoi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcl_id() {
        return idcl_id;
    }

    public void setIdcl_id(int idcl_id) {
        this.idcl_id = idcl_id;
    }

    public String getDesrition() {
        return desrition;
    }

    public void setDesrition(String desrition) {
        this.desrition = desrition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(String dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    public RendezVous(int id, int idcl_id, String desrition, String date, String dateenvoi) {
        this.id = id;
        this.idcl_id = idcl_id;
        this.desrition = desrition;
        this.date = date;
        this.dateenvoi = dateenvoi;
    }

    public RendezVous() {
    }

    @Override
    public String toString() {
        return "RendezVous{" + "id=" + id + ", idcl_id=" + idcl_id + ", desrition=" + desrition + ", date=" + date + ", dateenvoi=" + dateenvoi + '}';
    }
}
