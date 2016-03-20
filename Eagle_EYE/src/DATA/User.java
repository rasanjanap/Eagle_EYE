/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;


public class User {
    
    private String Id ;
    private String UName;
    private String UNic;
    private String UEmail;
    private String Password;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUNic() {
        return UNic;
    }

    public void setUNic(String UNic) {
        this.UNic = UNic;
    }

    public String getUEmail() {
        return UEmail;
    }

    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public User(String Id, String UName, String UNic, String UEmail, String Password) {
        this.Id = Id;
        this.UName = UName;
        this.UNic = UNic;
        this.UEmail = UEmail;
        this.Password = Password;
    }
    
     public User(String Id) {
        this.Id=Id;
    }
    
    
}
