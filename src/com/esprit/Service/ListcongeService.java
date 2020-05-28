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
import com.esprit.myapp.Session;
import java.io.IOException;
import java.util.Map;
import com.esprit.Entities.Conge;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP
 */
public class ListcongeService {
     boolean verif = false;
//    public void detailConge(int idE) {
//        ConnectionRequest con = new ConnectionRequest();
//        String url = "http://localhost/pi-gestion_employes/web/app_dev.php/mobile/listconge" + idE;
//        con.setUrl(url);
//        con.addResponseListener((evt) -> {
//            String response = new String(con.getResponseData());
//
//            try {
//                JSONParser j = new JSONParser();
//                Map<String, Object> obj = j.parseJSON(new CharArrayReader(response.toCharArray()));
//
//                Conge c = new Conge();
//                c.setIdE(idE);
//                c.setRaison(obj.get("Raison du congé").toString());
//                c.setDate_d_String(obj.get("Date début").toString());
//                c.setDate_f_String(obj.get("Date fin").toString());
//                c.setEtat(Float.valueOf(obj.get("Etat").toString()).intValue());
//               
//                Session.setConge(c);
//            } catch (IOException ex) {
//            }
//
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//    }
     public ArrayList<Conge> parseListTaskJson(String json) {

        ArrayList<Conge> listFabs = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Conge f = new Conge();
                float idconge = Float.parseFloat(obj.get("idconge").toString());f.setIdconge((int) idconge);
                f.setRaison(obj.get("raison").toString());
                f.setDatedebut(obj.get("datedebut").toString());
                f.setDatefin(obj.get("datefin").toString());
//                float etat = Float.parseFloat(obj.get("etat").toString());
//                f.setEtat((int)etat);
//              
                listFabs.add(f);

            }

        } catch (IOException ex) {
        }
         System.out.println(listFabs);
        return listFabs;

    }
    ArrayList<Conge> listFabs = new ArrayList<>();
    public ArrayList<Conge> getListEvent(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/pi-gestion_employes/web/app_dev.php/readCong");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ListcongeService ser = new ListcongeService();
                listFabs = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listFabs;
    }
//    public boolean verifUser(int idclub, int idUser) {
//        verif = false;
//        ConnectionRequest con = new ConnectionRequest();
//        String url = "http://localhost/techevent-final/web/app_dev.php/mobile/clubd/verif?idclub=" + idclub + "&id=" + idUser;
//        con.setUrl(url);
//        con.addResponseListener((evt) -> {
//            String response = new String(con.getResponseData());
//            if (response.indexOf("YEAP") != -1) {
//                verif = true;
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//        return verif;
//    }
}
