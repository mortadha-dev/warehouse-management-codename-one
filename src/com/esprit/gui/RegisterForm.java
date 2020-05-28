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
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Service.UserService;

/**
 * The Login form
 *
 * @author Shai Almog
 */
public class RegisterForm extends Form {
    public RegisterForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
       Toolbar T1 = getToolbar();

            T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new LoginForm(UIManager.initFirstTheme("/theme")).show();
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
        Button loginButton = new Button("S'inscrire");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
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
                Dialog.show("Conf", "Email 123456", "ok",null); 
            }
            if(verif){
                us.Register(username.getText(), email.getText(), password.getText());
            }
               new LoginForm(theme).show();
           
        });
        

        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        Container by = BoxLayout.encloseY(

                spaceLabel,
                BorderLayout.center(username).
                        add(BorderLayout.WEST, userIcon),
                BorderLayout.center(email).
                        add(BorderLayout.WEST, emailIcon),
                
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                BorderLayout.center(password2).
                        add(BorderLayout.WEST, pwdIcon),
                loginButton

        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
