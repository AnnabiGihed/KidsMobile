package Entities;
public class Establishment 
{
    protected int ID;
    protected Address m_Address;
    protected String Name;
    protected String Description;
    protected String Photo;
    protected Rating Rating;
    
    public Establishment() {
        this.ID = 0;
        this.m_Address = null;
        this.Name = null;
        this.Description = null;
        this.Photo = null;
        this.Rating = null;
    }
    
    public Establishment(int ID) {
        this.ID = ID;
        this.m_Address = null;
        this.Name = null;
        this.Description = null;
        this.Photo = null;
        this.Rating = null;
    }
    
    public Establishment(int ID, Address m_Address) {
        this.ID = ID;
        this.m_Address = m_Address;
        this.Name = null;
        this.Description = null;
        this.Photo = null;
        this.Rating = null;
    }
    public Establishment(int ID, Address m_Address, String Name) {
        this.ID = ID;
        this.m_Address = m_Address;
        this.Name = Name;
        this.Description = null;
        this.Photo = null;
        this.Rating = null;
    }
    
    public Establishment(int ID, Address m_Address, String Name, String Description) {
        this.ID = ID;
        this.m_Address = m_Address;
        this.Name = Name;
        this.Description = Description;
        this.Photo = null;
        this.Rating = null;
    }
    
    public Establishment(int ID, Address m_Address, String Name, String Description, String Photo) {
        this.ID = ID;
        this.m_Address = m_Address;
        this.Name = Name;
        this.Description = Description;
        this.Photo = Photo;
        this.Rating = null;
    }

    public Establishment(int ID, Address m_Address, String Name, String Description, String Photo, Rating Rating) {
        this.ID = ID;
        this.m_Address = m_Address;
        this.Name = Name;
        this.Description = Description;
        this.Photo = Photo;
        this.Rating = Rating;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Address getM_Address() {
        return m_Address;
    }

    public void setM_Address(Address m_Address) {
        this.m_Address = m_Address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public Rating getRating() {
        return Rating;
    }

    public void setRating(Rating Rating) {
        this.Rating = Rating;
    }
    
    
    
}
