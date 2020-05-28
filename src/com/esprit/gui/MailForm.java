/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author HP
 */

    public class MailForm extends SideMenuBaseForm{
     Form f;
    SpanLabel lb;
   Resources theme   ;
    Resources current;
    public MailForm(Resources res) {
        
       super(BoxLayout.y());
        
        f = new Form();
        
         Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image eventPic = res.getImage("BackgroundRect.png");
        Image profilePic = res.getImage("debouu.png");
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
                                new Label(" Contact ", "Title")
                        )
                )
        );
        
            Toolbar T1 = f.getToolbar();
          T1.addMaterialCommandToLeftBar(" ", FontImage.MATERIAL_KEYBOARD_BACKSPACE, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new EmployesForm(UIManager.initFirstTheme("/theme")).show();
                }
            });
        
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
        
          
        lb = new SpanLabel("Contacter le responsable des ressources humaines de l'entrepôt");
        add(lb);
      
         Container y = new Container(BoxLayout.y());
        //lb.setText(lis.toString());
        Container c= new Container(BoxLayout.y());

       Container g= new Container(BoxLayout.y());

        TextField body= new TextField("","description",150,50);

       TextField title = new TextField("","Titre",50,0);

            Button send = new Button("Envoyer un mail");
         

               Container con = new Container();
               
              
         
         send.addActionListener((ActionListener) (ActionEvent evt1) -> {
         
         Message m = new Message(body.getText());
           
            m.setMimeType(Message.MIME_HTML);
           m.getAttachments().put(body.getText(), "text/plain");
          Display.getInstance().sendMessage(new String[] {"mariem.mahfoudh@esprit.tn"}, title.getText(), m);
         
         });   c.add(title);
               c.add(body);
         
           //    j.add(imgv);
               
               c.add(send);
                
               
             g.add(c);
              add(g);
              
              
         
    
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
