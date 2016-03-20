/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;


import DATA.DBConnManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gal sajja
 */
public class loginDAO {
    ResultSet loginDetails;
    
    private DBConnManager dbConnManager = null;

    public loginDAO(){
        dbConnManager = new DBConnManager();
    }
    
    public boolean login(loginDetails details){
        
	Connection dbConn = null;
        
        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();
            
            String log = "SELECT `ID`, `username`, `password` FROM `login` WHERE `login`.`username` = '"+details.getUsername()+"' and `login`.`password` = '"+details.getPassword()+"';";
            loginDetails = stmt.executeQuery(log);
            if(loginDetails.first()){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert query failed");
        }finally{
            dbConnManager.con_close(dbConn);
        }        
        return false;

        
    }
}
