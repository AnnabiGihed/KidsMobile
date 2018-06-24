package com.mycompany.myapp;

import Entities.User;
import Views.BasicMap;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import Views.LoginForm;

public class MyApplication 
{
    
    public static User CurrentUser = new User();
    public static User user;
    private Form current;
    private Resources theme;
    private String username;
    
    
        
    public void init(Object context) 
    {
        theme = UIManager.initFirstTheme("/theme");
        Toolbar.setGlobalToolbar(true);
        Log.bindCrashProtection(true);
        
    }
    
    public void start() 
    {
        if(current != null)
        {
            current.show();
            return;
        }
        
        LoginForm MainForm = new LoginForm(theme);
        MainForm.show();
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
 
    
    public void destroy() {
    }

}
