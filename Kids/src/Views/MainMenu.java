package Views;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.Layout;

public class MainMenu extends Form
{
    private Button EventBtn;
    private Button PediatBtn;

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
        getToolbar().addCommandToLeftBar("Left", null, (e) -> Log.p("Clicked"));
        getToolbar().addCommandToRightBar("Right", null, (e) -> Log.p("Clicked"));
        getToolbar().addCommandToOverflowMenu("Overflow", null, (e) -> Log.p("Clicked"));
        getToolbar().addCommandToSideMenu("Sidemenu", null, (e) -> Log.p("Clicked"));
        getContentPane().setLayout(new GridLayout(3, 2));
        
        EventBtn = new Button("Events");
        PediatBtn = new Button("pediatrician");
        
        add(EventBtn);
        add(PediatBtn);
    }
}
