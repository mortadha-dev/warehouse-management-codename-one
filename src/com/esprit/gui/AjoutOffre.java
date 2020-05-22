/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;


import com.codename1.components.ImageViewer;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;
import com.esprit.Entities.Offre;
import com.esprit.Service.ServiceCommande;

/**
 *
 * @author skander
 */
public class AjoutOffre extends SideMenuBaseForm {
      
     Form f;

    SpanLabel lb;
  
    
        public AjoutOffre(Resources res) {
        f=new Form("Offre spéciale",new FlowLayout(Component.CENTER, Component.CENTER));
        Container g= new Container(BoxLayout.y());
        Container c= new Container(BoxLayout.y());
        SpanLabel l = new SpanLabel("Veuillez Remplir Formulaire");
        TextField t0= new TextField("","Code de l'offre");
        TextField t1= new TextField("","Nom du produit");
        TextField t2= new TextField("","Ancien Prix");
        TextField t3= new TextField("","Nouveau Prix");
        TextField t4= new TextField("","Délai de validité");
      // Picker datedebut =new Picker();
      // Picker datefin = (Picker) new Picker().getValue();
 
        Button bAvis = new Button("Ajouter");
              
        bAvis.addActionListener((ActionListener) (ActionEvent evt1) -> {
        if ( t1.getText().isEmpty()){
                    Dialog.show("erreur", "verifier les champs","ok", null);        
          if (t2.getText().isEmpty()){
                    Dialog.show("erreur", "verifier les champs","ok", null);
        }}
        else {
        ServiceCommande ser=new ServiceCommande();
        Offre fr = new Offre();    
        fr.setCodeOff(Integer.parseInt(t0.getText()));
        fr.setNomProduit((t1.getText()));
        fr.setAnciePrix(Integer.parseInt(t2.getText()));
        fr.setNouveauPrix(Integer.parseInt(t3.getText()));
        fr.setDelaivalidite("8 jours");      
            ser.ajouteroffre(fr);
             Dialog.show("OK", "Merci pour cette offre","ok", null);
            AffichageOffre a =new AffichageOffre(res);
            a.getF().show();
            Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    //new AffichageCommande(UIManager.initFirstTheme("/theme")).show();
                }
            });
            
}
        });     
        c.add(l);
        c.add(t0);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(t4);
        
        c.add(bAvis);
        g.add(c);
        f.add(g);
        Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new MortadhaForm(UIManager.initFirstTheme("/theme")).show();
                }
            });
 
      
//          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
//          h.getF().show();
//          });
    }
  

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
    
}
