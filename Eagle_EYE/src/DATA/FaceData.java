/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;



/**
 *
 * @author Kavinda Rasanjana
 */


        

public class FaceData {
    
    
    private int ID;
    private String fname;
    private String lname;
    private String dob;
    private String nic;
    
    
    private DBConnManager dbConnManager = null;

    public FaceData(int ID, String fname, String lname, String dob, String nic) {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.nic = nic;
        
        dbConnManager = new DBConnManager();
    }

    public FaceData(int ID) {
        this.ID = ID;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
    
    

    
    
    
}
