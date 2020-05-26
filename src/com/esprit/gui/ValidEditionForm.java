/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
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
import com.codename1.ui.util.Resources;
import com.esprit.Service.UserService;

/**
 *
 * @author tayssir
 */
public class ValidEditionForm extends SideMenuBaseForm{
   
    public ValidEditionForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
      
       
        setUIID("LoginForm");
        
        Container welcome = FlowLayout.encloseCenter(
                new Label("Editer Profile  ", "WelcomeWhite")
                
              
        );
        
       Toolbar T1 = getToolbar();

            T1.addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EmployesForm(UIManager.initFirstTheme("/theme")).show();
                }
            });
       
        
        getTitleArea().setUIID("Container");
        
        TextField username = new TextField("", "Nom d'utilisateur", 20, TextField.EMAILADDR) ;
        TextField email = new TextField("", "Email", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD) ;
        TextField password2 = new TextField("", "Confirmer mot de passe", 20, TextField.PASSWORD) ;
       email.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label emailIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        Label pwdIcon = new Label("", "TextField");
        Label userIcon = new Label("", "TextField");
        emailIcon.getAllStyles().setMargin(RIGHT, 0);
        pwdIcon.getAllStyles().setMargin(RIGHT, 0);
        userIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(emailIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(userIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(pwdIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        Button editerButton = new Button("Editer");
        editerButton.setUIID("LoginButton");
        Button bloquerButton = new Button("Bloquer");
        bloquerButton.setUIID("LoginButton");
        editerButton.addActionListener(e -> {
            UserService us = new UserService();
            
            
            boolean verif = false;
           if(password.getText().equals(password2.getText())){
                verif = true;
            }else{
                Dialog.show("Conf", "Login password Invalid", "ok",null); 
            }
            
            if(email.getText().indexOf("@") != -1){
                verif = true;
            }else{
                Dialog.show("Conf", "Email invalid", "ok",null); 
            }
            if(verif){
                us.update(username.getText(), email.getText(), password.getText());
            }
               new LoginForm(theme).show();
           
        });
        
        bloquerButton.addActionListener(e -> {
            UserService us = new UserService();
            
            
            boolean verif = false;
           if(password.getText().equals(password2.getText())){
                verif = true;
            }else{
                Dialog.show("Conf", "Login password Invalid", "ok",null); 
            }
            
            if(email.getText().indexOf("@") != -1){
                verif = true;
            }else{
                Dialog.show("Conf", "Email invalid ", "ok",null); 
            }
            if(verif){
                us.bloque(username.getText());
            }
               new BloqueForm(theme).show();
           
        });

        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        Container by = BoxLayout.encloseY(
                 welcome,
                spaceLabel,
                BorderLayout.center(username).
                        add(BorderLayout.WEST, userIcon),
                BorderLayout.center(email).
                        add(BorderLayout.WEST, emailIcon),
                
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                BorderLayout.center(password2).
                        add(BorderLayout.WEST, pwdIcon),
                editerButton,bloquerButton

        );
        add(BorderLayout.CENTER, by);
        
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }

    @Override
    protected void showOtherForm(Resources res) {
         new StatsForm(res).show();
    }
}
