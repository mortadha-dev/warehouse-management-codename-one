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

import com.codename1.components.ToastBar;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;

/**
 * Common code that can setup the side menu
 *
 * @author HP
 */
public abstract class SideMenuBaseForm extends Form {

    public SideMenuBaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public SideMenuBaseForm(String title) {
        super(title);
    }

    public SideMenuBaseForm() {
    }

    public SideMenuBaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }
    
    public void setupSideMenu(Resources res) {
        Image profilePic = res.getImage("debouu.png");
        Image mask = res.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("  DEBOU ", profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());

        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
       

        getToolbar().addComponentToSideMenu(sidemenuTop);
        getToolbar().addMaterialCommandToSideMenu("  Service RH ", FontImage.MATERIAL_PEOPLE,  e -> new MariemForm(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Service D'ACHAT ", FontImage.MATERIAL_SHOPPING_CART,  e -> new MortadhaForm(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Service LIVRAISON", FontImage.MATERIAL_LOCAL_SHIPPING,  e -> new MarwenForm(res).show());
        getToolbar().addMaterialCommandToSideMenu("  Profil ", FontImage.MATERIAL_EVENT_NOTE,  e -> new TayssirForm(res).show());  
        getToolbar().addMaterialCommandToSideMenu("  Service Aprés-vente ", FontImage.MATERIAL_EVENT_NOTE,  e -> new ProfilForm().show());
        getToolbar().addMaterialCommandToSideMenu("  Reclamation ", FontImage.MATERIAL_EVENT_NOTE,  e -> new ReclamationForm(res).show());  
        getToolbar().addMaterialCommandToSideMenu("  Rendez-Vous ", FontImage.MATERIAL_EVENT_NOTE,  e -> new RendezVourForm(res).show());  
        getToolbar().addMaterialCommandToSideMenu("  Se déconnecter", FontImage.MATERIAL_EXIT_TO_APP,  e -> new LoginForm(res).show());


    }
    
    protected abstract void showOtherForm(Resources res);
}
