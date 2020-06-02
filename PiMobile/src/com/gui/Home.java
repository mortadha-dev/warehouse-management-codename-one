/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.services.CodeScan;





/**
 *
 * @author Mahdi
 */
public class Home extends Form {

    Form current;

    public Home() {
        current = this;

// final Form home = new Form("Home");
        setTitle("Gestion des livraison");
        setLayout(BoxLayout.y());
        Button afficheBtn = new Button("Livraison");
        Button scanBtn = new Button("Scan qr code");
         Button mapBtn = new Button("Map");
         Button rateBtn = new Button("Rate");
        
         afficheBtn.addActionListener((evt) -> {
             new ListLivraisonForm(current).show();
         });
        
        
        scanBtn.addActionListener((evt) -> {
            new CodeScan(current).show();
            
        });
        mapBtn.addActionListener((evt) -> {
            
            new Map(current).show();
        });
        
         rateBtn.addActionListener((evt) -> {
             new Rate(current).show();
         });
        
        
        
        add(scanBtn);
        add(afficheBtn);
        add(mapBtn);
         add(rateBtn);
    }
    
}
