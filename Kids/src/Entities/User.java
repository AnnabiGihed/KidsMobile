
package Entities;

public class User 
{
    protected int id;
    protected String UserName;
    protected String Password;
    protected String Role;
    

    public User()
    {
        this.UserName = "";
        this.Password = "";
        this.Role = "";
    }
    public User(String UserName, String Password) 
    {
        this.UserName = UserName;
        this.Password = Password;
        
    }
    
    public User(String UserName, String Password, String Role, int id) 
    {
        this.UserName = UserName;
        this.Password = Password;
        this.Role = Role;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "User{" + "UserName=" + UserName + ", Password=" + Password + ", Role=" + Role + '}';
    }   
}
