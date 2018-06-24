package Entities;

public class Address 
{
    protected int id;
    protected double longitude;
    protected double latitude;
    protected String Rue;
    protected String Governorate;
    
    public Address(){
        id = 0;
        longitude = 0;
        latitude = 0;
        Rue = null;
        Governorate = null;
    }
    
    public Address(int id) 
    {
        this.id = id;
        longitude = 0;
        latitude = 0;
        Rue = null;
        Governorate = null;
    }
    
    public Address(int id, double longitude, double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        Rue = null;
        Governorate = null;
    }
    
    public Address(int id, double longitude, double latitude, String Rue) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Rue = Rue;
        Governorate = null;
    }

    public Address(int id, double longitude, double latitude, String Rue, String Governorate) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.Rue = Rue;
        this.Governorate = Governorate;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getRue() {
        return Rue;
    }

    public void setRue(String Rue) {
        this.Rue = Rue;
    }

    public String getGovernorate() {
        return Governorate;
    }

    public void setGovernorate(String Governorate) {
        this.Governorate = Governorate;
    }
    
    
}
