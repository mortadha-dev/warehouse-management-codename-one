/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Reclamation;
import com.esprit.Service.ReclamationService;
import com.esprit.myapp.AppUtils;
import java.util.ArrayList;

/**
 *
 * @author Mars
 */
public class ReclamationForm extends SideMenuBaseForm {

    private String filterString = "";

    public ReclamationForm(Resources res) {
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
                                new Label("Les Reclamations", "Title")
                        )
                ).add(BorderLayout.WEST, profilePicLabel)
        );
        Container allEventCont = new Container(BoxLayout.y());

        setupSideMenu(res);
        tb.setTitleComponent(titleCmp);
        titleCmp.setUIID("titleCMP");
        
        Label search = new Label("Ajouter Reclamation", "LoginButton");

        Label searchIcon = new Label("", "LoginButton");

        searchIcon.addPointerPressedListener((evt) -> {
            new CreateReclamationForm(res).show();
        });
        searchIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(searchIcon, FontImage.MATERIAL_ADD_CIRCLE, 5);

        add(BorderLayout.center(searchIcon));

        ReclamationService rs = new ReclamationService();
        for (Reclamation e : rs.getListReclamation()) {
            allEventCont.add(addEvent(res, e));
        }
        add(allEventCont);

    }

    private Container addEvent(Resources res, Reclamation evenement) {

        Label eventinfo = new Label(evenement.getDate() + " | Type : " + evenement.getType(), "EventInfo");
        Label readMore = new Label("Read More", "LoginButton");
        Container titleOnly = new Container(BoxLayout.y());
        titleOnly.addAll(eventinfo);
        Container titleEventCmp = new Container(BoxLayout.x());
        titleEventCmp.addAll(titleOnly);
        titleEventCmp.setUIID("topEventtitle");
        Container eventCont = new Container(BoxLayout.y());
        ConnectionRequest con = new ConnectionRequest();
        SpanLabel txtDesc = new SpanLabel(evenement.getDescription(), "Description");
        eventCont.addAll(titleEventCmp);
        eventCont.addAll(txtDesc, readMore);
        eventCont.setUIID("EventContainer");

        readMore.addPointerPressedListener((evt) -> {
            AppUtils.setReclamation(evenement);
            new ReclamationShowForm(res).show();
        });
        return eventCont;
    }

    @Override
    protected void showOtherForm(Resources res) {
        //new StatsForm(res).show();
    }

}
