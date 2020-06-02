/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.entities.Livreur;
import com.services.ServiceLivreur;
import java.util.ArrayList;

/**
 *
 * @author Mahdi
 */
public class Rate  extends Form {
 public ArrayList<Livreur> livreur=ServiceLivreur.getInstance().getAllLivraison();
 
  SpanLabel sp = new SpanLabel();
   Button btnrate = new Button("rate"); 
 public Container adlivreur (Livreur liv)
             
         {
         Container cnt = new  Container(BoxLayout.y());
         sp.setText(liv.getNomliv());
         cnt.add(sp);
         cnt.add(btnrate);        
         return cnt;
         }
 
 
 
    public Rate(Form previous) {
       String listliv = "";
        setTitle("Notez nos fournisseurs");
         setLayout(BoxLayout.y());
         SpanLabel sp = new SpanLabel();
        Button btnrate = new Button("rate"); 
        
        
//         livreur = ServiceLivreur.getInstance().getAllLivraison();
        
//         Container cnt = new Container(BoxLayout.y());
//         cnt.add(sp);
//         cnt.add(btnrate);
//         

          for (Livreur n : livreur) {
         
            listliv = listliv  + n.getNomliv()+"\n" ;
//             add(adlivreur(n));
            
        }



          sp.setText(listliv);

//         sp.setText(ServiceLivreur.getInstance().getAllLivraison().toString());
        
        
       btnrate.addActionListener((evt) -> {
           
            haha f3=new haha();
           f3.showReviewWidget();
           btnrate.remove();
       });
       
        getToolbar().addCommandToLeftBar("Home", null, ev -> {
            previous.showBack();
        });
        
        
         
//        add(cnt);
                  add(sp);
                 add(btnrate);


                 

    }
    
    
    
    
   
    
}
