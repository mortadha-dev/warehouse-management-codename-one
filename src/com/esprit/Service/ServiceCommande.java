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
import com.esprit.Entities.Commande;
import com.esprit.Entities.Offre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

/**
 *
 * @author I.O.I
 */
public class ServiceCommande {
    public void accepteCommande(Commande ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:8080/pi/web/app_dev.php/commandes/accepter?id="+ta.getId()+"&cat="+ta.getPrixUnitaire();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
     public void refusCommande(Commande ta) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:8080/pi/web/app_dev.php/commandes/refuser?id="+ta.getId();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    public void suppAbonnement(Commande ta) {
      
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost:8080/pi/web/app_dev.php/commandes/del?id="+ta.getId();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
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
     
    
    public ArrayList<Commande> parseListTaskJson(String json) {

        ArrayList<Commande> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            for (Map<String, Object> obj : list) {
                float id = Float.parseFloat(obj.get("id").toString());
                Commande rs = new Commande();
                rs.setId((int) id);
                 rs.setLibellecommade(obj.get("libellecommande").toString());
                 
                 rs.setDescriptioncomande(obj.get("descriptioncommande").toString());
                  rs.setDescription(obj.get("description").toString());
                
                float quantitecommande = Float.parseFloat(obj.get("quantitecommande").toString());
                rs.setQuantitecommande((int) quantitecommande);
                
//                 float prixUnitaire = Float.parseFloat(obj.get("prixUnitaire").toString());
//                rs.setPrixUnitaire((int) prixUnitaire);
                rs.setPrixUnitaire(obj.get("prixUnitaire").toString());
                
                 float prixTotal = Float.parseFloat(obj.get("prixTotal").toString());
                rs.setPrixTotal((int) prixTotal);  
                
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
    
    
    ArrayList<Commande> listTasks = new ArrayList<>();
    
    public ArrayList<Commande> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost:8080/pi/web/app_dev.php/commandes/read");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceCommande ser = new ServiceCommande();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
}
