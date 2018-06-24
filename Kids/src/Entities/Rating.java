package Entities;

public class Rating 
{
    protected int ID;
    protected int Rate;
    protected String Description;
    
    public Rating() {
        this.ID = 0;
        this.Rate = 0;
        this.Description = null;
    }
    
    public Rating(int ID) {
        this.ID = ID;
        this.Rate = 0;
        this.Description = null;
    }
    
    public Rating(int ID, int Rate) {
        this.ID = ID;
        this.Rate = Rate;
        this.Description = null;
    }

    public Rating(int ID, int Rate, String Description) {
        this.ID = ID;
        this.Rate = Rate;
        this.Description = Description;
    }
   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
