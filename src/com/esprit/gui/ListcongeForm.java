/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Conge;
import com.esprit.Service.ListcongeService;
import com.esprit.myapp.Session;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ListcongeForm extends SideMenuBaseForm{

    Form f;
    TextArea lb;
    TextField t2 ;
    Resources current;
//  Resources res;
    public ListcongeForm(Resources res) {
        super(BoxLayout.y());
         f = new Form();
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
                                new Label(" Les Clubs ", "Title")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);

      
        Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EmployesForm(UIManager.initFirstTheme("/theme")).show();
                }
            });

        setupSideMenu(res);

        f.setTitle("Liste des Congé");
        f.setLayout(BoxLayout.y());
//        f.add(lb);
        ListcongeService serviceTask=new ListcongeService();
        ArrayList<Conge> listFabs=serviceTask.getListEvent();
    
        Container y = new Container(BoxLayout.y()); 
       
        for (Conge a : listFabs) {
        Container h= new Container(BoxLayout.y());
         Container b = new Container(BoxLayout.x());
                
        lb=new TextArea("");
        lb.setText( "\nid du congé :"+a.getIdconge()+ "\nRaison congé  :"+ a.getRaison()+ "\nDate debut  :"+ a.getDatedebut()+"\nDate fin  :"+ a.getDatefin()+"\n Etat du congé  :"+a.getEtat());
    
        Container content = BoxLayout.encloseY(lb);
        Container haha = BoxLayout.encloseX();
            y.add(content);
            y.add(haha);          }
          f.add(y);
          
          
      
          Toolbar T2 = f.getToolbar();
          T2.addMaterialCommandToRightBar(" ", FontImage.MATERIAL_ADD, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
//                    new DemanderForm(UIManager.initFirstTheme("/theme")).show()
                             DemanderForm d = new DemanderForm(res);
           d.getF().show()
                            ;
                }
            });
          

    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
     @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
}
     
        
