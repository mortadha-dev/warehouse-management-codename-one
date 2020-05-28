/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Service.UserService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.myapp.Session;
//import com.esprit.myapp.Session;



/**
 *
 * @author HP
 */



public class LoginForm extends Form{
   
public LoginForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
       
        Container welcome = FlowLayout.encloseCenter(
                new Label("Bienvenue , ", "WelcomeWhite"),
                new Label("DEBOU", "WelcomeBlue")
              
        );
        
         getTitleArea().setUIID("Container");
         
//          Image deboupic=theme.getImage("debouu.png") ;
//          Image mask = theme.getImage("round-mask.png");
//          deboupic = deboupic.fill(mask.getWidth(), mask.getHeight());
//          Label deboupicLabel = new Label(deboupic, "deboupic");
//          deboupicLabel.setMask(mask.createMask());
//          Image profilePic = theme.getImage("user-picture.jpg");


        Image profilePic = theme.getImage("debouu.png");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());
          
//        Image profilePic = theme.getImage("user-picture.jpg");
//        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
//        Label profilePicLabel = new Label(profilePic, "ProfilePic");
//        profilePicLabel.setMask(mask.createMask());
        
        TextField login = new TextField("", "Nom", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Mot de passe", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button loginButton = new Button("S'IDENTIFIER");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
            UserService su = new UserService();
            su.login(login.getText(), password.getText());
            if (Session.isCnx()) {
                System.out.println("Enter YES LOGIN");
               new EmployesForm(theme).show();
            }
               else if( (login.getText().length()==0) ){
                       System.out.println("Veuillez saisir votre nom");
                      Dialog.show("Alerte", "Veuillez saisir votre nom", "ok", null);
                       
                       }
            else if( (password.getText().length()==0) ){
                       System.out.println("Veuillez saisir votre mot de passe");
                      Dialog.show("Alerte", "Veuillez saisir votre mot de passe", "ok", null);
                       
                       }
            
            

        });
        
        Button createNewAccount = new Button("CRÉER UN NOUVEAU COMPTE");
        createNewAccount.setUIID("CreateNewAccountButton");
        
        createNewAccount.addActionListener((evt) -> {
            new RegisterForm(theme).show();
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
                profilePicLabel,
//                deboupicLabel,
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton,
                createNewAccount
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
   
}
