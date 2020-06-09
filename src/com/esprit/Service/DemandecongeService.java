/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.esprit.Entities.Conge;
import java.util.Date;

/**
 *
 * @author HP
 */
public class DemandecongeService {
      public void demande(String raison, String datedebut, String datefin) {

ConnectionRequest con = new ConnectionRequest();
    String url = "http://localhost:8080/pi/web/app_dev.php/mobile/demandeconge/"+raison+"/"+datedebut+"/"+datefin;

        System.out.println("Ajout URL : "+url);
        con.setUrl(url);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueue(con);
                }
}



