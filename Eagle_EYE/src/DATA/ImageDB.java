
//package control.faceRecognizer;

import java.io.*;
import java.sql.*;


public class ImageDB {

    public static void main(String[] args) 
    {
    try{
    InputStream sImage;
    PreparedStatement pre=null;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eagleeye", "root", "1234" );
    String imagename[]={"./image/5408.jpg"};
    File imgfile[] = new File[9];
    for(int i=0;i<imgfile.length;i++){
        imgfile[i]=new File(imagename[i]);
        FileInputStream fin = new FileInputStream(imgfile[i]);
      pre = con.prepareStatement("insert into image( imageid) values ( ?)");
      pre.setString(1,imgfile[i].getName());
      pre.setBinaryStream(2,fin,(int)imgfile[i].length());
      pre.executeUpdate();
    }
      System.out.println("Inserting Successfully!");
      pre.close();
      con.close();
}
catch(Exception ex){
System.out.println("error :"+ex);
}

    new ImageDB();
    }
}

