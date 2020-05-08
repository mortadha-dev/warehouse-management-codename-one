/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.guis;

import com.mycompany.myapp.entities.Commande;
import com.mycompany.myapp.services.ServiceCommande;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
/**
 *
 * @author I.O.I
 */


/**
 *
 * @author bhk
 */
public class AffichageCommande {

    Form f;
    TextArea lb;
    TextField t2 ;
  
    public AffichageCommande() {
        
        f = new Form();
        lb = new TextArea("");
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
 lb.setText( "\nlibelle de la commande :"+a.getLibellecommade()+ "\nQuantité commanded :"+ a.getQuantitecommande());
    
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
         AffichageCommande f5 =new AffichageCommande();
         f5.getF().show();
         });
           btnupdate.addActionListener((ActionListener) (ActionEvent evt1) -> {
           String p = t2.getText();
           a.setPrixUnitaire(p);
           new ServiceCommande().accepteCommande(a);
       
         AjoutOffre f5 =new AjoutOffre();
         Dialog.show("Ok", "Vous avez accepté la commande", "Ok", null);
         f5.getF().show();
         });
           
        }
          f.add(y);
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
