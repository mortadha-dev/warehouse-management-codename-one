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
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Conge;

/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author HP
 */
public class MortadhaForm extends SideMenuBaseForm {

    Resources current;
    Form f;
    Conge c = new Conge();
    Resources theme;

    public MortadhaForm(Resources res) {

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
                                new Label(" Service Achat ", "Title")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
        Button hihi = new Button("Afficher les commandes");
        Button btnprofil = new Button("Ajouter une offre a notre enropot");
        Button btndemandeconge = new Button("Consulter la liste des offres");
        Button Listconge = new Button("Contacter responsable d'achat");
        Button haha = new Button("Rate notre entropot");

        Button logout = new Button("Se déconnecter ");

        hihi.addActionListener((evt) -> {
            AffichageCommande d = new AffichageCommande(res);
            d.getF().show();
        });

        logout.addActionListener(e -> new LoginForm(res).show());
//        btndemandeconge.addActionListener(e-> new DemanderForm(res).show());
        btndemandeconge.addActionListener((evt) -> {
            AffichageOffre d = new AffichageOffre(res);
            d.getF().show();
        });
//        Listconge.addActionListener(e-> new ListcongeForm(current).show());
//        Conge c = new Conge();
        haha.addActionListener((evt) -> {
            //AffichageWidget f1 = new AffichageWidget(res);
            //f1.getF().show();
        });

        Listconge.addActionListener((evt) -> {

            // Mail f1= new Mail(res);
            //f1.getF().show();
        });
        btnprofil.addActionListener((evt) -> {

            AjoutOffre f1 = new AjoutOffre(res);
            f1.getF().show();
        });
        addAll(hihi, btnprofil, btndemandeconge, Listconge, haha, logout);

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
