/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.codename1.l10n.DateFormatPatterns;
import com.codename1.l10n.DateFormatSymbols;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author HP
 */
public class DemandecongeForm extends Form{
        public DemandecongeForm(Form previous) {
        setTitle("Demande Congé");
        setLayout(BoxLayout.y());
        SimpleDateFormat date = new SimpleDateFormat();
        DateFormatSymbols date3= new DateFormatSymbols()  ; 
        DateFormatPatterns date1 = new DateFormatPatterns();
        TextField tfRaison = new TextField("","Raison");
        TextField tfDatedebut= new TextField("", "Date debut");
        TextField tfDatefin= new TextField("", "Date fin");
        Button btnEnvoyer = new Button("Envoyer");
        btnEnvoyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if( (tfRaison.getText().length()==0 ) ||(tfRaison.getText().length()<4 ) ){
                      System.out.println("Veuillez remplir tous les champs");
                      Dialog.show("Alerte", "Veuillez remplir tous les champs", "ok", null);; }
//                 if (tfRaison.getText().length()==0)||(tfStatus.getText().length()==0)
//                         Dialog.show("Alert", body, new Command("OK"));
//                         Dialog.show("Alert", "Veuillez remplir tous les champs", new Command("OK"));
//                else
//                {
//                    try {
//                        Task t = new Task(Integer.parseInt(tfStatus.getText()), tfName.getText());
//                        if( ServiceTask.getInstance().addTask(t))
//                            Dialog.show("Success","Connection accepted",new Command("OK"));
//                        else
//                            Dialog.show("ERROR", "Server error", new Command("OK"));
//                    } catch (NumberFormatException e) {
//                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
//                    }
//                    
//                } 
                     }
            
        });
        addAll(tfRaison,tfDatedebut,tfDatefin,btnEnvoyer);
      
        }               

   
}

