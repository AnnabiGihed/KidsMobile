package Entities;

public class Pediatrician 
{
    protected int ID;
    protected Address m_Adresss;
    protected Speciality m_Speciality;
    protected String Name;
    protected double Price;
    protected Rating Rating;
    
    public Pediatrician(int ID, Address m_Adresss, Speciality m_Speciality, String Name) {
        this.ID = ID;
        this.m_Adresss = m_Adresss;
        this.m_Speciality = m_Speciality;
        this.Name = Name;
        this.Price = 0.0;
        this.Rating = null;
    }
    
    public Pediatrician(int ID, Address m_Adresss, Speciality m_Speciality, String Name, double Price) {
        this.ID = ID;
        this.m_Adresss = m_Adresss;
        this.m_Speciality = m_Speciality;
        this.Name = Name;
        this.Price = Price;
        this.Rating = null;
    }

    public Pediatrician(int ID, Address m_Adresss, Speciality m_Speciality, String Name, double Price, Rating Rating) {
        this.ID = ID;
        this.m_Adresss = m_Adresss;
        this.m_Speciality = m_Speciality;
        this.Name = Name;
        this.Price = Price;
        this.Rating = Rating;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Address getM_Adresss() {
        return m_Adresss;
    }

    public void setM_Adresss(Address m_Adresss) {
        this.m_Adresss = m_Adresss;
    }

    public Speciality getM_Speciality() {
        return m_Speciality;
    }

    public void setM_Speciality(Speciality m_Speciality) {
        this.m_Speciality = m_Speciality;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Rating getRating() {
        return Rating;
    }

    public void setRating(Rating Rating) {
        this.Rating = Rating;
    }
    
    
}
