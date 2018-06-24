package Views;

import Entities.Pediatrician;
import Services.PediatricianService;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.util.ArrayList;

public class PediatrcianList extends Form {

    Label idLabel;
    Label PDNameLB;
    Label SpecialityLB;
    Label AddressLabel;
    Label RatingLabel;
    Label priceLabel;
    Label PriceLabel;
    Form PreviousForm;
    Button ShowOnMap;

    private Label createSeparator() {
        Label sep = new Label();
        sep.setTextPosition(Component.RIGHT);
        sep.setUIID("Separator");
        sep.setShowEvenIfBlank(true);
        return sep;
    }

    public void InitInterface() 
    {
        this.setTitle("Liste des Pediatrcian");
        this.setLayout(new FlowLayout());
        Label separator = new Label("", "BlueSeparatorLine");

        PediatricianService PdService = new PediatricianService();
        ArrayList<Pediatrician> PdList = PdService.GetAllPediatrician();
        Container ContainerEvent = new Container(BoxLayout.y());
        for (Pediatrician CurrentPediatrician : PdList) {
            Label iconInjection = new Label();
            iconInjection.setTextPosition(Component.RIGHT);
            iconInjection.setUIID("iconInjection");
            iconInjection.setShowEvenIfBlank(true);

            Button FurtherDetails = new Button(CurrentPediatrician.getName());
            Container c = new Container(new BorderLayout());

            idLabel = new Label(String.valueOf(CurrentPediatrician.getID()));
            idLabel.setUIID("IdLabel");

            PDNameLB = new Label(CurrentPediatrician.getName());
            PDNameLB.setUIID("PDNameLB");

            SpecialityLB = new Label("Speciality : " + String.valueOf(CurrentPediatrician.getM_Speciality().getName()));
            SpecialityLB.setUIID("SpecialityLB");

            AddressLabel = new Label("Address : " + String.valueOf(CurrentPediatrician.getM_Adresss().getRue()));
            AddressLabel.setUIID("AddressLabel");

            RatingLabel = new Label("Rating : " + String.valueOf(CurrentPediatrician.getRating().getRate()));
            RatingLabel.setUIID("RatingLabel");

            PriceLabel = new Label("Price : " + String.valueOf(CurrentPediatrician.getRating().getRate()));
            PriceLabel.setUIID("PriceLabel");
            
            ShowOnMap = new Button("ShowOnMap");
            BasicMap Map = new BasicMap (CurrentPediatrician.getM_Adresss().getLatitude(),CurrentPediatrician.getM_Adresss().getLatitude());
            Map.setPreForm(this);
            ShowOnMap.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Map.show();
                }
            });

            ContainerEvent.add(c);
            ContainerEvent.add(PDNameLB);
            ContainerEvent.add(PriceLabel);
            ContainerEvent.add(RatingLabel);
            ContainerEvent.add(SpecialityLB);
            ContainerEvent.add(AddressLabel);
            ContainerEvent.add(ShowOnMap);
            ContainerEvent.add("______________________________");
        }
        
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, s);
        getToolbar().addCommandToLeftBar("", icon, (e) -> PreviousForm.showBack());
        add(ContainerEvent);
    }

    public PediatrcianList(String title, Form PreviousForm) {
        super(title);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public PediatrcianList(Layout contentPaneLayout, Form PreviousForm) {
        super(contentPaneLayout);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public PediatrcianList(String title, Layout contentPaneLayout, Form PreviousForm) {
        super(title, contentPaneLayout);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public PediatrcianList() {

    }
}
