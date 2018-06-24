/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Vaccine;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.myapp.Consts;

/**
 *
 * @author MARWEN
 */
public class VaccinService {
    
    public ArrayList<Vaccine> getList() {
        ArrayList<Vaccine> listVaccins = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = Consts.ServiceUrl + "list_vaccine";
        con.setUrl(Url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();                
                try {
                    Map<String, Object> vaccines = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) vaccines.get("root");
                    for (Map<String, Object> obj : list) {
                        Vaccine vaccine = new Vaccine();
                        float id = Float.parseFloat(obj.get("id").toString());                        
                        vaccine.setId((int) id);
                        vaccine.setName(obj.get("name").toString());
                        float age = Float.parseFloat(obj.get("age").toString());                        
                        vaccine.setAge((int) age);
                        vaccine.setDescription(obj.get("description").toString());
                        vaccine.setDescription(obj.get("effetnegatif").toString());
                        System.out.println(vaccine.getName());
                        listVaccins.add(vaccine);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVaccins;
    }
    
    
    
    
}
