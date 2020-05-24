/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Service.RatingWidget;
import com.esprit.Service.ServiceCommande;


/**
 *
 * @author I.O.I
 */


/**
 *
 * @author bhk
 */
public class AffichageWidget {

    Form f;
    SpanLabel lb;
    Resources current ; 
    
    
    
    public AffichageWidget(Resources res) {
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "debouu.png");
        profilePicLabel.setMask(mask.createMask());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);

         
        f = new Form();
         f.setTitle("Rating");
          f.setLayout(BoxLayout.y());
         f.add(profilePicLabel); 
        lb = new SpanLabel("");
        //f.add(lb);
         Container y = new Container(BoxLayout.y());
         Container j = new Container(BoxLayout.x());
         Container k = new Container(BoxLayout.y());
         Container o = new Container(BoxLayout.x());
              
                
        Button btnAfficher = new Button("Noter");

            
               Container con = new Container();
               lb=new SpanLabel("");
              lb.setText( " vous pouvez donnez votre avis par rapport notre entrepot");
              
         btnAfficher.addActionListener((ActionListener) (ActionEvent evt1) -> {
         RatingWidget f3=new RatingWidget();
         f3.showReviewWidget();
         });        
               j.add(lb);       
               o.add(btnAfficher);
               k.add(j);
               k.add(o);            
               y.add(k);           
               f.add(y);
                 Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new MortadhaForm(UIManager.initFirstTheme("/theme")).show();
                }
            });
          
//          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
//          h.getF().show();
//                   
//          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
