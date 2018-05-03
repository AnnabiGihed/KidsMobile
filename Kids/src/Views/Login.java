package Views;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;

public class Login extends Form
{
    private Label UserNameLabel;
    private Label UserPasswordLabel;
    
    private TextField UserNameTF;
    private TextField UserPasswordTF;
    
    private Button LoginBTN;

    public Login(String title) 
    {
        super(title);
        InitInterface();
    }

    public Login(Layout contentPaneLayout) 
    {
        super(contentPaneLayout);
        InitInterface();
    }

    public Login(String title, Layout contentPaneLayout) 
    {
        super(title, contentPaneLayout);
        InitInterface();
    }
    
    private void InitInterface()
    {
        getContentPane().setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        UserNameLabel = new Label("UserName");
        UserPasswordLabel = new Label("Password");
        UserNameTF = new TextField("", "UserName");
        UserPasswordTF = new TextField("", "Password");
        LoginBTN = new Button("Login");
        
        add(UserNameLabel);
        add(UserNameTF);
        add(UserPasswordLabel);
        add(UserPasswordTF);
        add(LoginBTN);
        
        LoginBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //Call User WebSErvice
            }
        });
    }
}
