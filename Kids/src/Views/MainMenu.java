package Views;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;

public class MainMenu extends Form
{
    private Button EventBtn;
    private Button PediatBtn;
    private Button EstablishBtn;
    private Button VaccinBtn;

    public MainMenu() {
        InitInterface();
    }

    public MainMenu(Layout contentPaneLayout) {
        super(contentPaneLayout);
        InitInterface();
    }

    public MainMenu(String title) {
        super(title);
        InitInterface();
    }

    public MainMenu(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
        InitInterface();
    }
    
    private void InitInterface()
    {    
        EventBtn = new Button("Events");
        PediatBtn = new Button("pediatrician");
        EstablishBtn = new Button("Establishments");
        VaccinBtn = new Button ("Vaccins");
        
        
        EventBtn.setUIID("ButonMenuStyle");
        PediatBtn.setUIID("ButonMenuStyle");
        EstablishBtn.setUIID("ButonMenuStyle");
        VaccinBtn.setUIID("ButonMenuStyle");
        
        
        EventBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ADD_ALERT, EventBtn.getUnselectedStyle()));
        PediatBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PEOPLE, EventBtn.getUnselectedStyle()));
        EstablishBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_ADD_LOCATION, EventBtn.getUnselectedStyle()));
        VaccinBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_HELP, EventBtn.getUnselectedStyle()));

        
        
        add(EventBtn);
        add(PediatBtn);
        add(EstablishBtn);
        add(VaccinBtn);
    }
    
}
