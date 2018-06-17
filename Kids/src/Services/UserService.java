/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.Preferences;
import com.codename1.ui.Dialog;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;



/**
 *
 * @author annab
 */
public class UserService 
{
    public boolean login(String username, String password) {
        double status = -1;
        boolean bool = false;
        try {
            ConnectionRequest r = new ConnectionRequest();
            r.setPost(true);
            r.setUrl("http://127.0.0.1:8000/auth/log");
            r.addArgument("username", username);
            r.addArgument("password", password);
            NetworkManager.getInstance().addToQueueAndWait(r);
            Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));
            List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("root");
            for (Map<String, Object> obj : list) {
            if (Float.parseFloat(obj.get("status").toString())  == 1)
            {   
                Preferences.set("username",username);
                bool = true;
                
            } else {
                System.out.println("failure");
            }
            }
        } catch (Exception e) {
            Dialog.show("An error has occured", "Server might be down", "ok","cancel");
        }

        return bool;
    }
    

}
