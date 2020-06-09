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
import com.esprit.Entities.Livraison;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mahdi
 */
public class ServiceLivraison {
    
     public static ServiceLivraison instance=null;
     private ConnectionRequest req;
     public ArrayList<Livraison> livraison;
     
     private ServiceLivraison() {
         req = new ConnectionRequest();
    }
     public static ServiceLivraison getInstance() {
        if (instance == null) {
            instance = new ServiceLivraison();
        }
        return instance;
    }
     
     public ArrayList<Livraison> parselivraison(String jsonText){
        try {
            livraison=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> livraisonListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)livraisonListJson.get("root");
            for(Map<String,Object> obj : list){
                Livraison l = new Livraison();
                float id = Float.parseFloat(obj.get("id").toString());
                String pays = obj.get("pays").toString();
                String ville = obj.get("ville").toString();
                String adresse = obj.get("adresse").toString();
                String etat = obj.get("etat").toString();
                String heur = obj.get("heurliv").toString();
                l.setId((int)id);
                l.setPays(pays);
                l.setVille(ville);
                l.setAdresse(adresse);
                l.setEtat(etat);
                l.setHeurliv(heur);
                
               
                livraison.add(l);
            }
            
            
        } catch (IOException ex) {
            
        }
        return livraison;
    }
     

     public ArrayList<Livraison> getAllLivraison(){
        String url = "http://localhost:8080/pi/web/app_dev.php/Livraison/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                livraison = parselivraison(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return livraison;
    }
    
}
