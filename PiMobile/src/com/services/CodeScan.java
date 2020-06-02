/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;



import com.codename1.ui.Button;

import com.codename1.ui.Container;

import com.codename1.ui.Form;
import com.codename1.ui.Label;

import com.codename1.ext.codescan.CodeScanner;
import com.codename1.ext.codescan.ScanResult;



/**
 *
 * @author Mahdi
 */
public class CodeScan extends Form {
     
    public CodeScan(Form previous) {
//        final Form hi = new Form("Codescan Demo");
         setTitle("scan");
         Button scanBtn = new Button("Scan");
          
          getToolbar().addCommandToLeftBar("Home", null, ev->{
         previous.showBack();
        });
         
         scanBtn.addActionListener((evt) -> {
             final Container cnt = this;
             
             CodeScanner.getInstance().scanQRCode(new ScanResult() {

                        public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
                            //barCode.setText("Bar: " + contents);
                            cnt.addComponent(new Label(contents));
                            cnt.revalidate();
                        }

                        public void scanCanceled() {
                            System.out.println("cancelled");
                        }

                        public void scanError(int errorCode, String message) {
                            System.out.println("err " + message);
                        }
                    });

            
             
         });
         
 add(scanBtn);
    
}
}