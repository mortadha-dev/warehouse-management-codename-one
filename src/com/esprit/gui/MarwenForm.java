
package com.esprit.gui;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.Entities.Conge;


/**
 * Represents a user profile in the app, the first form we open after the
 * walkthru
 *
 * @author HP
 */
public class MarwenForm extends SideMenuBaseForm {
        Form f;
        Conge c =new Conge();
        Resources theme   ;
        Form current ; 
    public MarwenForm(Resources res) {
         super(BoxLayout.y());
        current = this ; 
    
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
                                new Label(" Service Livraison ", "Title")
                        )
                )
        );
        tb.setTitleComponent(titleCmp);
        setupSideMenu(res);
        Button hihi = new Button( "Livraison");
        Button btnprofil = new Button("Scan QR Code");
        Button btndemandeconge = new Button("Map");
        Button Listconge = new Button("Rate");
        
        Button logout = new Button("Se déconnecter ");
         
        hihi.addActionListener((evt) -> {
           ListLivraisonForm d = new ListLivraisonForm(res);
           d.getF().show();
        });
        
        btndemandeconge.addActionListener((evt) -> {
            //new Map(current).show();
         
        });
                logout.addActionListener(e-> new LoginForm(res).show());


        
         Listconge.addActionListener((evt) -> {

            // new Rate(current).show();
         });
         
           btnprofil.addActionListener((evt) -> {
           // new CodeScan(current).show();
           });
                   
        addAll(hihi,btnprofil,btndemandeconge,Listconge,logout);
//        getToolbar().addCommandToLeftBar("Home", null, ev -> {
//            previous.showBack();
//        });
              
 
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

