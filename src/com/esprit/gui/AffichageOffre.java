/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

/**
 *
 * @author admin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.codename1.components.SpanLabel;
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
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Commande;
import com.esprit.Entities.Conge;
import com.esprit.Entities.Offre;
import com.esprit.Service.ListcongeService;
import com.esprit.Service.ServiceCommande;
import com.esprit.Service.ServiceOffre;
import java.util.ArrayList;
/**
 *
 * @author I.O.I
 */


/**
 *
 * @author bhk
 */
public class AffichageOffre extends SideMenuBaseForm {

    Form f;
    TextArea lb;
    TextField t2 ;
    SpanLabel pp ;    
    Resources current;
   
    public AffichageOffre(Resources res) {
        super(BoxLayout.y());
         f = new Form();
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "debouu.png");
        profilePicLabel.setMask(mask.createMask());
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label(" Les Clubs ", "Title")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);

      
        

        setupSideMenu(res);

        f.setTitle("Liste des offres");
        f.setLayout(BoxLayout.y());
         f.add(profilePicLabel);
//        f.add(lb);
        ServiceOffre serviceoffre=new ServiceOffre();
        ArrayList<Offre> listFabs=serviceoffre.getList2();
    
        Container y = new Container(BoxLayout.y()); 
       
        for (Offre a : listFabs) {
        Container h= new Container(BoxLayout.y());
         Container b = new Container(BoxLayout.x());
         Button btnSupp = new Button("Supprimer");
         Button btnupdate = new Button("Modifier");
          t2= new TextField("", "saisir le nouveau délai"); 
                
        lb=new TextArea("");
 lb.setText( "\ncode de l'offre :"+a.getCodeOff()+"\nNom du produit : "+a.getNomProduit()+"\nRéduction : "+a.getReduction()+"%"+ "\ndélai validité :"+ a.getDelaivalidite());
    
        Container content = BoxLayout.encloseY(lb,t2);
        Container haha = BoxLayout.encloseX(btnSupp,btnupdate);
            y.add(content);
            y.add(haha);     
           btnSupp.addActionListener((ActionListener) (ActionEvent evt1) -> {
         System.out.println(a.getId());
         serviceoffre.suppOffre(a);
         Dialog.show("Ok", "Vous allez supprimer la commande", "Ok", null);
         AffichageOffre f5 =new AffichageOffre(res);
         f5.getF().show();
         });
          btnupdate.addActionListener((ActionListener) (ActionEvent evt1) -> {
          String x = t2.getText();
          System.out.println(x);
          a.setDelaivalidite("6 jours");
          new ServiceOffre().modifieroffre(a);      
        // AffichageOffre f5 =new AffichageOffre();
         Dialog.show("Ok", "Vous avez modifié le délai", "Ok", null);
         AffichageOffre f5 =new AffichageOffre(res);
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
          Toolbar T2 = f.getToolbar();
          T2.addMaterialCommandToRightBar(" ", FontImage.MATERIAL_ADD, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
//                    new DemanderForm(UIManager.initFirstTheme("/theme")).show()
                             AjoutOffre d = new AjoutOffre(res);
           d.getF().show()
                            ;
                }
            });
          

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
     
  
        
//        f = new Form();
//        lb = new TextArea("");
//        pp = new SpanLabel("");
//        pp.setText("Liste des offres de promotion");
//        
//        //f.add(lb);
//        ServiceOffre serviceoffre=new ServiceOffre();
//        ArrayList<Offre> lis=serviceoffre.getList2();
//        Container y = new Container(BoxLayout.y()); 
//       
//         for (Offre a : lis) {
//         Container h= new Container(BoxLayout.y());
//         Container b = new Container(BoxLayout.x());
//         t2= new TextField("", "saisir le nouveau délai");           
//         Button btnSupp = new Button("Supprimer");
//         Button btnupdate = new Button("Modifier");         
//               lb=new TextArea("");
// lb.setText( "\ncode de l'offre :"+a.getCodeOff()+"\nNom du produit : "+a.getNomProduit()+"\nRéduction : "+a.getReduction()+"%"+ "\ndélai validité :"+ a.getDelaivalidite());
//    
// Container content = BoxLayout.encloseY(
//        lb,t2
//         
// );
//  Container haha = BoxLayout.encloseX(
//        btnSupp,btnupdate     
// );
//            y.add(content);
//            y.add(haha);
//            
//         btnSupp.addActionListener((ActionListener) (ActionEvent evt1) -> {
//         System.out.println(a.getId());
//         serviceoffre.suppOffre(a);
//         Dialog.show("Ok", "Vous allez supprimer la commande", "Ok", null);
//         AffichageOffre f5 =new AffichageOffre();
//         f5.getF().show();
//         });
//          btnupdate.addActionListener((ActionListener) (ActionEvent evt1) -> {
//          String x = t2.getText();
//          System.out.println(x);
//          a.setDelaivalidite(x);
//          new ServiceOffre().modifieroffre(a);      
//        // AffichageOffre f5 =new AffichageOffre();
//         Dialog.show("Ok", "Vous avez modifié le délai", "Ok", null);
//         //f5.getF().show();
//         });
//          
//        }
//         f.add(pp);
//          f.add(y);
////          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
////          h.getF().show();
////          });
//    }
//
//    public Form getF() {
//        return f;
//    }
//
//    public void setF(Form f) {
//        this.f = f;
//    }
//
//}
//
