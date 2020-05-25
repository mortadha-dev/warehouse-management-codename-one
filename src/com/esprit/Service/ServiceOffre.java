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
import com.esprit.Entities.Offre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ServiceOffre {
    
      public void ajouteroffre(Offre fr) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:8080/pi/web/app_dev.php/offre/ajout?codeoff="+fr.getCodeOff()+"&nom="+fr.getNomProduit()+"&ancien="+fr.getAnciePrix()+"&nouveau="+fr.getNouveauPrix()+"&delai="+fr.getDelaivalidite();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
      public void modifieroffre(Offre fr) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:8080/pi/web/app_dev.php/offre/modifier?id="+fr.getId()+"&modif="+fr.getDelaivalidite();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    

    
     public void suppOffre(Offre ta) {
      
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:8080/pi/web/app_dev.php/offre/del?id="+ta.getId();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Offre> parseListoffreJson(String json) {

        ArrayList<Offre> listoffre = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {
                float id = Float.parseFloat(obj.get("id").toString());
                Offre rs = new Offre();
                rs.setId((int) id);               
                rs.setNomProduit(obj.get("nomProduit").toString());
                 
                float ancienprix = Float.parseFloat(obj.get("ancienPrix").toString());
                rs.setAnciePrix((int) ancienprix); 
                 
           
                float nouveauprix = Float.parseFloat(obj.get("nouveauPrix").toString());
                rs.setNouveauPrix((int) nouveauprix);
                 float reduction = Float.parseFloat(obj.get("reduction").toString());
                rs.setReduction((int) reduction);
     
                rs.setDelaivalidite(obj.get("delaivalidite").toString());
                 float codeoff = Float.parseFloat(obj.get("codeoffre").toString());
                rs.setCodeOff((int) codeoff);  
                
                listTasks.add(rs);

            }

        } catch (IOException ex) {
        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
    
    
    ArrayList<Offre> listTasks = new ArrayList<>();
    
    public ArrayList<Offre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8080/pi/web/app_dev.php/offre/read");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceOffre ser = new ServiceOffre();
                listTasks = ser.parseListoffreJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
}
