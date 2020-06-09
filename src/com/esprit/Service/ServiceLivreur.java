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
import com.esprit.Entities.Livreur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mahdi
 */
public class ServiceLivreur {
    
     public static ServiceLivreur instance=null;
     private ConnectionRequest req;
     public ArrayList<Livreur> livreur;
     
       
     private ServiceLivreur() {
         req = new ConnectionRequest();
    }
     
      public static ServiceLivreur getInstance() {
        if (instance == null) {
            instance = new ServiceLivreur();
        }
        return instance;
    }
      
      public ArrayList<Livreur> parselivraison(String jsonText){
        try {
            livreur=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> livraisonListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)livraisonListJson.get("root");
            for(Map<String,Object> obj : list){
                Livreur l = new Livreur();
               
                String nom = obj.get("nomliv").toString();
                
                l.setNomliv(nom);
                
               
                livreur.add(l);
            }
            
            
        } catch (IOException ex) {
            
        }
        return livreur;
    }
      
        public ArrayList<Livreur> getAllLivraison(){
        String url = "http://localhost:8080/pi/web/app_dev.php/Livreur/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                livreur = parselivraison(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return livreur;
    }
    
    
    
}
