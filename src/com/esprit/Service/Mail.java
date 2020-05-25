/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.gui.EmployesForm;
import com.esprit.gui.MortadhaForm;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;

/**
 *
 * @author achraf
 */
public class Mail {
     Form f;
    SpanLabel lb;
    Resources current;
  
    public Mail(Resources res) {
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
  
        f = new Form();
        f.add(profilePicLabel);
        
       
        f.setTitle("Contact du Responsable");
        f.setLayout(BoxLayout.y());
        lb = new SpanLabel("Contacter le responsable d'achat de l'entropot");
        f.add(lb);
      
         Container y = new Container(BoxLayout.y());
        //lb.setText(lis.toString());
        Container c= new Container(BoxLayout.y());

       Container g= new Container(BoxLayout.y());

        TextField body= new TextField("","description",150,50);

       TextField title = new TextField("","title",50,0);

            Button send = new Button("Send Mail");
         

               Container con = new Container();
 
               
         send.addActionListener((ActionListener) (ActionEvent evt1) -> {
         
         Message m = new Message(body.getText());
           
            m.setMimeType(Message.MIME_HTML);
           m.getAttachments().put(body.getText(), "text/plain");
          Display.getInstance().sendMessage(new String[] {"bouallagumortadha@gmail.com"}, title.getText(), m);
         
         });   c.add(title);
               c.add(body);
         
           //    j.add(imgv);
               
               c.add(send);
                
               
             g.add(c);
              f.add(g);
              TextField sms=new TextField();
        Button envoyer = new Button("envoyer sms");
        envoyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    NexmoClient client = new NexmoClient.Builder()
                            .apiKey("50e05289")
                            .apiSecret("gQbMVGhUMxvYM3BE")
                            
                            .build();              
                    String messageText = sms.getText();
                    TextMessage message = new TextMessage("AcmeInc", "+21628606573", messageText);                   
                   // SmsSubmissionResponse response = null;                 
                 SmsSubmissionResponse   response = client.getSmsClient().submitMessage(message);
                    for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
                        System.out.println(responseMessage);
                    }   
                    System.out.println(messageText);
                }
                catch (IOException ex) {                                 
                   
                } catch (NexmoClientException ex) {
                   
                }
                                
            }
        });
        f.add(sms);
          f.add(envoyer);
            Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new MortadhaForm(UIManager.initFirstTheme("/theme")).show();
                }
            });
          
         
    }
    
    
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
