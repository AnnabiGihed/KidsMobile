/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.codename1.googlemaps.MapContainer;
import com.codename1.maps.Coord;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author annab
 */

    //Map Key : AIzaSyDYsqMv3kobxelZdNeQz2V-b5uKqP5WiyE
public class BasicMap extends Form
{

    public BasicMap() 
    {
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
    
    private void Initialize()
    {
        setLayout(new BorderLayout());
        final MapContainer cnt = new MapContainer("AIzaSyDYsqMv3kobxelZdNeQz2V-b5uKqP5WiyE");

        Style s = new Style();
        s.setFgColor(0xff0000);
        s.setBgTransparency(0);
        FontImage markerImg = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(3));

        Button btnAddPath = new Button("Add Path");
        btnAddPath.addActionListener(e->{

            cnt.addPath(
                    cnt.getCameraPosition(),
                    new Coord(-33.866, 151.195), // Sydney
                    new Coord(-18.142, 178.431),  // Fiji
                    new Coord(21.291, -157.821),  // Hawaii
                    new Coord(37.423, -122.091)  // Mountain View
            );
        });

        Button btnClearAll = new Button("Clear All");
        btnClearAll.addActionListener(e->{
            cnt.clearMapLayers();
        });

//        cnt.addTapListener(e->{
//            TextField enterName = new TextField();
//            Container wrapper = BoxLayout.encloseY(new Label("Name:"), enterName);
//            InteractionDialog dlg = new InteractionDialog("Add Marker");
//            dlg.getContentPane().add(wrapper);
//            enterName.setDoneListener(e2->{
//                String txt = enterName.getText();
//                cnt.addMarker(
//                        EncodedImage.createFromImage(markerImg, false),
//                        cnt.getCoordAtPosition(e.getX(), e.getY()),
//                        enterName.getText(),
//                        "",
//                        e3->{
//                                ToastBar.showMessage("You clicked "+txt, FontImage.MATERIAL_PLACE);
//                        }
//                );
//                dlg.dispose();
//            });
//            dlg.showPopupDialog(new Rectangle(e.getX(), e.getY(), 10, 10));
//            enterName.startEditingAsync();
//        });

        Container root = LayeredLayout.encloseIn(
                BorderLayout.center(cnt),
                BorderLayout.south(
                        FlowLayout.encloseBottom(btnAddPath, btnClearAll)
                )
        );

        add(BorderLayout.CENTER, root);
    }
}
