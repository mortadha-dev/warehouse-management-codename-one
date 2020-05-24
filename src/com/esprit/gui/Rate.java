/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Livreur;
import com.esprit.Service.ServiceLivreur;
import com.esprit.Service.haha;
import java.util.ArrayList;

/**
 *
 * @author Mahdi
 */
public class Rate  extends Form {
 public ArrayList<Livreur> livreur;
 Form f ; 
     
    public Rate(Form previous) {
       String listliv = "";
        setTitle("Notez nos Livreurs");
         setLayout(BoxLayout.y());
         SpanLabel sp = new SpanLabel();
       
        Container c =new Container();
         livreur = ServiceLivreur.getInstance().getAllLivraison();
         
         
          for (Livreur n : livreur) {

            listliv = listliv  + n.getNomliv()+"\n" ;
             Button btnrate = new Button("rate");
              btnrate.addActionListener((evt) -> {
                  
           
            haha f3=new haha();
           f3.showReviewWidget();
           btnrate.remove();
       });
              add(btnrate);
               
        }
           add(sp);
       
             sp.setText(listliv);
         
  
           getToolbar().addCommandToLeftBar("Back", null, ev->{
         previous.showBack();
        });

    }
       public Form getF() {
        return f;
    }
    
    public void setF(Form f) {
        this.f = f;
    }
    
    
    
   
    
}
