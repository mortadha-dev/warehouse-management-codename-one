/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Reclamation;
import com.esprit.Entities.RendezVous;
import com.esprit.Service.ReclamationService;
import com.esprit.Service.RendezVousService;
import com.esprit.myapp.AppUtils;

/**
 *
 * @author Mars
 */
public class RendezVourForm extends SideMenuBaseForm {
    
    
    private String filterString = "";

    public RendezVourForm(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");
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
                                new Label("Les Rendez-vous", "Title")
                        )
                ).add(BorderLayout.WEST, profilePicLabel)
        );
        Container allEventCont = new Container(BoxLayout.y());

        setupSideMenu(res);
        tb.setTitleComponent(titleCmp);
        titleCmp.setUIID("titleCMP");
        
        Label searchIcon = new Label("", "LoginButton");

        searchIcon.addPointerPressedListener((evt) -> {
            new CreateRendezVousForm(res).show();
        });
        searchIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(searchIcon, FontImage.MATERIAL_ADD_CIRCLE, 5);

        add(BorderLayout.center(searchIcon));

        RendezVousService rs = new RendezVousService();
        for (RendezVous e : rs.getListRendezVous()) {
            allEventCont.add(addEvent(res, e));
        }
        add(allEventCont);

    }
    
    
    private Container addEvent(Resources res, RendezVous evenement) {

        Label eventinfo = new Label(evenement.getDate() + " | Date de Rendez-Vous : " + evenement.getDateenvoi(), "EventInfo");
        Label readMore = new Label("Delete", "LoginButton");
        Container titleOnly = new Container(BoxLayout.y());
        titleOnly.addAll(eventinfo);
        Container titleEventCmp = new Container(BoxLayout.x());
        titleEventCmp.addAll(titleOnly);
        titleEventCmp.setUIID("topEventtitle");
        Container eventCont = new Container(BoxLayout.y());
        ConnectionRequest con = new ConnectionRequest();
        SpanLabel txtDesc = new SpanLabel(evenement.getDesrition(), "Description");
        eventCont.addAll(titleEventCmp);
        eventCont.addAll(txtDesc, readMore);
        eventCont.setUIID("EventContainer");

        readMore.addPointerPressedListener((evt) -> {
          if (Dialog.show("Attention", "Delete rendez-vous...", "OK", "Cancel")) {
                RendezVousService rs = new RendezVousService();
                rs.deleteRendezVous(res, evenement.getId());
            }
        });
        return eventCont;
    }
    
    @Override
    protected void showOtherForm(Resources res) {
        //new StatsForm(res).show();
    }
    
}
