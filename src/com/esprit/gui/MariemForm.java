/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.esprit.gui;
import com.codename1.components.ImageViewer;
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
import com.esprit.Service.DemandecongeService;
import com.esprit.Service.ListcongeService;




/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author HP
 */
public class MariemForm extends SideMenuBaseForm {
        Resources current;
        Form f;
        Conge c =new Conge();
        Resources theme   ;
    public MariemForm(Resources res) {
        
        super(BoxLayout.y());
        
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
                                new Label(" Service Rh ", "Title")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
      
    
        Button btndemandeconge = new Button("Demande Congé");
        Button Listconge = new Button("Liste des congés");
         Button mail = new Button("Contacter responsable RH");
        Button logout = new Button("Se déconnecter ");
       
      // mail.addActionListener(e-> new MariemMail(res).show());
         
         
       
        logout.addActionListener(e-> new LoginForm(res).show());
//        btndemandeconge.addActionListener(e-> new DemanderForm(res).show());
        btndemandeconge.addActionListener((evt) -> {
           DemanderForm d = new DemanderForm(res);
           d.getF().show();
        });
//        Listconge.addActionListener(e-> new ListcongeForm(current).show());
//        Conge c = new Conge();
        Listconge.addActionListener((evt) -> {
//            ListcongeService sv = new ListcongeService();
//            sv.detailConge(CENTER);
//            new ListcongeForm().show
        ListcongeForm l1 = new ListcongeForm(res);
        l1.getF().show(); });
        addAll(btndemandeconge,Listconge,mail,logout);
 
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

