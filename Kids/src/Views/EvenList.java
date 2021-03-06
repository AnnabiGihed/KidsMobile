package Views;

import Entities.Event;
import Services.EventService;
import Services.VaccinService;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
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


public class EvenList extends Form{

    Label idLabel;
    Label EventNameLB;
    Label DescriptionLB;
    Label DateLabel;
    Label EstablishementLabel;
    Label priceLabel;
    Button PhoneNumber;
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
        this.setTitle("Liste des Event");
        this.setLayout(new FlowLayout());
        Label separator = new Label("", "BlueSeparatorLine");

        EventService EvService = new EventService();
        ArrayList<Event> EvList = EvService.GetAllEvents();
        Container ContainerEvent = new Container(BoxLayout.y());
        for (Event CurrentEvent: EvList) 
        {
            Label iconInjection = new Label();
            iconInjection.setTextPosition(Component.RIGHT);
            iconInjection.setUIID("iconInjection");
            iconInjection.setShowEvenIfBlank(true);

            Button FurtherDetails = new Button(CurrentEvent.getName());
            Container c = new Container(new BorderLayout());
            
            idLabel = new Label(String.valueOf(CurrentEvent.getID()));
            idLabel.setUIID("IdLabel");
            
            EventNameLB = new Label(CurrentEvent.getName());
            EventNameLB.setUIID("EventNameLB");
            
            DateLabel = new Label(CurrentEvent.getM_Date().toString());
            DateLabel.setUIID("DateLabel");
            
            DescriptionLB = new Label("Description : " + String.valueOf(CurrentEvent.getDescription()));
            DescriptionLB.setUIID("DescriptionLB");
            
            EstablishementLabel = new Label("Establishement : " + String.valueOf(CurrentEvent.getM_Establishment().getName()));
            EstablishementLabel.setUIID("IdLabel");
            
            PhoneNumber = new Button("Call");
            PhoneNumber.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Display.getInstance().dial(CurrentEvent.getPhoneNumber());
     
                }
            });
            ShowOnMap = new Button("Show On Map");
            BasicMap Map = new BasicMap (CurrentEvent.getM_Establishment().getM_Address().getLatitude(),CurrentEvent.getM_Establishment().getM_Address().getLatitude());
            Map.setPreForm(this);
            ShowOnMap.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Map.show();
                }
            });
            

            ContainerEvent.add(c);
            ContainerEvent.add(EventNameLB);
            ContainerEvent.add(DateLabel);
            ContainerEvent.add(DescriptionLB);
            ContainerEvent.add(EstablishementLabel);
            ContainerEvent.add(PhoneNumber);
            ContainerEvent.add(ShowOnMap);
            ContainerEvent.add("______________________________");

        }
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, s);
        getToolbar().addCommandToLeftBar("", icon, (e) -> PreviousForm.showBack());
        add(ContainerEvent);
    }
    
    

     public EvenList(String title, Form PreviousForm) 
    {
        super(title);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public EvenList(Layout contentPaneLayout, Form PreviousForm) 
    {
        super(contentPaneLayout);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public EvenList(String title, Layout contentPaneLayout, Form PreviousForm ) 
    {
        super(title, contentPaneLayout);
        this.PreviousForm = PreviousForm;
        InitInterface();
    }

    public EvenList() {
       
    }
}
