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
import com.esprit.Entities.Employe;
import com.esprit.myapp.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class EmployeService {
     boolean verif,type = false;

    public ArrayList<Employe> parseListTaskJson(String json) {

        ArrayList<Employe> listEmployes = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Employe e = new Employe();

                float id = Float.parseFloat(obj.get("id").toString());
                e.getIdE();
                e.setNom(obj.get("nom").toString());
                e.setPrenom(obj.get("prenom").toString());
                e.setCin(obj.get("cin").toString());
                e.setNumtel(obj.get("tel").toString());
                e.setEmail(obj.get("email").toString());
                listEmployes.add(e);
                System.out.println(e);

            }

        } catch (IOException ex) {
        }
        return listEmployes;

    }
    ArrayList<Employe> listEmployes = new ArrayList<>();

    public ArrayList<Employe> getListEmploye() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8080/pi/web/app_dev.php/mobile/club");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EmployeService ser = new EmployeService();
                listEmployes = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEmployes;
    }

    public void detailEmploye(int idE) {
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost:8080/pi/web/app_dev.php/mobile/club/" + idE;
        con.setUrl(url);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());

            try {
                JSONParser j = new JSONParser();
                Map<String, Object> obj = j.parseJSON(new CharArrayReader(response.toCharArray()));
                Employe e = new Employe();
                e.setIdE(idE);
                e.setNom(obj.get("nom").toString());
                e.setPrenom(obj.get("prenom").toString());
                e.setCin(obj.get("cin").toString());
                e.setNumtel(obj.get("tel").toString());
                e.setEmail(obj.get("email").toString());

                Session.setEmploye(e);
            } catch (IOException ex) {
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

//    public void deleteClub(int idclub) {
//        ConnectionRequest con = new ConnectionRequest();
//        String url = "http://localhost/techevent-final/web/app_dev.php/mobile/clubd/delete/" + idclub;
//        con.setUrl(url);
//        con.addResponseListener((evt) -> {
//            String response = new String(con.getResponseData());
//            System.out.println("DONE");
//        });
//        NetworkManager.getInstance().addToQueueAndWait(con);
//    }

}
