package Entities;

public class Speciality 
{
    protected int id;
    protected String name;
    protected String Description;
    
    public Speciality() {
        this.id = 0;
        this.name = null;
        this.Description = null;
    }
    
    public Speciality(int id) {
        this.id = id;
        this.name = null;
        this.Description = null;
    }
    
    public Speciality(int id, String name) {
        this.id = id;
        this.name = name;
        this.Description = null;
    }

    public Speciality(int id, String name, String Description) {
        this.id = id;
        this.name = name;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
