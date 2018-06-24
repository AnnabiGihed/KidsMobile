package Views;

import Entities.Event;
import Services.EventService;
import Services.VaccinService;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.Layout;
import java.util.ArrayList;


public class EvenList extends Form{

    Label idLabel;
    Label EventNameLB;
    Label DescriptionLB;
    Label DateLabel;
    Label EstablishementLabel;
    Label priceLabel;
    VaccinService vservice = new VaccinService();
    
    
    private Label createSeparator() {
        Label sep = new Label();
        sep.setTextPosition(Component.RIGHT);
        sep.setUIID("Separator");
        sep.setShowEvenIfBlank(true);
        return sep;
    }
    

 public Form InitInterface()
    {
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
            
            ContainerEvent.add(c);
            ContainerEvent.add(EventNameLB);
            ContainerEvent.add(DateLabel);
            ContainerEvent.add(DescriptionLB);
            ContainerEvent.add(EstablishementLabel);
            ContainerEvent.add("______________________________");
        }
        Form f = new Form("Liste des Event", new FlowLayout());
        f.add(ContainerEvent);
        return f;
    }
    
    

     public EvenList(String title) 
    {
        super(title);
        InitInterface();
    }

    public EvenList(Layout contentPaneLayout) 
    {
        super(contentPaneLayout);
        InitInterface();
    }

    public EvenList(String title, Layout contentPaneLayout) 
    {
        super(title, contentPaneLayout);
        InitInterface();
    }

    public EvenList() {
       
    }
}
