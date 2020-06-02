/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.entities.Livraison;
import com.services.ServiceLivraison;
import java.util.ArrayList;

/**
 *
 * @author Mahdi
 */
public class ListLivraisonForm extends Form {

    public ArrayList<Livraison> livraison;
    String listliv = "";

    public ListLivraisonForm(Form previous)  {
        setTitle("List Livraisons");
//        Image img= Image.createImage("C:/Users/Mahdi/Desktop/blue_pin.png"); 
//Image img= Image.createImage("C:/Users/Mahdi/Documents/NetBeansProjects/Gestion-d-entrepoy/PiMobile/src/com/gui/blue_pin.png");
//        setBgImage(img);
        
        SpanLabel sp = new SpanLabel();
        livraison = ServiceLivraison.getInstance().getAllLivraison();

        for (Livraison n : livraison) {

            listliv = listliv + "pays: " + n.getPays() + "\n" + "ville: " + n.getVille() + "\n" + "adresse: " + n.getAdresse() + "\n" + "etat: " + n.getEtat() + "\n" + "heur de livaison: " + n.getHeurliv() + "\n" + "\n";
        }
        sp.setText(listliv);
//         sp.setText(ServiceLivraison.getInstance().getAllLivraison().toString());
        getToolbar().addCommandToLeftBar("Home", null, ev -> {
            previous.showBack();
        });
        add(sp);

    }

}
