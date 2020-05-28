/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.esprit.Service.DemandecongeService;
import com.esprit.Entities.Conge;
import com.esprit.myapp.Session;


/**
 *
 * @author HP
 */
public class DemanderForm  extends SideMenuBaseForm {
        Resources current;
        Form f;
        Conge c =new Conge();
        Resources theme   ;
    public DemanderForm(Resources res) {

        
        super(BoxLayout.y());
        
        f = new Form();
        
        f.setTitle("Demande Congé");
        f.setLayout(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("debouu.png");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label(" Accueil ", "Title")
                        )
                )
        );
        
                Toolbar T1 = f.getToolbar();
               
                T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EmployesForm(UIManager.initFirstTheme("/theme")).show(); }
            });
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
      
        f.add(new Label("Raison de congé"));
        TextField r = new TextField();
        f.add(r);
        
        f.add(new Label("Date Début"));
        TextField tdd = new TextField("jj-mm-aaaa");
        f.add(tdd);
        
        f.add(new Label("Date fin"));
        TextField tdf = new TextField("jj-mm-aaaa");
        f.add(tdf);
        
//        f.add(new Label("Date Début"));
//        Picker dd = new Picker();
//        dd.setType(Display.PICKER_TYPE_DATE);
//        f.add(dd);
////        Calendar d =new Calendar();
////        add(d);
//        f.add(new Label("Date fin"));
//        Picker df = new Picker();
//        df.setType(Display.PICKER_TYPE_DATE);
//        f.add(df);

        Button submit = new Button("Envoyer demande");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if( (r.getText().length()==0 ) ){
                      System.out.println("Veuillez remplir tous les champs");
                      Dialog.show("Alerte", "Veuillez remplir tous les champs", "ok", null);; }
                else if ( (r.getText().length()<5 ) ){
                      System.out.println("la raison doit contenir plus de 5 caractéres ");
                      Dialog.show("Alerte", "la raison doit contenir plus de 5 caractéres ", "ok", null);; }
//                else if (dd.getDate() == df.getDate() ){
//                    System.out.println("Veuillez choissir une date ");
//                      Dialog.show("Alerte", "Veuillez choissir une date", "ok", null);; }        
                                                           } });
            submit.addActionListener((evt) -> {
            if (!r.getText().equals("") && !tdd.getText().equals("") && !tdf.getText().equals("") ) {
                DemandecongeService sc = new DemandecongeService();
                sc.demande(r.getText(), tdd.getText(), tdf.getText());
                Dialog.show("Info", "Demande envoyée", "ok", null);
//                new ListcongeForm().show();
                  ListcongeForm l1 = new ListcongeForm(res);
                   l1.getF().show();
            } else {
                Dialog.show("Info", "Verifier Les Champs", "ok", null);
            }
        });
                   f.add(submit); 
                   

          
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
