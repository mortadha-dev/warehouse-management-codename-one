/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.esprit.myapp.AppUtils;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Reclamation;
import com.esprit.Service.ReclamationService;

/**
 *
 * @author Mars
 */
public class ReclamationShowForm extends SideMenuBaseForm {

    public ReclamationShowForm(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                new Label(AppUtils.getReclamation().getType(), "Title"),
                new Label(AppUtils.getReclamation().getDate(), "Title")
        );
        setupSideMenu(res);
        tb.setTitleComponent(titleCmp);
        addEvent(res, AppUtils.getReclamation());

    }

    private void addEvent(Resources res, Reclamation evenement) {
        Container eventCont = new Container(BoxLayout.y());
        SpanLabel txtDesc = new SpanLabel(evenement.getDescription(), "Description");
        Label readMore = new Label("Delete", "LoginButton");
        readMore.addPointerPressedListener((evt) -> {
            if (Dialog.show("Attention", "Delete Reclamation...", "OK", "Cancel")) {
                ReclamationService rs = new ReclamationService();
                rs.deleteReclamation(res, evenement.getId());
            }
        });
        eventCont.addAll(txtDesc, readMore);
        add(eventCont);
    }

    ;
    
    @Override
    protected void showOtherForm(Resources res) {
        //new StatsForm(res).show();
    }

}
