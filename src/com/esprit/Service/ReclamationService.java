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
import com.esprit.Entities.Reclamation;
import com.esprit.gui.ReclamationForm;
import com.esprit.myapp.Session;

/**
 *
 * @author Mars
 */
public class ReclamationService {

    public ArrayList<Reclamation> parseListTaskJson(String json) {

        ArrayList<Reclamation> listReclamations = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Reclamation e = new Reclamation();
                float id = Float.parseFloat(obj.get("id").toString());
                float idclient_id = Float.parseFloat(obj.get("idclient_id").toString());
                float etat = Float.parseFloat(obj.get("etat").toString());
                e.setId((int) id);
                e.setIdclient_id((int) idclient_id);
                e.setIdclient_id((int) etat);
                e.setDescription(obj.get("description").toString());
                e.setType(obj.get("type").toString());
                e.setDate(obj.get("date").toString());

                listReclamations.add(e);
            }

        } catch (IOException ex) {
        }
        return listReclamations;

    }

    ArrayList<Reclamation> listReclamations = new ArrayList<>();

    public ArrayList<Reclamation> getListReclamation() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Session.API_URL + "/rec/" + Session.getUser().getId());
        //con.setUrl(Session.API_URL + "/rec/" + "3");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReclamationService ser = new ReclamationService();
                listReclamations = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReclamations;
    }

    public void deleteReclamation(Resources res, int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Session.API_URL + "/rec/delete/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(con.getResponseData()));
                new ReclamationForm(res).show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    public void createReclamation(Resources res,int idClient, String description, String type) {
        ConnectionRequest con = new ConnectionRequest();
        String str = Session.API_URL + "/rec/create/" + idClient + "/" + description + "/" + type;
        System.out.println(str);
        con.setUrl(str);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(con.getResponseData()));
                /////
                new ReclamationForm(res).show();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
