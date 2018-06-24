package Services;

import Entities.Speciality;
import Entities.Address;
import Entities.Pediatrician;
import Entities.Rating;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.mycompany.myapp.Consts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PediatricianService 
{
    public ArrayList<Pediatrician> GetAllPediatrician() 
    {
        ArrayList<Pediatrician> ListPediatrician = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = Consts.ServiceUrl + "api/pediatricians";
        con.setUrl(Url);
        con.setPost(false);
        NetworkManager.getInstance().addToQueueAndWait(con);
        con.addResponseListener((NetworkEvent evt)-> 
        {
            JSONParser json = new JSONParser();
            Map<String, Object> data;
            try 
            {
                data = json.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) data.get("root");
                for (Map<String, Object> obj : content) 
                {
                    Pediatrician CurrentPediatrician = new Pediatrician();
                    
                    CurrentPediatrician.setID((int)Float.parseFloat(obj.get("id").toString()));     
                    CurrentPediatrician.setName(obj.get("name").toString());
                    CurrentPediatrician.setPhoneNumber(obj.get("tel").toString());
                    CurrentPediatrician.setM_Adresss(RetriveAddress((LinkedHashMap<String, Object>)obj.get("address")));
                    CurrentPediatrician.setPrice(Float.parseFloat(obj.get("price").toString()));
                    CurrentPediatrician.setM_Speciality(RetriveSpeciality((LinkedHashMap<String, Object>)obj.get("speciality")));
                    CurrentPediatrician.setRating(RetriveRating((LinkedHashMap<String, Object>)obj.get("rating")));
                    ListPediatrician.add(CurrentPediatrician);
                }
                
            } catch (IOException err) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListPediatrician;
    }
    public Address RetriveAddress(LinkedHashMap<String, Object> AddressMap)
    {
        Address CurrentAddress = new Address();
        CurrentAddress.setId((int) Float.parseFloat(AddressMap.get("id").toString()));
        CurrentAddress.setLongitude(Float.parseFloat(AddressMap.get("longitude").toString()));
        CurrentAddress.setLatitude(Float.parseFloat(AddressMap.get("latitude").toString()));
        CurrentAddress.setRue(AddressMap.get("rue").toString());
        CurrentAddress.setRue(AddressMap.get("governorate").toString());
        return CurrentAddress;
    }
    
    public Rating RetriveRating(LinkedHashMap<String, Object> RatingMap)
    {
        Rating CurrentRating = new Rating();
        CurrentRating.setID((int) Float.parseFloat(RatingMap.get("id").toString()));
        CurrentRating.setRate((int) Float.parseFloat(RatingMap.get("rate").toString()));
        CurrentRating.setDescription(RatingMap.get("description").toString());
        return CurrentRating;
    }
    
    public Speciality RetriveSpeciality(LinkedHashMap<String, Object> SpecialityMap)
    {
        Speciality  CurrentSpeciality = new Speciality();
        CurrentSpeciality.setId((int) Float.parseFloat(SpecialityMap.get("id").toString()));
        CurrentSpeciality.setName(SpecialityMap.get("name").toString());
        CurrentSpeciality.setDescription(SpecialityMap.get("description").toString());
        return CurrentSpeciality;
    }
    
}
