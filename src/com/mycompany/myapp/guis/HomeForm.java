/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.guis;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Mail;

/**
 *
 * @author bhk
 */
public class HomeForm {

    Form f;
    TextField tnom;
    TextField tetat;
    Button btnajout,btnaff;

    public HomeForm() {
        f = new Form("home");
        
        
        
          f.getToolbar().addCommandToSideMenu("Afficher les commandes", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
         AffichageCommande f1= new AffichageCommande();
         f1.getF().show();
            }
        });
        f.getToolbar().addCommandToSideMenu("Ajouter une offre a notre enropot ", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AjoutOffre f1= new AjoutOffre();
         f1.getF().show();
            }
            }
        );
            f.getToolbar().addCommandToSideMenu("Consulter la liste des offres ", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                AffichageOffre f1= new AffichageOffre();
         f1.getF().show();
            }
            }
        );
         f.getToolbar().addCommandToSideMenu("Contacter responsable d'achat", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
         Mail f1= new Mail();
         f1.getF().show();
            }
        });
          f.getToolbar().addCommandToSideMenu("Rate notre entropot", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            
         AffichageWidget f1= new AffichageWidget();
         f1.getF().show();
            }}
         );
        
       
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

}
