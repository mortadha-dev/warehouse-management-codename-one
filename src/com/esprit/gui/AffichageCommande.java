/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;


import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Commande;
import com.esprit.Service.ServiceCommande;
import java.util.ArrayList;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;
/**
 *
 * @author I.O.I
 */


/**
 *
 * @author bhk
 */
public class AffichageCommande extends SideMenuBaseForm  {

    Form f;
    TextArea lb;
    TextField t2 ;
   Resources current;
    public AffichageCommande(Resources res) {
         f = new Form();       
        lb = new TextArea("");
       
       
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "round-mask.png");
        profilePicLabel.setMask(mask.createMask());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
  

        f.setTitle("Liste des Commandes");
         f.add(profilePicLabel);
        f.setLayout(BoxLayout.y());
        //f.add(lb);
        ServiceCommande serviceTask=new ServiceCommande();
        ArrayList<Commande> lis=serviceTask.getList2();
        Container y = new Container(BoxLayout.y()); 
       
        for (Commande a : lis) {
        Container h= new Container(BoxLayout.y());
         Container b = new Container(BoxLayout.x());
         t2= new TextField("","Veuillez saisir le prix Unitaire");           
         Button btnSupp = new Button("Refuser");
         Button btnupdate = new Button("Accepter");         
         lb=new TextArea("");
 lb.setText( "\nlibelle de la commande :"+a.getLibellecommade()+ "\nQuantité commandée :"+ a.getQuantitecommande()+"\nNom du produit "+a.getDescription());
    
 Container content = BoxLayout.encloseY(
        lb,t2
         
 );
  Container haha = BoxLayout.encloseX(
        btnSupp,btnupdate     
 );
            y.add(content);
            y.add(haha);
            
         btnSupp.addActionListener((ActionListener) (ActionEvent evt1) -> {
         System.out.println(a.getId());
         serviceTask.refusCommande(a);
         Dialog.show("Ok", "Vous allez refuser la commande", "Ok", null);
         AffichageCommande f5;
          
                f5 = new AffichageCommande(res);
           
         f5.getF().show();
         });
           btnupdate.addActionListener((ActionListener) (ActionEvent evt1) -> {
           String p = t2.getText();
           a.setPrixUnitaire("20");
           new ServiceCommande().accepteCommande(a);
       
         AffichageCommande f5;
           
                f5 = new AffichageCommande(res);

         Dialog.show("Ok", "Vous avez accepté la commande", "Ok", null);
         f5.getF().show();
         });
           
        }
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
//          });
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
