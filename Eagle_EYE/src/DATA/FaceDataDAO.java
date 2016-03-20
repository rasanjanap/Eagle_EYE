/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kavinda Rasanjana
 */
public class FaceDataDAO {
    
    private DBConnManager dbConnManager = null;
        
        public FaceDataDAO ()
        {
            dbConnManager = new DBConnManager();
        }
    
    public ResultSet searchId(FaceData f) {
            ResultSet result = null;
            Connection dbConn = null;
        

        try {
            dbConn = dbConnManager.connect();

            Statement stmt = dbConn.createStatement();

            
            String query = "select * from person_data where ID = '"+f.getID()+"';";
            
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            result = rs;

                     

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------SELECT query failed");

        
        }        
            return result;
          
        
    }
}
