

import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.maps.MapComponent;
import com.codename1.maps.layers.PointLayer;
import com.codename1.maps.layers.PointsLayer;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import java.io.IOException;

/**
 *
 * @author Mahdi
 */
public class Map extends Form {
    
    private Coord lastLocation;
    Form current;
    public Map(Form previous){
    
        setLayout(new BorderLayout());
        setScrollable(false);
        MapComponent mc = new MapComponent();
        mc.zoomToLayers();
        
        addComponent(BorderLayout.CENTER, mc);
        putMeOnMap(mc);
        
         getToolbar().addCommandToLeftBar("Home", null, ev->{
         previous.showBack();
        });
        
    }
    
    private void putMeOnMap(MapComponent map) {
        try {
            Location loc = LocationManager.getLocationManager().getCurrentLocation();
            lastLocation = new Coord(loc.getLatitude(), loc.getLongtitude());
//            Image i = Image.createImage("/com/gui/blue_pin.png");
            PointsLayer pl = new PointsLayer();
//            pl.setPointIcon(i);
            PointLayer p = new PointLayer(lastLocation, "You Are Here",null);
            p.setDisplayName(true);
            pl.addPoint(p);
            pl.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
                    PointLayer p = (PointLayer) evt.getSource();
                    System.out.println("pressed " + p);

                    Dialog.show("Details", "You Are Here" + "\n" + p.getLatitude() + "|" + p.getLongitude(), "Ok", null);
                }
            });
            map.addLayer(pl);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
