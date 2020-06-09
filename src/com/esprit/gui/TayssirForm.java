/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Conge;

/**
 *
 * @author admin
 */
public class TayssirForm extends SideMenuBaseForm {
      Form f;
        Conge c =new Conge();
        Resources theme   ;
        Form current ; 
    public TayssirForm(Resources res) {
         super(BoxLayout.y());
         current = this ; 
    
        f = new Form();
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image eventPic = res.getImage("BackgroundRect.png");
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
                                new Label(" Gestion de compte ", "Title")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
        Button hihi = new Button( "Editer Profil");
        Button btnprofil = new Button("Bloquer Profil");
        
        
        Button logout = new Button("Se déconnecter ");
         
        hihi.addActionListener((evt) -> {
           new ValidEditionForm(theme).show();
          
        });
      
           btnprofil.addActionListener((evt) -> {
            new BloqueForm(theme).show();
           });
          
            logout.addActionListener((evt) -> {
            new LoginForm(theme).show();
           });
        addAll(hihi,btnprofil,logout);
//        getToolbar().addCommandToLeftBar("Home", null, ev -> {
//            previous.showBack();
//        });
              
 
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


    

