/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import javax.print.DocFlavor;

/**
 *
 * @author SUPIPI
 */
public class Details {
    
    private String NIC ;
    private String Name;
    private String DOB;
    private String TelNo;
    private String Address;
    private String City;
    private String Email;
    private String Details;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
    
    private String imageid;
    private String imgpath;
   
    
    
    
    
    public Details(String NIC,String Name, String DOB,String TelNo,String Address,String City,String Email,String Details, String imgpath)
    {
       this.NIC= NIC;
       this.Name= Name;
       this.DOB = DOB;
       this.TelNo = TelNo;
       this.Address = Address;
       this.City = City;
       this.Email = Email;
       this.Details = Details;
       this.imageid= imageid;
       this.imgpath = imgpath; 
        
    }

    public Details(String NIC) {
        this.NIC = NIC;
    }
    
//    public Details(String imageid, String imgpath)
//    {
//       this.imageid= imageid;
//       this.DOB = imgpath; 
//        
//    }
 
    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getTelNo() {
        return TelNo;
    }

    public void setTelNo(String TelNo) {
        this.TelNo = TelNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }
    
    
}
