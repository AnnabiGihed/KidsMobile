package Entities;

import java.util.Date;

public class Event 
{
    protected int ID;
    protected String Name;
    protected String Description;
    protected Date m_Date;
    protected Establishment m_Establishment;
    protected String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    
    public Event() {
        this.ID = 0;
        this.Name = null;
        this.Description = null;
        this.m_Date = null;
        this.m_Establishment = null;
    }
    
    public Event(int ID) {
        this.ID = ID;
        this.Name = null;
        this.Description = null;
        this.m_Date = null;
        this.m_Establishment = null;
    }
    
    public Event(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
        this.Description = null;
        this.m_Date = null;
        this.m_Establishment = null;
    }
    
    public Event(int ID, String Name, String Description) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.m_Date = null;
        this.m_Establishment = null;
    }
        
    public Event(int ID, String Name, String Description, Date m_Date) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.m_Date = m_Date;
        this.m_Establishment = null;
    }

    public Event(int ID, String Name, String Description, Date m_Date, Establishment m_Establishment) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.m_Date = m_Date;
        this.m_Establishment = m_Establishment;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Date getM_Date() {
        return m_Date;
    }

    public void setM_Date(Date m_Date) {
        this.m_Date = m_Date;
    }

    public Establishment getM_Establishment() {
        return m_Establishment;
    }

    public void setM_Establishment(Establishment m_Establishment) {
        this.m_Establishment = m_Establishment;
    }
    
    
    
    
}
