package Services;

import Entities.Address;
import Entities.Establishment;
import Entities.Event;
import Entities.Rating;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;
import com.mycompany.myapp.Consts;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventService {

    public ArrayList<Event> GetAllEvents() 
    {
        ArrayList<Event> ListEvent = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        String Url = Consts.ServiceUrl + "api/events";
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
                    Event CurrentEvent = new Event();
                    
                    CurrentEvent.setID((int)Float.parseFloat(obj.get("id").toString()));     
                    CurrentEvent.setName(obj.get("name").toString());
                    CurrentEvent.setDescription(obj.get("description").toString());
                    CurrentEvent.setM_Date(RetriveDate((LinkedHashMap<String, Object>)obj.get("date")));
                    CurrentEvent.setM_Establishment(RetriveEstablishment((LinkedHashMap<String, Object>)obj.get("Establishment")));
                    ListEvent.add(CurrentEvent);
                }
                
            } catch (IOException err) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return ListEvent;
    }

    public Date RetriveDate(LinkedHashMap<String, Object> DateMap) 
    {
        float Offset = Float.parseFloat(DateMap.get("offset").toString());
        float timestamp = Float.parseFloat(DateMap.get("timestamp").toString());
        return new Date((long) ((timestamp + Offset) *1000));
    }
    
    public Establishment RetriveEstablishment(LinkedHashMap<String, Object> EstablishmentMap)
    {
        Establishment CurrentEstablishment = new Establishment();
        CurrentEstablishment.setID((int) Float.parseFloat(EstablishmentMap.get("id").toString()));
        CurrentEstablishment.setName(EstablishmentMap.get("name").toString());
        CurrentEstablishment.setDescription(EstablishmentMap.get("description").toString());
        CurrentEstablishment.setM_Address(RetriveAddress((LinkedHashMap<String, Object>)EstablishmentMap.get("address")));
        CurrentEstablishment.setRating(RetriveRating((LinkedHashMap<String, Object>)EstablishmentMap.get("rating")));
        CurrentEstablishment.setPhoto(EstablishmentMap.get("photo").toString());
        return CurrentEstablishment;
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
}
