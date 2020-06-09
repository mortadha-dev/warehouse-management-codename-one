/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Livraison;
import com.esprit.Service.ServiceLivraison;
import java.util.ArrayList;

/**
 *
 * @author Mahdi
 */
public class ListLivraisonForm extends Form {
   Form f;
    public ArrayList<Livraison> livraison;
    String listliv = "";
    Resources current;
    public ListLivraisonForm(Resources res)  {
          f = new Form();
      
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
      

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label(" Les Clubs ", "Title")
                        )
                )
        );

        f.setTitle("Liste des Livraisons");
        f.setLayout(BoxLayout.y());
        
        
        SpanLabel sp = new SpanLabel();
        livraison = ServiceLivraison.getInstance().getAllLivraison();

        for (Livraison n : livraison) {

            listliv = listliv + "pays: " + n.getPays() + "\n" + "ville: " + n.getVille() + "\n" + "adresse: " + n.getAdresse() + "\n" + "etat: " + n.getEtat() + "\n" + "heur de livaison: " + n.getHeurliv() + "\n" + "\n";
        }
        sp.setText(listliv);
        f.add(sp);
         Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new MarwenForm(UIManager.initFirstTheme("/theme")).show();
                }
            });

    }
    
    public Form getF() {
        return f;
    }
    
    public void setF(Form f) {
        this.f = f;
    }

}
