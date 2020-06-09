/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextComponent;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Reclamation;
import com.esprit.Service.ReclamationService;
import com.esprit.myapp.AppUtils;
import com.esprit.myapp.Session;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mars
 */
public class CreateReclamationForm extends SideMenuBaseForm {

    public CreateReclamationForm(Resources res) {
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
                                new Label("Ajouter Reclamation", "Title")
                        )
                ).add(BorderLayout.WEST, profilePicLabel)
        );
        Container allEventCont = new Container(BoxLayout.y());

        setupSideMenu(res);
        tb.setTitleComponent(titleCmp);
        titleCmp.setUIID("titleCMP");
        ComboBox<Map<String, Object>> combo = new ComboBox<>(
                createListEntry("Reclamation Service"),
                createListEntry("Reclamation Produit"),
                createListEntry("FeedBack"));
        combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));

        TextComponent description = new TextComponent().label("Description").multiline(true);
        add(combo);
        add(description);
        ReclamationService rs = new ReclamationService();
        Label search = new Label("Ajouter Reclamation", "LoginButton");

        search.addPointerPressedListener((evt) -> {
            Object[] type = combo.getSelectedItem().values().toArray();
            rs.createReclamation(res,Session.getUser().getId(), description.getText(), type[0].toString());   
        });
        add(BorderLayout.center(search));

    }

    private Map<String, Object> createListEntry(String name) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        return entry;
    }

    @Override
        protected void showOtherForm(Resources res) {
        // new StatsForm(res).show();
    }
}
