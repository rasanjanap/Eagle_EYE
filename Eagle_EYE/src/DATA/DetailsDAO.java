/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import DATA.DBConnManager;
import DATA.Details;
//import com.alee.laf.table.WebTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SUPIPI
 */
public class DetailsDAO {

    private DBConnManager dbConnManager = null;
//------------create constructer----------------------

    public DetailsDAO() {
        dbConnManager = new DBConnManager();
    }

//--------------------------------------------------------------------------------------------------------------------------------------    
    public boolean addDetails(Details dl) {

        boolean result = true;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO person( NIC,Name,DOB,TelNo,Address,City,Email,Details)"
                    + "VALUES('" + dl.getNIC() + "','" + dl.getName() + "','" + dl.getDOB() + "','" + dl.getTelNo() + "','" + dl.getAddress() + "','" + dl.getCity() + "','" + dl.getEmail() + "','" + dl.getDetails() + "')";

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

//-------------------------------------------------------------------------------------------------------------------------
    }

    public boolean addImg(Details d2) {

        boolean result = true;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "INSERT INTO image( imageid,Name,imgpath)"
                    + "VALUES('" + d2.getNIC() + "','" + d2.getName() + "','" + d2.getImgpath() + "')";

            System.out.println("hii");

            System.out.println(query);
            if (stmt.executeUpdate(query) == 1) {

            }
        } catch (SQLException sQLException) {

            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;

    }
    //---------------------------------------------------------------------------------------------------------------------------

    public boolean chkuser(Details dl) {

        boolean result = true;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select * from login";

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
//--------------------------------------------------------------------------------------------------------------------------

    public void searchPerson(String keyword, JTable j) {
        Connection dbConn = null;
        ResultSet rs = null;
        JTable wt = (JTable) j;
        DefaultTableModel dtm = (DefaultTableModel) wt.getModel();

        try {
            dbConn = dbConnManager.connect();
            java.sql.Statement stmt = dbConn.createStatement();

            String query = "SELECT * FROM person where NIC like '" + keyword + "%' ";

            rs = stmt.executeQuery(query);

            for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
                dtm.removeRow(i);
            }

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("NIC"));
                v.add(rs.getString("Name"));
                v.add(rs.getString("DOB"));
                v.add(rs.getString("TelNo"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("City"));
                v.add(rs.getString("Email"));
                v.add(rs.getString("Details"));

                dtm.addRow(v);
            }
        } catch (SQLException e) {
            System.out.println(e + "-----------Search searchPerson query failed");

        }

    }

    //---------------------------------------------------------------------------------------------------------------------------------
    public Vector getdetails() { //return type is vector

        Vector<Vector<String>> printDetailsVector = null;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "select p.NIC,p.Name,p.DOB,p.Telno,p.Address,p.City,p.Email,p.Details FROM  person p ";

            ResultSet rs = stmt.executeQuery(query);
            printDetailsVector = new Vector<Vector<String>>();//initilizied the vector

            while (rs.next()) {
                Vector<String> printDetails = new Vector<String>();//creating a new vector called  details

                printDetails.add(rs.getString(1)); //NIC
                printDetails.add(rs.getString(2)); //Name
                printDetails.add(rs.getString(3)); //DOB
                printDetails.add(rs.getString(4)); //TelNo
                printDetails.add(rs.getString(5)); //Address
                printDetails.add(rs.getString(6)); //City
                printDetails.add(rs.getString(7)); //Email
                printDetails.add(rs.getString(8)); //Details

                printDetailsVector.add(printDetails);
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Select query failed");
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return printDetailsVector;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------
    public boolean updatePerson(Details dl) {
        boolean result = true;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "UPDATE person SET Name='" + dl.getName() + "',DOB='" + dl.getDOB()
                    + "',Telno='" + dl.getTelNo() + "',Address='" + dl.getAddress()
                    + "',City='" + dl.getCity() + "',Email='" + dl.getEmail() + "',Details='" + dl.getDetails()
                    + "' WHERE ID='" + dl.getNIC() + "' ";

            System.out.println(query);
            if (stmt.executeUpdate(query) == 1) {

            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Updated failed");
            result = false;

        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean deletePerson(Details dl) {
        boolean result = true;
        Connection dbConn = null;

        try {
            dbConn = dbConnManager.connect();
            Statement stmt = dbConn.createStatement();

            String query = "DELETE FROM person WHERE NIC='" + dl.getNIC() + "'";

            String CheckAvailableUser = "SELECT * FROM person where NIC='" + dl.getNIC() + "%' ";

            ResultSet rs = stmt.executeQuery(CheckAvailableUser);
            if (rs.getRow() == 0) {
                System.out.println(query);
                if (stmt.executeUpdate(query) == 1) {
                    JOptionPane.showMessageDialog(null, "delete successful");
                } else {
                    JOptionPane.showMessageDialog(null, "nic number not found.");
                }
            }

        } catch (SQLException sQLException) {
            System.out.println(sQLException + "-----------Delete failed");
            result = false;
        } finally {
            dbConnManager.con_close(dbConn);
        }
        return result;
    }

}
