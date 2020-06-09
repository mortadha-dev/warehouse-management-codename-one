/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.MultiButton;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.esprit.Service.ReclamationService;
import com.esprit.Service.RendezVousService;
import com.esprit.myapp.Session;
import java.util.Map;

/**
 *
 * @author Mars
 */
public class CreateRendezVousForm extends SideMenuBaseForm {

    public CreateRendezVousForm(Resources res) {
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
                                new Label("Ajouter Rendez-vous", "Title")
                        )
                ).add(BorderLayout.WEST, profilePicLabel)
        );
        Container allEventCont = new Container(BoxLayout.y());

        setupSideMenu(res);
        tb.setTitleComponent(titleCmp);
        titleCmp.setUIID("titleCMP");
        Picker datePicker = new Picker();
        datePicker.setType(Display.PICKER_TYPE_DATE);

        TextComponent description = new TextComponent().label("Description").multiline(true);
        add(datePicker);
        add(description);
        RendezVousService rs = new RendezVousService();
        Label search = new Label("Confirmer", "LoginButton");

        search.addPointerPressedListener((evt) -> {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(datePicker.getDate());
            rs.createRendezVous(res,Session.getUser().getId(), description.getText(), dateString);
        });
        add(BorderLayout.center(search));

    }

    @Override
    protected void showOtherForm(Resources res) {
        // new StatsForm(res).show();
    }
}
