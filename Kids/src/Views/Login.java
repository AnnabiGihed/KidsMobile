package Views;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.mycompany.myapp.MyApplication;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Map;

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
        getToolbar().addCommandToLeftBar("Left", null, (e) -> Log.p("Clicked"));
        getToolbar().addCommandToRightBar("Right", null, (e) -> Log.p("Clicked"));
        getToolbar().addCommandToOverflowMenu("Overflow", null, (e) -> Log.p("Clicked"));
        getToolbar().addCommandToSideMenu("Sidemenu", null, (e) -> Log.p("Clicked"));
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
        
        LoginBTN.addActionListener((ActionListener) (ActionEvent evt) -> {
            Connect();
        });
    }
    
    private void Connect()
    {
        try 
        {
            Hashtable data = new Hashtable();
            data.put("username", "admin");
            data.put("password", "admin");
            final String json = Result.fromContent(data).toString();
            ConnectionRequest request = new ConnectionRequest()
            {
                @Override
                protected void buildRequestBody(OutputStream os) throws IOException 
                {
                    os.write(json.getBytes("UTF-8"));
                }
            };
            request.setUrl("http://localhost:8181/kids/web/app_dev.php/auth/login");
            request.setContentType("application/json");
            request.addRequestHeader("username", "admin");
            request.addRequestHeader("password", "admin");
            request.setPost(true);
            NetworkManager.getInstance().addToQueueAndWait(request);
            Map<String,Object> Resualt = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(request.getResponseData()), "UTF-8"));

            if(Resualt != null)
            {
                MyApplication.CurrentUser.setUserName((String)Resualt.get("username"));
                MyApplication.CurrentUser.setPassword((String)Resualt.get("password"));
                //MyApplication.CurrentUser.setUserName((String)Resualt.get("valid"));
                MainMenu Menu = new MainMenu("Menu");
                Menu.show();
            }
        }
        catch(IOException err) 
        {
            Log.e(err);
        }
    }
}
