/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.esprit.Entities.RendezVous;
import com.esprit.gui.RendezVourForm;
import com.esprit.myapp.Session;

/**
 *
 * @author Mars
 */
public class RendezVousService {
    
    
    public ArrayList<RendezVous> parseListTaskJson(String json) {

        ArrayList<RendezVous> listReclamations = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                RendezVous e = new RendezVous();

                float id = Float.parseFloat(obj.get("id").toString());
                float idclient_id = Float.parseFloat(obj.get("idcl_id").toString());
                e.setId((int) id);
                e.setIdcl_id((int) idclient_id);
                e.setDesrition(obj.get("desrition").toString());
                e.setDateenvoi(obj.get("dateenvoi").toString());
                e.setDate(obj.get("date").toString());

                listReclamations.add(e);
            }

        } catch (IOException ex) {
        }
        return listReclamations;

    }
    
    ArrayList<RendezVous> listRendezVous = new ArrayList<>();

    public ArrayList<RendezVous> getListRendezVous() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Session.API_URL + "/rv/" + Session.getUser().getId());
        //con.setUrl(Session.API_URL + "/rv/" + "3");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                RendezVousService ser = new RendezVousService();
                
               listRendezVous = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listRendezVous;
    }
    
    public void deleteRendezVous(Resources res, int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Session.API_URL + "/rv/delete/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(con.getResponseData()));
                new RendezVourForm(res).show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    public void createRendezVous(Resources res, int idClient, String description, String date) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Session.API_URL + "/rv/create/" + idClient + "/" + description + "/" + date);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(con.getResponseData()));
                new RendezVourForm(res).show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
