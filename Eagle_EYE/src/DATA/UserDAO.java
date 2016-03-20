/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import DATA.DBConnManager;
import DATA.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author SUPIPI
 */
public class UserDAO {
    
    private DBConnManager dbConnManager = null;
//------------create constructer----------------------

    public UserDAO() {
        dbConnManager = new DBConnManager();
    }

    
//--------------------------------------------------------------------------------------------------------------------------------------    

     public boolean addDetails(User us) {

        boolean result = true;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO user( UserId,UserName,UserNIC,Email,Password)"
                    + "VALUES('" +us.getId() + "','" +us.getUName() + "','" +us.getUNic() + "','" +us.getUEmail() + "','" +us.getPassword() + "')";

            System.out.println(query);
            if (stmt.executeUpdate(query) == 1) {
                
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Insert failed");
            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
//-------------------------------------------------------------------------------------------------------------------------
    
   public boolean deleteUser( User us){
        boolean result = true;
	Connection dbConn = null;
        
        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();
            
            String query = "DELETE FROM user WHERE UserId='"+us.getId()+"'";

            System.out.println(query);
            if(stmt.executeUpdate(query) == 1){
            }
            else{
            }
        } 
        catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Delete failed");
            result = false;
        }finally{
            dbConnManager.con_close(dbConn);
        }
        return result;
    }

     
      
}
