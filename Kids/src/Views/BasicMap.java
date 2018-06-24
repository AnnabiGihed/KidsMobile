/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.codename1.googlemaps.MapContainer;
import com.codename1.googlemaps.MapContainer.MarkerOptions;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author annab
 */
//Map Key : AIzaSyDYsqMv3kobxelZdNeQz2V-b5uKqP5WiyE
public class BasicMap extends Form {

    private Form preForm;
    double longi;
    double latit;
    final MapContainer cnt = new MapContainer("AIzaSyDYsqMv3kobxelZdNeQz2V-b5uKqP5WiyE");

    public BasicMap(double longi, double latit) {
        this.longi = longi;
        this.latit = latit;
        Initialize();
    }

    public BasicMap(Layout contentPaneLayout) {
        super(contentPaneLayout);
        Initialize();
    }

    public BasicMap(String title) {
        super(title);
        Initialize();
    }

    public BasicMap(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
        Initialize();
    }

    private void Initialize() {
        setLayout(new BorderLayout());

        Style s = new Style();
        s.setFgColor(0xff0000);
        s.setBgTransparency(0);
        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(3));

        Button btnAddPath = new Button("Add Path");
        btnAddPath.addActionListener(e
                -> {
            MarkerOptions lmo = new MarkerOptions(new Coord(latit, longi), markerImg.toEncodedImage());
            cnt.addMarker(lmo);
            cnt.setCameraPosition(new Coord(latit, longi));
        });

        Button btnClearAll = new Button("Clear All");
        btnClearAll.addActionListener(e -> {
            cnt.clearMapLayers();
        });
        Container root = LayeredLayout.encloseIn(
                BorderLayout.center(cnt),
                BorderLayout.south(
                        FlowLayout.encloseBottom(btnAddPath, btnClearAll)
                )
        );

        add(BorderLayout.CENTER, root);
        
        Style ss = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, ss);
        getToolbar().addCommandToLeftBar("", icon, (e) -> preForm.showBack());
    }

    public Form getPreForm() {
        return preForm;
    }

    public void setPreForm(Form preForm) {
        this.preForm = preForm;
    }
    
}
